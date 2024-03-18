package top.dooc.shortlink.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.redisson.api.RBloomFilter;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dooc.shortlink.common.convention.exception.ClientException;
import top.dooc.shortlink.common.convention.exception.ServiceException;
import top.dooc.shortlink.common.enums.UserErrorCodeEnums;
import top.dooc.shortlink.dao.entity.UserDO;
import top.dooc.shortlink.dao.mapper.UserMapper;
import top.dooc.shortlink.dto.request.UserRegisterReqDTO;
import top.dooc.shortlink.dto.response.UserRespDTO;
import top.dooc.shortlink.service.UserService;

import static top.dooc.shortlink.common.constant.RedisCacheConstant.LOCK_USER_REGISTER_KEY;
import static top.dooc.shortlink.common.enums.UserErrorCodeEnums.*;

/**
 * @author aaronchen
 * @date 2024/3/15 下午4:32
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private RBloomFilter<String> userRegisterCachePenetrationBloomFilter;
    @Autowired
    private RedissonClient redissonClient;
    @Override
    public UserRespDTO getUserByUsername(String username) {
        // 1. 构建条件构造器
        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username", username);
        UserDO user  = userMapper.selectOne(queryWrapper);
        if(user==null)
        {
            throw  new ClientException(UserErrorCodeEnums.USER_NULL);
        }
        // 2. 将查到的数据封装到respDto对象上面，将数据进行返回
        UserRespDTO userRespDTO = new UserRespDTO();
        BeanUtils.copyProperties(user, userRespDTO);

        return userRespDTO;
    }

    @Override
    public Boolean hasUserName(String username) {
         return userRegisterCachePenetrationBloomFilter.contains(username);
//        QueryWrapper<UserDO> queryWrapper = new QueryWrapper<>();
//        queryWrapper.eq("username", username);
//        UserDO user  = userMapper.selectOne(queryWrapper);
//        if(user==null)
//        {
//            return false;
//        }
//        return true;
    }

    @Override
    public void register(UserRegisterReqDTO requestParam) {
        // 先去布隆过滤器判断是否存在
        if(hasUserName(requestParam.getUsername()))
        {
            throw new ClientException(USER_EXIST);
        }
        // 用分布式锁防止短时间内恶意提交重复用户名
        RLock lock = redissonClient.getLock(LOCK_USER_REGISTER_KEY + requestParam.getUsername());
        try {
            if(lock.tryLock()){
                int insert = userMapper.insert(BeanUtil.toBean(requestParam, UserDO.class));
                if(insert<1)
                {
                    throw new ServiceException(USER_SAVE_ERROR);
                }
                userRegisterCachePenetrationBloomFilter.add(requestParam.getUsername());
                return;
            }
            throw new ClientException(USER_NAME_EXIST);
        }
        finally {
            lock.unlock();
        }
    }
}
