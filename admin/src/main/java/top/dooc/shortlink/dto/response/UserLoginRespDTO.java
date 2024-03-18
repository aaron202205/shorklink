package top.dooc.shortlink.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author aaronchen
 * @date 2024/3/18 下午9:14
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserLoginRespDTO {
    private String token; //  登陆token 与redis 登陆信息对应
}
