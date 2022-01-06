package com.bysj.satoken.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bysj.satoken.entity.User;
import com.bysj.satoken.entity.front.UserVo;
import com.bysj.satoken.handle.exceptionhandler.TestException;
import com.bysj.satoken.mapper.UserMapper;
import com.bysj.satoken.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Override
    public String login(UserVo userVo) {
        String username = userVo.getEmail();
        String password = userVo.getPassword();
        QueryWrapper<User> userWrapper = new QueryWrapper<>();
        userWrapper.eq("email", username);
        User one = getOne(userWrapper);
        if (ObjectUtils.isEmpty(one)){
            throw new TestException(20004,"用户名不存在");
        }
        if (username.equals(one.getEmail()) && password.equals(one.getUPassword())) {
            StpUtil.login(one.getTId());
        }else {
            throw new TestException(20005,"用户名和密码不匹配");
        }

        return StpUtil.getTokenValue();
    }

    @Override
    public User getUserById(String id) {
        return getById(id);
    }

    @Override
    @Cacheable(value = "userList", key = "'getAll'")
    public List<User> getAll() {
        return list();
    }
}
