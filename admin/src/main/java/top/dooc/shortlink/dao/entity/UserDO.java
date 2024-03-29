package top.dooc.shortlink.dao.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import top.dooc.shortlink.common.database.BaseDO;

/**
 * @author aaronchen
 * @date 2024/3/15 下午4:42
 */
@Data
@TableName("t_user")
public class UserDO extends BaseDO {
    /**
     * id
     */
    private Long id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

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

    /**
     * 注销时间戳
     */
    private Long deletionTime;
}
