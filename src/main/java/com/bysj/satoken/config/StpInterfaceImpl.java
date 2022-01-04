package com.bysj.satoken.config;

import cn.dev33.satoken.stp.StpInterface;
import com.bysj.satoken.service.IAuthorityService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class StpInterfaceImpl implements StpInterface {
    @Resource
    private IAuthorityService authorityService;

    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        log.error("开始权限验证");
        List<String> list = authorityService.getPermissionByUserId((String) loginId);
        log.error("权限是 " + list);
        return list;
    }

    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        log.error("开始验证身份");
        List<String> list = authorityService.getPermissionByUserId((String) loginId);
        log.error("权限是" + list);
        return list;
    }
}
