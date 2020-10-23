package com.jw.controller;

import com.jw.Response;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.IExamService;
import com.jw.entity.Exam;
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
@RequestMapping("/exam")
public class ExamController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IExamService examService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public Response add(@RequestBody Exam exam){
        int add = examService.add(exam);
        if (add==0)
            return Response.no();
        return Response.yes(add);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable("id") Long id){
        int delete = examService.delete(id);
        if(delete==0)
            return Response.no();
        return Response.yes();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public Response update(@RequestBody Exam exam){
        int i = examService.updateData(exam);
        if (i==0)
            return Response.no();
        return Response.yes();
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public Response findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        IPage<Exam> listByPage = examService.findListByPage(page, pageCount);
        if (listByPage!=null)
            return Response.yes(listByPage);
        return Response.no();
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Response findById(@PathVariable Long id){
        Exam byId = examService.findById(id);
        if (byId==null)
            return Response.no();
        return Response.yes(byId);
    }

}
