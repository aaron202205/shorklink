package top.dooc.shortlink.service.impl;

import cn.hutool.core.bean.BeanUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.dooc.shortlink.dao.entity.ShortLinkDO;
import top.dooc.shortlink.dao.mapper.ShortLinkMapper;
import top.dooc.shortlink.dto.request.ShortLinkCreateReqDTO;
import top.dooc.shortlink.dto.response.ShortLinkCreateRespDTO;
import top.dooc.shortlink.service.ShortLinkService;
import top.dooc.shortlink.toolkit.HashUtil;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:38
 */
@Service
public class ShortLinkServiceImpl implements ShortLinkService {
    @Autowired
    private ShortLinkMapper shortLinkMapper;
    @Override
    public ShortLinkCreateRespDTO createShortLink(ShortLinkCreateReqDTO requestParam) {
        String shortLinkSuffix = generateSuffix(requestParam);

        ShortLinkDO shortLinkDO = BeanUtil.toBean(requestParam, ShortLinkDO.class);
        shortLinkDO.setEnableStatus(0);
        shortLinkDO.setShortUri(shortLinkSuffix);
        shortLinkDO.setFullShortUrl(requestParam.getDomain() + "/" + shortLinkSuffix);
        shortLinkMapper.insert(shortLinkDO);

        return ShortLinkCreateRespDTO
                .builder()
                .gid(requestParam.getGid())
                .shortUri(shortLinkSuffix)
                .originUrl(requestParam.getOriginUrl())
                .build();
    }

    private String generateSuffix(ShortLinkCreateReqDTO requestParam) {
        String originUrl = requestParam.getOriginUrl();
        return HashUtil.hashToBase62(originUrl);
    }
}
