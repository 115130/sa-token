package com.bysj.satoken.service;

import com.bysj.satoken.entity.UserInfo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.bysj.satoken.entity.front.UserInfoFrontVo;
import com.bysj.satoken.entity.vo.UserInfoVo;

/**
 * <p>
 * 用户信息 服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
public interface IUserInfoService extends IService<UserInfo> {

    UserInfoFrontVo getUserInfo();

    void modifyUserInfo(UserInfoVo userInfoVo);

    void modifyUserPassword(String password);
}
