package top.dooc.shortlink.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dooc.shortlink.dao.entity.GroupDO;
import top.dooc.shortlink.dao.mapper.GroupMapper;
import top.dooc.shortlink.service.GroupService;
import top.dooc.shortlink.toolkit.RandomGenerator;

/**
 * @author aaronchen
 * @date 2024/3/18 下午9:54
 */
@Service
public class GroupServiceImpl implements GroupService {
    @Autowired
    private GroupMapper groupMapper;
    @Override
    public void saveGroup(String groupName) {
        String gid;
        do {
            gid = RandomGenerator.generateRandom();
        } while (hasGid(gid));

        GroupDO groupDO = GroupDO.builder()
                .name(groupName)
                .sortOrder(0)
                .gid(gid)
                .build();

        groupMapper.insert(groupDO);
    }
    private boolean hasGid(String gid){
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                // TODO 检测登陆状态，设置用户名
                .eq(GroupDO::getName, null);
        return groupMapper.selectOne(queryWrapper) != null;
    }
}
