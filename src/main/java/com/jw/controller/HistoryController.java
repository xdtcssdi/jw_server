package com.jw.controller;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.web.bind.annotation.*;
import com.jw.service.IHistoryService;
import com.jw.entity.History;
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
@RequestMapping("/history")
public class HistoryController {

    private Logger log = LoggerFactory.getLogger(getClass());

    @Resource
    private IHistoryService historyService;


    @ApiOperation(value = "新增")
    @PostMapping()
    public int add(@RequestBody History history){
        return historyService.add(history);
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public int delete(@PathVariable("id") Long id){
        return historyService.delete(id);
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public int update(@RequestBody History history){
        return historyService.updateData(history);
    }

    @ApiOperation(value = "查询分页数据")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "page", value = "页码"),
        @ApiImplicitParam(name = "pageCount", value = "每页条数")
    })
    @GetMapping()
    public IPage<History> findListByPage(@RequestParam Integer page,
                                   @RequestParam Integer pageCount){
        return historyService.findListByPage(page, pageCount);
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public History findById(@PathVariable Long id){
        return historyService.findById(id);
    }

}
