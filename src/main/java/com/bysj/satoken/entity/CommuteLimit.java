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
@TableName("t_commute_limit")
@ApiModel(value = "CommuteLimit对象", description = "")
public class CommuteLimit implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId
    private String tId;

    private Integer isDeleted;

    private LocalDateTime gmtModified;

    private LocalDateTime gmtCreate;

    @ApiModelProperty("设置范围人员id")
    private String uId;

    @ApiModelProperty("上维度")
    private Integer upLatitude;

    @ApiModelProperty("下纬度")
    private Integer downLatitude;

    @ApiModelProperty("上经度")
    private Integer upLongitude;

    @ApiModelProperty("下经度")
    private Integer downLongitude;

}
