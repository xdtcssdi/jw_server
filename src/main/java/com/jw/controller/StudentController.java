package com.jw.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.segments.MergeSegments;
import com.jw.Response;
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
 * 前端控制器
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
    public Response add(@RequestBody Student student) {
        int add = studentService.add(student);
        if (add==1){
            return Response.yes(1);
        }
        return Response.no();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable("id") Long id) {
        int delete = studentService.delete(id);
        if (delete!=0){
            return Response.yes(1);
        }
        return Response.no();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public Response update(@RequestBody Student student) {
        int i = studentService.updateData(student);
        if (i!=0){
            return Response.yes(1);
        }
        return Response.no();
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public Response findListByPage(@RequestParam Integer page,
                                         @RequestParam Integer pageCount) {
        IPage<Student> listByPage = studentService.findListByPage(page, pageCount);
        if (listByPage!=null && listByPage.getSize()!=0){
            return Response.yes(listByPage);
        }
        return Response.no();
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Response findById(@PathVariable Long id) {
        Student byId = studentService.findById(id);
        if (byId!=null){
            return Response.yes(byId);
        }
        return Response.no();
    }

    @GetMapping("/login")
    public Response login(@RequestParam("username") String username,
                          @RequestParam("password") String password) {

        QueryWrapper<Student> w = new QueryWrapper<>();
        w.eq("username", username).eq("password", password);
        Student one = studentService.getOne(w);
        if (one!=null)
            return Response.yes(one);
        return Response.no("登录失败");
    }

}
