package top.dooc.shortlink.dto.request;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/19 上午10:38
 */
@Data
public class ShortLinkGroupUpdateReqDTO {
    /**
     * 分组标识
     */
    private String gid;

    /**
     * 分组名称
     */
    private String name;
}
