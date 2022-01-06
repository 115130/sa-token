package com.bysj.satoken.entity.front;

import lombok.Data;

import java.util.List;

@Data
public class UserInfoFrontVo {
    private String email;
    private String nick;
    private String phone;
    private String gender;
    private List<String> permission;
}
