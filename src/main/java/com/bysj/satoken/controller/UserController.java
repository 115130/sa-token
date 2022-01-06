package com.bysj.satoken.controller;

import com.bysj.satoken.service.IUserService;
import com.bysj.satoken.utils.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
@RestController
@CrossOrigin
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Resource
    private IUserService userService;

    @GetMapping("UserById")
    public Response getUserById(String id){
        return Response.ok().data("user",userService.getUserById(id));
    }

    @GetMapping("getAll")
    public Response getAll(){
        return Response.ok().data("all",userService.getAll());
    }
}
