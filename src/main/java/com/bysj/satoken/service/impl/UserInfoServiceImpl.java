package com.bysj.satoken.service.impl;

import com.bysj.satoken.entity.UserInfo;
import com.bysj.satoken.mapper.UserInfoMapper;
import com.bysj.satoken.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户信息 服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
@Service
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements IUserInfoService {

}
