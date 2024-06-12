package com.appointment.task;

import com.shanrenzhixing.common.domain.ResultBean;
import com.shanrenzhixing.common.tools.HttpUtils;
import com.shanrenzhixing.common.tools.JacksonUtils;
import com.shanrenzhixing.common.tools.RedisUtils;
import com.shanrenzhixing.common.tools.ResultUtils;
import org.springframework.beans.factory.annotation.Value;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author liuzhihao
 * @version 1.0.0
 * @date 2023/12/28 13:24
 */

public class InitializationPoolTask {


    public ResultBean init(){
        ThreadPoolExecutor threadExecutor = new ThreadPoolExecutor(3,5,
                60L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        Future future = threadExecutor.submit(new Callable<Object>() {
            @Override
            public Object call() throws Exception {

                return null;
            }
        });

        return new ResultBean();
    }
}
