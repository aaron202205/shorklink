package top.dooc.shortlink.dto.response;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/18 下午10:37
 */
@Data
public class ShortLinkGroupRespDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;

    /**
     * 创建分组用户名
     */
    private String username;

    /**
     * 分组排序
     */
    private Integer sortOrder;
}
