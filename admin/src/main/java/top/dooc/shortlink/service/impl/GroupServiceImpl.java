package top.dooc.shortlink.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dooc.shortlink.common.biz.user.UserContext;
import top.dooc.shortlink.dao.entity.GroupDO;
import top.dooc.shortlink.dao.mapper.GroupMapper;
import top.dooc.shortlink.dto.request.ShortLinkGroupUpdateReqDTO;
import top.dooc.shortlink.dto.request.ShortLinkGroupUpdateSortReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkGroupRespDTO;
import top.dooc.shortlink.service.GroupService;
import top.dooc.shortlink.toolkit.RandomGenerator;

import java.util.List;

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

    /**
     * 查询短链接分组
     * @return 短链接分组
     */
    @Override
    public List<ShortLinkGroupRespDTO> lisGroup() {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .orderByDesc(GroupDO::getSortOrder, GroupDO::getUpdateTime);
        List<GroupDO> groupDOS = groupMapper.selectList(queryWrapper);
        return BeanUtil.copyToList(groupDOS, ShortLinkGroupRespDTO.class);
    }

    @Override
    public void updateGroup(ShortLinkGroupUpdateReqDTO reqDTO) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, reqDTO.getGid());
        GroupDO groupDO = new GroupDO();
        groupDO.setName(reqDTO.getName());
        groupMapper.update(groupDO, queryWrapper);
    }

    @Override
    public void deleteGroup(String gid) {
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getDelFlag, 0)
                .eq(GroupDO::getUsername, UserContext.getUsername())
                .eq(GroupDO::getGid, gid);
        GroupDO groupDO = new GroupDO();
        groupDO.setDelFlag(1);
        groupMapper.update(groupDO, queryWrapper);
    }

    @Override
    public void updateGroupSort(List<ShortLinkGroupUpdateSortReqDTO> requestParam) {
        requestParam.forEach(reqDTO -> {
            GroupDO groupDO = GroupDO.builder()
                    .sortOrder(reqDTO.getSortOrder())
                    .build();
            LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class);
            queryWrapper.eq(GroupDO::getGid, reqDTO.getGid())
                    .eq(GroupDO::getUsername, UserContext.getUsername())
                    .eq(GroupDO::getDelFlag, 0);
            groupMapper.update(groupDO, queryWrapper);
        });
    }

    private boolean hasGid(String gid){
        LambdaQueryWrapper<GroupDO> queryWrapper = Wrappers.lambdaQuery(GroupDO.class)
                .eq(GroupDO::getGid, gid)
                .eq(GroupDO::getName, UserContext.getUsername());
        return groupMapper.selectOne(queryWrapper) != null;
    }
}
