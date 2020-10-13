package com.jw.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.IStudentService;
import com.jw.entity.Student;
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
@RequestMapping("/student")
public class StudentController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IStudentService studentService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody Student student){
        return studentService.add(student);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return studentService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody Student student){
        return studentService.updateData(student);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<Student> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return studentService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Student findById(@PathVariable Long id){
        return studentService.findById(id);
    }

}
