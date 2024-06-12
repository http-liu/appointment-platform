package com.appointment;

import com.shanrenzhixing.common.tools.CommonUtils;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.appointment.mapper")
@SpringBootApplication
public class AppointmentPlatformApplication {

    public static void main(String[] args) {
        CommonUtils.CONTEXT = SpringApplication.run(AppointmentPlatformApplication.class, args);
    }

}
