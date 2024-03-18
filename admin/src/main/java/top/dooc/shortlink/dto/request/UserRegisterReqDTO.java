package top.dooc.shortlink.dto.request;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/18 上午11:25
 */
@Data
public class UserRegisterReqDTO {
    private String username; // 用户名
    private String password; // 密码
    private String realName; // 真实姓名
    private String phone; // 手机号
    private String mail; // 邮箱

}
