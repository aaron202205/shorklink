package top.dooc.shorklink.service;

import top.dooc.shorklink.dto.response.UserRespDTO;

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
}
