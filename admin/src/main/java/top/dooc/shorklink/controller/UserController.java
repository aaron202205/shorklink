package top.dooc.shorklink.controller;

import lombok.val;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import top.dooc.shorklink.common.convention.result.Result;
import top.dooc.shorklink.common.enums.UserErrorCodeEnums;
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
    public Result<UserRespDTO> getUserByUserName(@PathVariable String username){
        //构造统一返回result
        UserRespDTO userRespDTO = userService.getUserByUsername(username);
        if(userRespDTO==null)
        {
            return new Result<UserRespDTO>().setCode(UserErrorCodeEnums.USER_NULL.code())
                    .setMessage(UserErrorCodeEnums.USER_NULL.message());
        }
        else {
            return new Result<UserRespDTO>().setCode(Result.SUCCESS_CODE).setData(userRespDTO);
        }

    }
}

