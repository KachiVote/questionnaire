package cn.furryfandom.mapper;

import cn.furryfandom.entity.User;
import com.baomidou.mybatisplus.core.mapper.Mapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends Mapper<User> {
    User selectUserByUsername(String username);
}
