package com.appointment.config;

import com.appointment.interceptor.AutoLoginInterceptor;
import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2023/12/30 14:04
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 拦截所有请求,排除login等
        registry.addInterceptor(new AutoLoginInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login/**","/admin")
                .excludePathPatterns("/**.html","/webjars/**")
                .excludePathPatterns("/v3/api-docs/**","/swagger-ui.html");
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("swagger-ui.html")
                .addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/");
    }

}
