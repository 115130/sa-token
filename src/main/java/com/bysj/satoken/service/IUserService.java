package com.bysj.satoken.service;

import com.bysj.satoken.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bysj.satoken.entity.front.UserVo;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
public interface IUserService extends IService<User> {

    String login(UserVo userVo);

    User getUserById(String id);

    List<User> getAll();
}
