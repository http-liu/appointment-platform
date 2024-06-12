package com.appointment.service.impl;

import com.appointment.domain.entity.ApptUserRecord;
import com.appointment.mapper.ApptUserRecordMapper;
import com.appointment.service.ApptUserRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.shanrenzhixing.common.domain.ResultBean;
import org.springframework.beans.factory.annotation.*;
import com.shanrenzhixing.common.tools.BeanUtils;
import com.shanrenzhixing.common.tools.ResultUtils;

/**
* <p>
*  服务实现类
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
@Service
public class ApptUserRecordServiceImpl extends ServiceImpl<ApptUserRecordMapper, ApptUserRecord> implements ApptUserRecordService {

    @Autowired
    private ApptUserRecordMapper apptUserRecordMapper;

    /**
    * 新增数据
    *
    * @param apptUserRecord 实体对象
    * @return ResponseEntity
    */
    @Override
    public ResultBean addApptUserRecord(ApptUserRecord apptUserRecord) {
        BeanUtils.copyProperties(apptUserRecord, apptUserRecord);
        long result = apptUserRecordMapper.insert(apptUserRecord);
        return result > 0 ?  ResultUtils.success2bean("新增成功") : ResultUtils.error2bean();
    }

    /**
    * 根据ID查询数据
    *
    * @param id ID
    * @return responseResult
    */
    @Override
    public ResultBean getApptUserRecordById(Long id) {
        ApptUserRecord apptUserRecord = apptUserRecordMapper.selectById(id);
        return apptUserRecord != null ?  ResultUtils.success2bean(apptUserRecord) : ResultUtils.error2bean();
    }

    /**
    * 更新数据
    *
    * @param apptUserRecord 实体对象
    * @return ResponseEntity
    */
    @Override
    public ResultBean updateApptUserRecord(ApptUserRecord apptUserRecord) {
        long result = apptUserRecordMapper.updateById(apptUserRecord);
        return result > 0 ?  ResultUtils.success2bean("更新成功") : ResultUtils.error2bean();
    }

    /**
    * 删除数据
    *
    * @param id ID
    * @return ResponseEntity
    */
    @Override
    public ResultBean deleteApptUserRecord(Long id) {
        long result = apptUserRecordMapper.deleteById(id);
        return result > 0 ? ResultUtils.success2bean("删除成功") : ResultUtils.error2bean();
    }

}
