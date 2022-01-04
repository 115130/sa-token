package com.bysj.satoken.config;

import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import cn.dev33.satoken.jwt.StpLogicJwtForMix;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpLogic;
import cn.dev33.satoken.stp.StpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Slf4j
@Configuration
@Component
public class SaTokenConfig implements WebMvcConfigurer {
    //配置jwt token
    @Bean
    public StpLogic getStpLogicJwt() {
        return new StpLogicJwtForMix();
    }

    //路由器鉴权
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(new SaRouteInterceptor((req, res, handler) -> {
            //需要排除options请求
            if (!req.getMethod().equals(HttpMethod.OPTIONS.toString())){
                log.error("路由器鉴权");
//             第一个参数是拦截路径，第二个是排除的路径，第三个是对拦截的路径做什么
//                SaRouter.match("/**", "/user/login", r -> StpUtil.checkLogin());
//             角色认证 -- 拦截以 admin 开头的路由，必须具备 admin 角色或者 super-admin 角色才可以通过认证
//            SaRouter.match("/admin/**", r -> StpUtil.checkRoleOr("admin", "super-admin"));
                // 权限认证 -- 不同模块认证不同权限
                SaRouter.match("/user/test1", r -> {
                    String permission = "12";
                    System.out.println(StpUtil.getTokenInfo());
                    StpUtil.checkPermission(permission);
                });
//            SaRouter.match("/user/**", r -> StpUtil.checkPermissionAnd("user"));
//            SaRouter.match("/user/**", r -> StpUtil.checkPermissionOr("user"));
            }
        })).excludePathPatterns("/user/login");
    }

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    /*@Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
            // 指定 拦截路由 与 放行路由
            .addInclude("/**").addExclude("/user/logout","/user/info","/user/login")
            // 认证函数: 每次请求执行
            .setAuth(obj -> {
//                System.out.println("---------- 进入Sa-Token全局认证 -----------");
                // 登录认证 -- 拦截所有路由，并排除/user/doLogin 用于开放登录
                SaRouter.match("/user/test1",()-> {
//                    StpUtil.checkLogin();
                    log.error(StpUtil.getTokenInfo().toString());
                    StpUtil.checkPermission("12");
                });
            });
    }*/

}
