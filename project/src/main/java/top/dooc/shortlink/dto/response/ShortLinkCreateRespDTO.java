package top.dooc.shortlink.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:22
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ShortLinkCreateRespDTO {
    private String gid; // 分组标识
    private String shortUri; // 短链接
    private String originUrl; // 原始链接
}
