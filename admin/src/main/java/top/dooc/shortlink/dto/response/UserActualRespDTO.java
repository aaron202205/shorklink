package top.dooc.shortlink.dto.response;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/16 下午2:44
 */
@Data
public class UserActualRespDTO {
    /**
     * id
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
     * 手机号, 无脱敏
     */
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
