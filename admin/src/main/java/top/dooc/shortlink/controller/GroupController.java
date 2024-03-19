package top.dooc.shortlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import top.dooc.shortlink.common.convention.result.Result;
import top.dooc.shortlink.common.convention.result.Results;
import top.dooc.shortlink.dto.request.ShortLinkGroupSaveReqDTO;
import top.dooc.shortlink.dto.request.ShortLinkGroupUpdateReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkGroupRespDTO;
import top.dooc.shortlink.service.GroupService;

import java.util.List;

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
    /**
     * 查询短链接分组
     * @return 短链接分组
     */
    @GetMapping("/api/short-link/admin/v1/group")
    public Result<List<ShortLinkGroupRespDTO>> listGroup(){
        return Results.success(groupService.lisGroup());
    }

    /**
     * 修改短链接分组名称
     * @param requestParam 修改名称与修改对象
     * @return void
     */
    @PutMapping("/api/short-link/admin/v1/group")
    public Result<Void> updateGroup(@RequestBody ShortLinkGroupUpdateReqDTO requestParam)
    {
        groupService.updateGroup(requestParam);
        return Results.success();
    }
}
