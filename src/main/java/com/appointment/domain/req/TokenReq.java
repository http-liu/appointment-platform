package com.appointment.domain.req;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2024/1/9 8:20
 */
@Schema(name = "TokenReq",description = "token参数")
@Data
public class TokenReq {

    @Schema(description = "用户Id")
    private String userId;

    @Schema(description = "用户名",required = true)
    private String userName;

    @Schema(description = "openId",required = true)
    private String openId;

    @Schema(description = "sessionKey",required = true)
    private String sessionKey;
}
