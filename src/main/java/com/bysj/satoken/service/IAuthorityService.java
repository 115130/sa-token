package com.bysj.satoken.service;

import com.bysj.satoken.entity.Authority;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
public interface IAuthorityService extends IService<Authority> {
    List<String> getPermissionByUserId(String id);
}
