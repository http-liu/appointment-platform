package com.appointment.service;

import com.appointment.domain.entity.ApptUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanrenzhixing.common.domain.ResultBean;

/**
* <p>
* 用户表 服务类
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
public interface ApptUserService extends IService<ApptUser> {

    /**
    * 新增数据
    *
    * @param ApptUser 实体对象
    * @return ResponseResult
    */
    ResultBean addApptUser(ApptUser apptUser);

    /**
    * 根据ID查询数据
    *
    * @param id ID
    * @return ResponseResult
    */
    ResultBean getApptUserById(Long id);

    /**
    * 更新数据
    *
    * @param apptUser 实体对象
    * @return ResponseResult
    */
    ResultBean updateApptUser(ApptUser apptUser);

    /**
    * 删除数据
    *
    * @param id ID
    * @return ResponseResult
    */
    ResultBean deleteApptUser(Long id);

}
