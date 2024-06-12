package com.appointment.config;

import com.shanrenzhixing.common.tools.HttpUtils;
import com.shanrenzhixing.common.tools.JacksonUtils;
import com.shanrenzhixing.common.tools.RedisUtils;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2024/1/8 17:52
 */
@Slf4j
@Configuration

public class AppointmentConfig {

    @Getter
    @Value("${wx.appid}")
    private String appId;

    @Getter
    @Value("${wx.appsecret}")
    private String appSecret;


    public String getAccessToken(){
        if (RedisUtils.exists("access_token")){
            return RedisUtils.getStrValue("access_token");
        }
        // 没有则获取
        String wxApiToken = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&" +
                "appid="+ appId +"&secret=" + appSecret;
        String accessTokenResult = HttpUtils.httpGet(wxApiToken);
        // 返回值为：access_token 和 expires_in ,expires_in为过期时间; {"access_token":"","":""}
        Map<String,String> resultMap = JacksonUtils.json2Map(accessTokenResult,String.class, String.class);
        if (null == resultMap.getOrDefault("access_token",null)){
            return null;
        }
        // 成功则添加计时Map
        RedisUtils.setIfAbsent("access_token",resultMap.get("access_token"), Long.parseLong(resultMap.get("expires_in")));
        return resultMap.get("access_token");
    }

}
