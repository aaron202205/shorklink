package top.dooc.shortlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.redisson.api.RBloomFilter;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dooc.shortlink.common.convention.exception.ClientException;
import top.dooc.shortlink.common.enums.UserErrorCodeEnums;
import top.dooc.shortlink.dao.entity.UserDO;
import top.dooc.shortlink.dao.mapper.UserMapper;
import top.dooc.shortlink.dto.response.UserRespDTO;
import top.dooc.shortlink.service.UserService;

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
}
