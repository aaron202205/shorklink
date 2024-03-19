package top.dooc.shortlink.dto.request;

import lombok.Data;

import java.util.Date;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:20
 */
@Data
public class ShortLinkCreateReqDTO {
    private String domain; // 域名
    private String originUrl; // 原始链接
    private String gid; // 分组标识
    private int createdType; // 创建类型 0：接口创建 1：控制台创建
    private int validDateType; // 有效期类型 0：永久有效 1：自定义
    private Date validDate; // 有效期
    private String describe; // 描述
}
