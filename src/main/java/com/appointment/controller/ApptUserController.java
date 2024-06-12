package com.appointment.controller;

import com.appointment.domain.entity.ApptUser;
import com.appointment.service.ApptUserService;
import com.shanrenzhixing.common.domain.ResultBean;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
* <p>
* 用户表 前端控制器
* </p>
*
* @author liuzhihao
* @since 2023-12-18
*/
@Slf4j
@Tag(name = "用户表")
@RestController
@RequestMapping("/apptUser")
public class ApptUserController {

    @Autowired
    private ApptUserService apptUserService;


    /**
    * 新增数据
    * @param apptUser 实体对象
    * @return
    */
    @PostMapping("add")
    @Operation(summary = "新增数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean add(@Validated @RequestBody ApptUser apptUser){
        return apptUserService.addApptUser(apptUser);
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
        return apptUserService.getApptUserById(id);
    }

    /**
    * 更新数据
    *
    * @param apptUser 实体对象
    * @return ResponseEntity
    */
    @PostMapping("update")
    @Operation(summary = "更新数据", responses = {
            @ApiResponse(description = "Successful Operation", responseCode = "200", content = @Content(mediaType = "application/json", schema = @Schema(implementation = ResultBean.class))),
            @ApiResponse(responseCode = "404", description = "Not found", content = @Content),
            @ApiResponse(responseCode = "401", description = "Authentication Failure", content = @Content(schema = @Schema(hidden = true))) })
    public ResultBean update(@Validated @RequestBody ApptUser apptUser) {
        return apptUserService.updateApptUser(apptUser);
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
        return apptUserService.deleteApptUser(id);
    }





}
