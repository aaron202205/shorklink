package top.dooc.shortlink.controller;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dooc.shortlink.common.convention.result.Result;
import top.dooc.shortlink.common.convention.result.Results;
import top.dooc.shortlink.dto.request.UserRegisterReqDTO;
import top.dooc.shortlink.dto.request.UserUpdateReqDTO;
import top.dooc.shortlink.dto.response.UserActualRespDTO;
import top.dooc.shortlink.dto.response.UserRespDTO;
import top.dooc.shortlink.service.UserService;

/**
 * @author aaronchen
 * @date 2024/3/15 下午3:54
 */
@RestController

// 此注解作用和@Autowired一样
// @RequiredArgsConstructor
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * 根据username获取用户（手机号已脱敏）
     * @param username
     * @return
     */
    @GetMapping("/api/short-link/admin/v1/user/{username}")
    public Result<UserRespDTO> getUserByUserName(@PathVariable String username){
        //构造统一返回result
        UserRespDTO userRespDTO = userService.getUserByUsername(username);
        return Results.success(userRespDTO);

    }
    /**
     * 根据用户名查询用户(手机号未脱敏)
     * @param username
     * @return UserRespDTO
     */
    @GetMapping("/api/short-link/admin/v1/actual/user/{username}")
    public Result<UserActualRespDTO> getActualUserByUserName(@PathVariable String username){
        return Results.success(BeanUtil.toBean(userService.getUserByUsername(username), UserActualRespDTO.class));
    }

    /**
     * 查询用户名是否存在
     * @param username
     * @return 存在返回false，不存在返回ture
     */
    @GetMapping("/api/short-link/admin/v1/user/has-username")
    public Result<Boolean> hasUserName(@RequestParam String username){
        return Results.success(userService.hasUserName(username));
    }

    @PostMapping("/api/short-link/admin/v1/user/")
    public Result<Void> register(@RequestBody UserRegisterReqDTO userRegisterReqDTO){
        userService.register(userRegisterReqDTO);
        return Results.success();
    }
    /**
     * 根据用户名修改用户信息
     * @param requestParam 传递参数
     * @return void
     */
    @PutMapping("/api/short-link/admin/v1/user/")
    public Result<Void> update(@RequestBody UserUpdateReqDTO requestParam){
        userService.update(requestParam);
        return Results.success();
    }
}