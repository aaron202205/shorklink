package top.dooc.shortlink.service;

import top.dooc.shortlink.dto.response.UserRespDTO;

/**
 * @author aaronchen
 * @date 2024/3/15 下午4:30
 */
public interface UserService {
    /**
     * 根据用户名获取用户
     * @param username
     * @return
     */
    UserRespDTO getUserByUsername(String username);

    Boolean hasUserName(String username);
}
