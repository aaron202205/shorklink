package top.dooc.shorklink.admin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author aaronchen
 * @date 2024/3/15 下午3:54
 */
@RestController
public class UserController {
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public String getUserByUserName(@PathVariable String username) {
        return "username:" + username;
    }
}

