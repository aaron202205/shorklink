package top.dooc.shortlink.dto.response;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.Data;
import top.dooc.shortlink.common.serialize.PhoneDesensitizationSerializer;

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
     * 手机号 (脱敏)
     */
    @JsonSerialize(using = PhoneDesensitizationSerializer.class)
    private String phone;

    /**
     * 邮箱
     */
    private String mail;
}
