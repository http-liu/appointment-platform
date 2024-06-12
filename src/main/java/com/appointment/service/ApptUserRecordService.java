package com.appointment.service;

import com.appointment.domain.entity.ApptUserRecord;
import com.baomidou.mybatisplus.extension.service.IService;
import com.shanrenzhixing.common.domain.ResultBean;

/**
* <p>
*  服务类
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
public interface ApptUserRecordService extends IService<ApptUserRecord> {

    /**
    * 新增数据
    *
    * @param ApptUserRecord 实体对象
    * @return ResponseResult
    */
    ResultBean addApptUserRecord(ApptUserRecord apptUserRecord);

    /**
    * 根据ID查询数据
    *
    * @param id ID
    * @return ResponseResult
    */
    ResultBean getApptUserRecordById(Long id);

    /**
    * 更新数据
    *
    * @param apptUserRecord 实体对象
    * @return ResponseResult
    */
    ResultBean updateApptUserRecord(ApptUserRecord apptUserRecord);

    /**
    * 删除数据
    *
    * @param id ID
    * @return ResponseResult
    */
    ResultBean deleteApptUserRecord(Long id);

}
