package com.bysj.satoken.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author yangjiahui
 * @since 2022-01-02
 */

@Data
@TableName("t_user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    private Integer isDeleted;

    private LocalDateTime gmtModified;

    private LocalDateTime gmtCreate;

    @ApiModelProperty("昵称")
    private String nick;

    @ApiModelProperty("邮箱")
    private String email;

    @ApiModelProperty("密码")
    private String uPassword;

    @ApiModelProperty("身份表示(权限)")
    private String authority;

    @ApiModelProperty("是否锁定")
    private Integer isLock;
}
