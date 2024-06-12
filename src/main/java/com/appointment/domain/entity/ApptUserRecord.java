package com.appointment.domain.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
* <p>
* 
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
@Data
@TableName("appt_user_record")
@Schema(name = "ApptUserRecord", description = "")
public class ApptUserRecord implements Serializable {

    private static final long serialVersionUID = 1L;

    @Schema(description = "ID")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Schema(description = "发起人")
    private String name;

    @Schema(description = "活的主题")
    private String topic;

    @Schema(description = "参战人员")
    private String participants;

    @Schema(description = "时间")
    private Date apptTime;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "备注")
    private String notes;

    @Schema(description = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;

    @Schema(description = "更新时间")
    private Date updateTime;
}
