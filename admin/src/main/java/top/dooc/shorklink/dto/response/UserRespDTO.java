package top.dooc.shorklink.dto.response;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/15 下午4:15
 */
@Data
public class UserRespDTO {
    /**
     *
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
