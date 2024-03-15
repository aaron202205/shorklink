package top.dooc.shorklink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dooc.shorklink.dto.response.UserRespDTO;
import top.dooc.shorklink.service.UserService;

/**
 * @author aaronchen
 * @date 2024/3/15 下午3:54
 */
@RestController

// 此注解作用和@Autowired一样
// @RequiredArgsConstructor
public class UserController {
    /**
     * 根据username获取用户
     * @param username
     * @return
     */
    @Autowired
    private UserService userService;
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public UserRespDTO getUserByUserName(@PathVariable String username){
        return userService.getUserByUsername(username);
    }
}

