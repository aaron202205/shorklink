package top.dooc.shortlink.dto.request;

import lombok.Data;

/**
 * @author aaronchen
 * @date 2024/3/18 下午9:13
 */
@Data
public class UserLoginReqDTO {
    private String username;
    private String password;
}
