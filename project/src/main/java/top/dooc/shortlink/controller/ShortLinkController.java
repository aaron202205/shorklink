package top.dooc.shortlink.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import top.dooc.shortlink.common.convention.result.Result;
import top.dooc.shortlink.common.convention.result.Results;
import top.dooc.shortlink.dto.request.ShortLinkCreateReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkCreateRespDTO;
import top.dooc.shortlink.service.ShortLinkService;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:15
 */
@RestController
public class ShortLinkController {
   @Autowired
   private ShortLinkService shortLinkService;

    /**
     * 创建短链接
     * @param requestParam 短链接创建参数
     * @return ShortLinkCreateRespDTO
     */
    @PostMapping("/api/short-link/admin/v1/create")
    public Result<ShortLinkCreateRespDTO> create(@RequestBody ShortLinkCreateReqDTO requestParam){
        return Results.success(shortLinkService.createShortLink(requestParam));
    }
}
