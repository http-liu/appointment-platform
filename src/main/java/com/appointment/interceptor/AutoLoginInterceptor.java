package com.appointment.interceptor;

import com.shanrenzhixing.common.tools.RedisUtils;
import com.shanrenzhixing.common.tools.ResultUtils;
import com.shanrenzhixing.common.tools.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2023/12/30 14:00
 */
@Slf4j
public class AutoLoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String authToken = request.getHeader("Authorization");
        // 判断请求token是否有效
        if (!TokenUtils.validateToken(authToken)){
            log.error(">>>>>系统Token验证失败");
            return false;
        }
        // 判断是否需要续期
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
