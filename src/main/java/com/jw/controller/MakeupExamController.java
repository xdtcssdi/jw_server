package com.jw.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.jw.Response;
import com.jw.entity.Assignment;
import com.jw.entity.Exam;
import com.jw.entity.MakeupExamUName;
import com.jw.mapper.MakeupExamMapper;
import com.jw.service.IExamService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.IMakeupExamService;
import com.jw.entity.MakeupExam;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.baomidou.mybatisplus.core.metadata.IPage;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
@RequestMapping("/makeup-exam")
public class MakeupExamController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IMakeupExamService makeupExamService;

    @Resource
    private IExamService examService;

    @ApiOperation(value = "新增")
    @PostMapping()
    public Response add(@RequestBody MakeupExam makeupExam) {
        int add = makeupExamService.add(makeupExam);
        if (add == 1) {
            return Response.yes(add);
        }
        return Response.no("添加失败 " + makeupExam);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable("id") Long id) {
        int delete = makeupExamService.delete(id);
        if (delete == 1) {
            return Response.yes(delete);
        }
        return Response.no("删除失败" + id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public Response update(@RequestBody MakeupExam makeupExam) {
        System.out.println(makeupExam);
        int i = makeupExamService.updateData(makeupExam);
        if (i == 1) {
            return Response.yes(1);
        }
        return Response.no("更新失败" + makeupExam);
    }

    @Resource
    private MakeupExamMapper makeupExamMapper;

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页码"),
            @ApiImplicitParam(name = "pageCount", value = "每页条数"),
            @ApiImplicitParam(name = "type", value = "类型"),
            @ApiImplicitParam(name = "id", value = "ID")
    })
    @GetMapping()
    public Response findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount,
                                   @RequestParam String type,
                                   @RequestParam Integer id) {

        int p = (page-1)*pageCount;
        if (type.equals("student")) {
            List<MakeupExamUName> makeupExamUNames = makeupExamMapper.selectByStudent(p, pageCount, id);
            int i = makeupExamMapper.countByStudent(id);
            IPage<MakeupExamUName> iPage = new Page<>();
            iPage.setRecords(makeupExamUNames);
            iPage.setTotal(i);
            return Response.yes(iPage);
        } else if (type.equals("teacher")) {
            List<MakeupExamUName> makeupExams = makeupExamMapper.selectByTeacher(p, pageCount, id);
            int i = makeupExamMapper.counttByTeacher(id);
            IPage<MakeupExamUName> iPage = new Page<>();
            iPage.setRecords(makeupExams);
            iPage.setTotal(i);
            return Response.yes(iPage);
        } else {
//            IPage<MakeupExam> listByPage = makeupExamService.findListByPage(page - 1, pageCount);
            List<MakeupExamUName> makeupExamUNames = makeupExamMapper.selectByAll(p, pageCount);
            System.out.println(makeupExamUNames);
            int i = makeupExamMapper.countByAll();
            IPage<MakeupExamUName> iPage = new Page<>();
            iPage.setRecords(makeupExamUNames);
            iPage.setTotal(i);
            return Response.yes(iPage);
        }
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Response findById(@PathVariable Long id) {
        MakeupExam byId = makeupExamService.findById(id);
        if (byId != null) {
            return Response.yes(byId);
        }
        return Response.no("查找失败");
    }

}
