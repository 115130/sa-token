package com.bysj.satoken.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.bysj.satoken.entity.User;
import com.bysj.satoken.entity.vo.UserVo;
import com.bysj.satoken.service.IUserService;
import com.bysj.satoken.utils.Response;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@ApiOperation("登陆接口")
@RequestMapping("user")
@CrossOrigin
@RestController
@Slf4j
public class LoginController {
    @Resource
    IUserService userService;

    @PostMapping("login")
    public Response login(@RequestBody UserVo userVo) {
        String jwt = userService.login(userVo);
        return Response.ok().data("token", jwt);
    }

    @GetMapping("info")
    public Response getInfo(String token) {
        String id = (String) StpUtil.getLoginIdByToken(token);
        User u = userService.getUserById(id);
        return Response.ok().data("roles", u.getAuthority()).data("name", u.getEmail()).data("avatar", "http://nmsl1.oss-cn-beijing.aliyuncs.com/6e0fb5c3275d4844cdd2b47d149194cacbd4cec5.jpg%40160w_160h_1c_1s.jpg");
    }

    @PostMapping("logout")
    public Response logout() {
        StpUtil.logout();
        return Response.ok();
    }

    @GetMapping("test")
    public Response test() {
        System.out.println("test " + StpUtil.hasPermission("12"));
//        log.error("test" + StpUtil.hasPermission("12"));
        return Response.ok().data("test", " 有权限喵喵喵 ");
    }

    @GetMapping("test1")
    public Response test2() {
//        System.out.println();
        log.error("test1 " + StpUtil.hasPermission("12"));
        return Response.ok().data("test", "权限测试x12");
    }
}