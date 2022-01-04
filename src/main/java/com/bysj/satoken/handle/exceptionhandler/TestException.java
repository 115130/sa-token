package com.bysj.satoken.handle.exceptionhandler;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class TestException extends RuntimeException{
    @ApiModelProperty(value = "状态码")
    private Integer code;

    private String msg;

}
