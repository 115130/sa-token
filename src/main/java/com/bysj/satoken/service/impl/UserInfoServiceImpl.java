package com.bysj.satoken.service.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.bysj.satoken.entity.User;
import com.bysj.satoken.entity.UserInfo;
import com.bysj.satoken.entity.front.UserInfoFrontVo;
import com.bysj.satoken.entity.vo.UserInfoVo;
import com.bysj.satoken.handle.exceptionhandler.TestException;
import com.bysj.satoken.mapper.UserInfoMapper;
import com.bysj.satoken.service.IAuthorityService;
import com.bysj.satoken.service.IUserInfoService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.bysj.satoken.service.IUserService;
import com.bysj.satoken.utils.PermissionUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    @Resource
    private IUserService userService;

    @Resource
    IAuthorityService authorityService;


    
    @Override
    public UserInfoFrontVo getUserInfo() {
        String id = StpUtil.getLoginIdAsString();
        UserInfoFrontVo info = new UserInfoFrontVo();
        List<String> permissionByUserId = authorityService.getPermissionByUserId(id);

        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",id);
        UserInfo one = getOne(wrapper);
        User user = userService.getUserById(id);


        BeanUtils.copyProperties(one,info);
        BeanUtils.copyProperties(user,info);
        info.setPermission(PermissionUtil.getPermissionListName(permissionByUserId));

        return info;
    }

    @Override
    public void modifyUserInfo(UserInfoVo userInfoVo) {
        String id = userInfoVo.getId();
        UserInfo info = new UserInfo();
        User user = new User();
        if (StringUtils.isEmpty(userInfoVo.getId())){
            id = StpUtil.getLoginIdAsString();
        }

        BeanUtils.copyProperties(userInfoVo,info);
        BeanUtils.copyProperties(userInfoVo,user);
        user.setTId(id);

        QueryWrapper<UserInfo> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id",id);
        update(info,wrapper);
        userService.updateById(user);
    }

    @Override
    public void modifyUserPassword(String password) {
        String id = StpUtil.getLoginIdAsString();
        User user = new User();
        user.setUPassword(password);
        if (!userService.updateById(user)){
            throw new TestException(20003,"更新密码失败");
        }
    }
}
