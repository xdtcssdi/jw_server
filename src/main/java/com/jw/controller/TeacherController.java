package com.jw.controller;

import com.jw.Response;
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
    public Response add(@RequestBody Teacher teacher){
        int add = teacherService.add(teacher);
        if (add!=0){
            return Response.yes(1);
        }
        return Response.no();
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable("id") Long id){
        int delete = teacherService.delete(id);
        if (delete!=0){
            return Response.yes();
        }
        return Response.no();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public Response update(@RequestBody Teacher teacher){
        int i = teacherService.updateData(teacher);
        if (i!=0){
            return Response.yes();
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
                                   @RequestParam Integer pageCount){
        IPage<Teacher> listByPage = teacherService.findListByPage(page, pageCount);
        if (listByPage!=null && listByPage.getSize()!=0){
            return Response.yes(listByPage);
        }
        return Response.no();
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Response findById(@PathVariable Long id){
        Teacher byId = teacherService.findById(id);
        if (byId!=null){
            return Response.yes(byId);
        }
        return Response.no();
    }

}
