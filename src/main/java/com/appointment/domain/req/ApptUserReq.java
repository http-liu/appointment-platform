package com.appointment.domain.req;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2023/12/18 19:53
 */
@Schema(name = "ApptUserReq", description = "用户记录")
@Data
public class ApptUserReq {

    @Schema(description = "ID")
    private Integer id;

    @Schema(description = "发起人")
    private String name;

    @Schema(description = "活的主题")
    private String topic;

    @Schema(description = "参战人员")
    private List<String> participants;

    @Schema(description = "时间")
    private Date apptTime;

    @Schema(description = "地址")
    private String address;

    @Schema(description = "备注")
    private String notes;

}
