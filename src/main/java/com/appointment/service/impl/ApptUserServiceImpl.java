package com.appointment.service.impl;

import com.appointment.domain.entity.ApptUser;
import com.appointment.mapper.ApptUserMapper;
import com.appointment.service.ApptUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.shanrenzhixing.common.domain.ResultBean;
import org.springframework.beans.factory.annotation.*;
import com.shanrenzhixing.common.tools.BeanUtils;
import com.shanrenzhixing.common.tools.ResultUtils;

/**
* <p>
* 用户表 服务实现类
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
@Service
public class ApptUserServiceImpl extends ServiceImpl<ApptUserMapper, ApptUser> implements ApptUserService {

    @Autowired
    private ApptUserMapper apptUserMapper;

    /**
    * 新增数据
    *
    * @param apptUser 实体对象
    * @return ResponseEntity
    */
    @Override
    public ResultBean addApptUser(ApptUser apptUser) {
        BeanUtils.copyProperties(apptUser, apptUser);
        long result = apptUserMapper.insert(apptUser);
        return result > 0 ?  ResultUtils.success2bean("新增成功") : ResultUtils.error2bean();
    }

    /**
    * 根据ID查询数据
    *
    * @param id ID
    * @return responseResult
    */
    @Override
    public ResultBean getApptUserById(Long id) {
        ApptUser apptUser = apptUserMapper.selectById(id);
        return apptUser != null ?  ResultUtils.success2bean(apptUser) : ResultUtils.error2bean();
    }

    /**
    * 更新数据
    *
    * @param apptUser 实体对象
    * @return ResponseEntity
    */
    @Override
    public ResultBean updateApptUser(ApptUser apptUser) {
        long result = apptUserMapper.updateById(apptUser);
        return result > 0 ?  ResultUtils.success2bean("更新成功") : ResultUtils.error2bean();
    }

    /**
    * 删除数据
    *
    * @param id ID
    * @return ResponseEntity
    */
    @Override
    public ResultBean deleteApptUser(Long id) {
        long result = apptUserMapper.deleteById(id);
        return result > 0 ? ResultUtils.success2bean("删除成功") : ResultUtils.error2bean();
    }

}
