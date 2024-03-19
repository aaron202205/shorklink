package top.dooc.shortlink.dto.request;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/19 上午10:49
 */
@Data
public class ShortLinkGroupUpdateSortReqDTO {

    private String gid;
    private Integer sortOrder;
}
