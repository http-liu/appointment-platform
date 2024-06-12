package com.appointment.domain.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2024/1/9 8:16
 */
@Schema(name = "LoginReq",description = "登录")
@Data
public class LoginReq {

    /**
     * 用于微信登录的js_code
     */
    @Schema(description = "用于微信登录的js_code",required = true)
    private String userCode;


}
