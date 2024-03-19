package top.dooc.shortlink.service;

import top.dooc.shortlink.dto.request.ShortLinkGroupUpdateReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkGroupRespDTO;

import java.util.List;

/**
 * @author aaronchen
 * @date 2024/3/18 下午9:54
 */
public interface GroupService {
    void saveGroup(String groupName);
    /**
     * 查询短链接分组
     * @return 短链接分组
     */
    List<ShortLinkGroupRespDTO> lisGroup();

    void updateGroup(ShortLinkGroupUpdateReqDTO reqDTO);

    void deleteGroup(String gid);
}
