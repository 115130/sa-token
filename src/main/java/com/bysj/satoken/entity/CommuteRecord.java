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
@TableName("t_commute_record")
@ApiModel(value = "CommuteRecord对象", description = "")
public class CommuteRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    private Integer isDeleted;

    private LocalDateTime gmtModified;

    private LocalDateTime gmtCreate;

    @ApiModelProperty("经纬")
    private Integer longitude;

    @ApiModelProperty("纬度")
    private Integer latitude;

    @ApiModelProperty("打卡人员id")
    private String uId;

    @ApiModelProperty("是否在范围内打卡")
    private Integer isCommute;
}
