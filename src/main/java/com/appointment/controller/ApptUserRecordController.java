package com.appointment.controller;

import com.appointment.domain.entity.ApptUserRecord;
import com.appointment.domain.req.ApptUserReq;
import com.appointment.service.ApptUserRecordService;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.shanrenzhixing.common.tools.BeanUtils;
import com.shanrenzhixing.common.tools.CollectionUtils;
import com.shanrenzhixing.common.tools.JacksonUtils;
import com.shanrenzhixing.common.tools.ResultUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;
import com.shanrenzhixing.common.domain.ResultBean;
import org.springframework.validation.annotation.Validated;
import org.springframework.beans.factory.annotation.*;
import lombok.extern.slf4j.Slf4j;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
* <p>
*  前端控制器
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
@Slf4j
@Tag(name = "用户预约记录")
@RestController
@RequestMapping("/apptUserRecord")
public class ApptUserRecordController {

    @Autowired
    private ApptUserRecordService apptUserRecordService;

    /**
    * 新增数据
    * @param apptUserRecord 实体对象
    * @return
    */
    @PostMapping("add")
    @Operation(summary = "新增数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean add(@Validated @RequestBody ApptUserRecord apptUserRecord){
        if (ObjectUtils.isEmpty(apptUserRecord)){
            return ResultUtils.error2bean("新增数据不能为空");
        }
        return apptUserRecordService.addApptUserRecord(apptUserRecord);
    }


    @Operation(summary = "查询用户信息", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    @GetMapping("userRecordInfo")
    public ResultBean getUserInfo(String userToken){
        List<ApptUserRecord> userRecordInfoList = apptUserRecordService.list(Wrappers.<ApptUserRecord>lambdaQuery());
        if(CollectionUtils.isEmpty(userRecordInfoList)){
            return ResultUtils.error2bean("当前数据为空");
        }
        return ResultUtils.success2bean().setData(userRecordInfoList);
    }


    /**
    * 根据ID查询数据
    *
    * @param id ID
    * @return ResponseEntity
    */
    @GetMapping("getById/{id}")
    @Operation(summary = "根据ID查询数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean getById(@PathVariable Long id) {
        return apptUserRecordService.getApptUserRecordById(id);
    }

    /**
    * 更新数据
    *
    * @param apptUserRecord 实体对象
    * @return ResponseEntity
    */
    @PostMapping("update")
    @Operation(summary = "更新数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean update(@Validated @RequestBody ApptUserRecord apptUserRecord) {
        return apptUserRecordService.updateApptUserRecord(apptUserRecord);
    }

    /**
    * 删除数据
    *
    * @param id ID
    * @return ResponseEntity
    */
    @PostMapping("delete/{id}")
    @Operation(summary = "删除数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean delete(@PathVariable Long id) {
        return apptUserRecordService.deleteApptUserRecord(id);
    }

}
