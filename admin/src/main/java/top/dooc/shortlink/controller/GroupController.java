package top.dooc.shortlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import top.dooc.shortlink.common.convention.result.Result;
import top.dooc.shortlink.common.convention.result.Results;
import top.dooc.shortlink.dto.request.ShortLinkGroupSaveReqDTO;
import top.dooc.shortlink.service.GroupService;
import top.dooc.shortlink.service.UserService;

/**
 * @author aaronchen
 * @date 2024/3/18 下午9:57
 */
@RestController
public class GroupController {
    @Autowired
    private GroupService groupService;

    /**
     * 新增短链接分组
     * @param requestParam 请求参数
     * @return void
     */
    @PostMapping("/api/short-link/admin/v1/group")
    public Result<Void> save(@RequestParam ShortLinkGroupSaveReqDTO requestParam)
    {
        groupService.saveGroup(requestParam.getName());
        return Results.success();
    }
}
