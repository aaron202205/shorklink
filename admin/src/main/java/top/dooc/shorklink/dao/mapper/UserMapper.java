package top.dooc.shorklink.dao.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.dooc.shorklink.dao.entity.UserDO;

/**
 * @author aaronchen
 * @date 2024/3/15 下午4:44
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {
}
