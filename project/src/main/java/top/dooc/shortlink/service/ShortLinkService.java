package top.dooc.shortlink.service;

import top.dooc.shortlink.dto.request.ShortLinkCreateReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkCreateRespDTO;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:30
 */
public interface ShortLinkService {
    ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam);
}
