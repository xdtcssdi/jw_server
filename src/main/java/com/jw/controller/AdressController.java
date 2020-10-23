package com.jw.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jw.Response;
import com.jw.entity.Teacher;
import com.jw.mapper.TeacherMapper;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@lombok.Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="学生通讯录", description="")
class Data implements Serializable {
    List<Teacher> records;
    int total;
}

@RestController
@RequestMapping("/address")
public class AdressController {

    @Resource
    private TeacherMapper teacherMapper;

    @ApiOperation(value = "查询老师通讯录")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "id", value = "ID")
    })
    @GetMapping
    public Response address(@RequestParam Integer page,
                            @RequestParam Integer pageCount,
                            @RequestParam("type") String type,
                            @RequestParam("id") Integer id){

        if ("student".equals(type)){
            int p = (page-1)*pageCount;
            List<Teacher> teachers = teacherMapper.selectByMyWrapper(p, pageCount, id);
            int total = teacherMapper.count(id);
            if (teachers!=null) {
                Data d = new Data();
                d.records = teachers;
                d.total = total;
                return Response.yes(d);
            }
        }else if ("teacher".equals(type)){
            int p = (page-1)*pageCount;
            List<Teacher> teachers = teacherMapper.selectByMyWrapper1(p, pageCount, id);
            int total = teacherMapper.count1(id);
            if (teachers!=null) {
                Data d = new Data();
                d.records = teachers;
                d.total = total;
                return Response.yes(d);
            }
        }
        return Response.no();
    }
}
