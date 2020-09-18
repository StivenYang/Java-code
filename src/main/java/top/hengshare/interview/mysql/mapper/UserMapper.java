package top.hengshare.interview.mysql.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import top.hengshare.interview.mysql.model.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {
}