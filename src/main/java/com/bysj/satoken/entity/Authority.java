package com.bysj.satoken.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

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
@TableName("t_authority")
@ApiModel(value = "Authority对象", description = "")
public class Authority implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    private Integer isDeleted;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;

    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @ApiModelProperty("权限 00修改个人信息（个人） 01管理个人信息（可修改别人的） " +
            "10 打卡管理（可设置打卡范围，设置上班下班时间，设置节假日）11外勤审批 12 可查看所有人的打卡信息，可搜索所有人的信息（通过时间或者id）")
    private String permissionType;

    private String uId;
}
