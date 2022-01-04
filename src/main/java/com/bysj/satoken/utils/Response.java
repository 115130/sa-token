package com.bysj.satoken.utils;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

@Data
public class Response {
    @ApiModelProperty(value = "是否成功")
    private Boolean success;

    @ApiModelProperty(value = "返回码")
    private Integer code;

    @ApiModelProperty(value = "返回消息")
    private String message;

    private Map<String, Object> data = new HashMap<>();

    private Response() {
    }

    public static Response ok() {
        Response response = new Response();
        response.setSuccess(true);
        response.setCode(ResultCode.SUCCESS);
        response.setMessage("成功");
        return response;
    }

    public static Response error(){
        Response response = new Response();
        response.setMessage("失败");
        response.setCode(ResultCode.ERROR);
        response.setSuccess(false);
        return response;
    }

    public Response message (String message){
        this.setMessage(message);
        return this;
    }
    public Response code (Integer code){
        this.setCode(code);
        return this;
    }

    public Response success(boolean success){
        this.setSuccess(success);
        return this;
    }

    public Response data(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public Response data(Map<String,Object> map){
        this.setData(map);
        return this;
    }

}
