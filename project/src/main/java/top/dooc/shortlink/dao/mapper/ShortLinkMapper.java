package top.dooc.shortlink.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dooc.shortlink.dao.entity.ShortLinkDO;

/**
 * @author aaronchen
 * @date 2024/3/19 上午11:18
 */
@Mapper
public interface ShortLinkMapper extends BaseMapper<ShortLinkDO> {
}
