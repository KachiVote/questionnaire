package cn.furryfandom.service.impl;

import cn.furryfandom.entity.User;
import cn.furryfandom.mapper.UserMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UserMapper userMapper;

    public CustomUserDetailsService(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // 使用 MyBatis Plus 查询用户
        User user = userMapper.selectUserByUsername(username);
        if (user == null) throw new UsernameNotFoundException("用户不存在: " + username);
        return user; // 直接返回 User 实体（已实现 UserDetails）
    }
}