package com.appointment.task;

import com.shanrenzhixing.common.tools.CommonUtils;
import com.shanrenzhixing.common.tools.HttpUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2023/12/24 19:01
 */
@Slf4j
@Component
@EnableScheduling
public class SchedulePoolTask {


//    @Scheduled
    public void wxAccessToken(){


    }

    public static void main(String[] args) {
      Calendar currentCalendar = Calendar.getInstance();
      currentCalendar.setTimeInMillis(System.currentTimeMillis());
      System.out.println(System.currentTimeMillis());
      System.out.println(currentCalendar.getTime());
    }
}
