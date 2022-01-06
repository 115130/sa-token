package com.bysj.satoken.utils;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtil {
    public static String getPermissionName(String name){
        switch (name){
            case "00": return "修改当前用户信息";
            case "01": return "修改所有用户信息";
            case "10": return "打卡权限";
            case "11": return "外勤审批";
            case "12": return "查看所有人的打卡信息";
            default: return null;
        }
    }

    public static List<String> getPermissionListName(List<String> list){
        List<String> array = new ArrayList<>();
        for (String s : list) {
            array.add(getPermissionName(s));
        }
        return array;
    }
}
