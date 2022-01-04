package com.bysj.satoken.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.bysj.satoken.entity.Authority;
import com.bysj.satoken.mapper.AuthorityMapper;
import com.bysj.satoken.service.IAuthorityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */
@Service
public class AuthorityServiceImpl extends ServiceImpl<AuthorityMapper, Authority> implements IAuthorityService {
    /**
     * 根据用户id获取用户拥有的权限
     *
     * @param uId 用户id
     * @return 返回的是
     */
    @Override
    public List<String> getPermissionByUserId(String uId) {
        QueryWrapper<Authority> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id", uId);
        wrapper.select("permission_type");
        List<String> listStr = new ArrayList<>();
        List<Object> listObj = listObjs(wrapper);
        for (Object o : listObj) {
            listStr.add(o.toString());
        }
        return listStr;
    }
}
