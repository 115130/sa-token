package com.bysj.satoken.controller;


import com.bysj.satoken.entity.front.UserInfoFrontVo;
import com.bysj.satoken.entity.vo.UserInfoVo;
import com.bysj.satoken.service.IUserInfoService;
import com.bysj.satoken.utils.Response;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * <p>
 * 用户信息 前端控制器
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
@RestController
@RequestMapping("user")
public class UserInfoController {
    @Resource
    private IUserInfoService userInfoService;

    @ApiOperation("获取已登录的用户信息")
    @GetMapping("info")
    public Response getUserInfo() {
        UserInfoFrontVo info = userInfoService.getUserInfo();
        return Response.ok().data("userInfo", info);
    }

    @ApiOperation("修改用户信息")
    @PostMapping("modifyUserInfo")
    public Response modifyUserInfo(@RequestBody UserInfoVo userInfoVo) {
        userInfoService.modifyUserInfo(userInfoVo);
        return Response.ok();
    }

    @ApiOperation("修改用户密码")
    @PostMapping("modifyUserPassword")
    public Response modifyUserPassword (@RequestBody UserInfoVo userInfoVo) {
        userInfoService.modifyUserPassword(userInfoVo.getPassword());
        return Response.ok();
    }
}
