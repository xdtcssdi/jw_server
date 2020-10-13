package com.jw.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.ITeacherService;
import com.jw.entity.Teacher;
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
@RequestMapping("/teacher")
public class TeacherController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private ITeacherService teacherService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Teacher teacher){
        return teacherService.add(teacher);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return teacherService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Teacher teacher){
        return teacherService.updateData(teacher);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Teacher> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return teacherService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Teacher findById(@PathVariable Long id){
        return teacherService.findById(id);
    }

}
