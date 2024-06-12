package com.appointment.controller;

import com.appointment.config.AppointmentConfig;
import com.appointment.domain.req.LoginReq;
import com.appointment.domain.req.NullReq;
import com.appointment.domain.req.TokenReq;
import com.shanrenzhixing.common.domain.ResultBean;
import com.shanrenzhixing.common.domain.TokenResult;
import com.shanrenzhixing.common.tools.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2024/1/8 19:54
 */
@Tag(name = "登录接口")
@Slf4j
@RestController
@RequestMapping("/login")
public class ApptLoginController {

    @Autowired
    private AppointmentConfig apptConfig;

    @Operation(summary = "获取系统Token")
    @PostMapping("token")
    public ResultBean userToken(@RequestBody TokenReq tokenReq){
        if (StringUtils.isEmpty(tokenReq.getUserName())){
            return ResultUtils.error2bean("用户名不能为空");
        }
        if (StringUtils.isEmpty(tokenReq.getOpenId())){
            return ResultUtils.error2bean("openId不能为空");
        }
        if (StringUtils.isEmpty(tokenReq.getSessionKey())){
            return ResultUtils.error2bean("sessionKey不能为空");
        }
        Map<String,String> userMap = new HashMap<>();
        userMap.put("openId",tokenReq.getOpenId());
        userMap.put("sessionKey",tokenReq.getSessionKey());
        TokenResult tokenResult = new TokenResult();
        tokenResult.setUserId(CommonUtils.genRandomNumber(10));
        tokenResult.setUserName(tokenReq.getUserName());
        tokenResult.setUserMap(userMap);
        String token = TokenUtils.generateToken(tokenResult);
        if (StringUtils.isBlank(token)){
            return ResultUtils.error2bean("获取失败,请稍后重试");
        }
        String userId = TokenUtils.getTokenValue(token,"userId");
        String userName = TokenUtils.getTokenValue(token,"userName");
        Map<String,String> tokenMap = new HashMap<>();
        tokenMap.put("token",token);
        RedisUtils.setStrValue(userName+userId, JacksonUtils.map2json(tokenMap),7, TimeUnit.DAYS);
        return ResultUtils.success2bean().setData(token);
    }


    @Operation(summary = "获取微信登录数据")
    @PostMapping("wx/openid")
    public ResultBean loginApplet(@RequestBody LoginReq loginReq){
        if (StringUtils.isEmpty(loginReq.getUserCode())){
            return ResultUtils.error2bean("js_code不能为空");
        }
        String apiUrl =  "https://api.weixin.qq.com/sns/jscode2session?appid=" + apptConfig.getAppId() + "&secret=" + apptConfig.getAppSecret()
                + "&js_code=" + loginReq.getUserCode() + "&grant_type=authorization_code";
        Map<String,String> headMap = new HashMap<>();
        headMap.put("access_token", apptConfig.getAccessToken());
        String result = HttpUtils.httpGet(apiUrl,headMap,null);
        Map<String,String> resultMap = JacksonUtils.json2Map(result,String.class,String.class);
        log.info("返回结果:{}",result);
        if (resultMap.containsKey("session_key")){
            return ResultUtils.success2bean().setData(resultMap);
        }
        return ResultUtils.error2bean("获取失败,请稍后重试");
    }

    @Operation(summary = "查询用户信息")
    @PostMapping("wx/user/message")
    public ResultBean wxUserMessage(@RequestBody NullReq nullReq, HttpServletRequest request){
        String token = request.getHeader("Authorization");
        String userInfo = TokenUtils.getTokenValue(token,"userMap");
        Map<String,String> userMap = JacksonUtils.json2Map(userInfo);
        if (CollectionUtils.isEmpty(userMap)){
            return ResultUtils.error2bean("未查询到用户信息");
        }
        return ResultUtils.success2bean(userMap);
    }
}
