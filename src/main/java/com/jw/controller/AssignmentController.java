package com.jw.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.IAssignmentService;
import com.jw.entity.Assignment;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author x
 * @since 2020-10-13
 */
@Api(tags = {""})
@RestController
@RequestMapping("/assignment")
public class AssignmentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IAssignmentService assignmentService;

    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Assignment assignment){
        return assignmentService.add(assignment);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return assignmentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Assignment assignment){
        return assignmentService.updateData(assignment);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Assignment> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return assignmentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Assignment findById(@PathVariable Long id){
        return assignmentService.findById(id);
    }

}
