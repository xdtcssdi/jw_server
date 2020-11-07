package com.jw.controller;

import com.jw.Response;
import com.jw.entity.File;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

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
@RequestMapping("/file")
public class FileController {

    private final Logger log = LoggerFactory.getLogger(getClass());

    @ApiOperation(value = "新增")
    @PostMapping()
    public Response add(@RequestBody File file) {

        return Response.yes("aaa");
    }

    @ApiOperation(value = "删除")
    @DeleteMapping("{id}")
    public Response delete(@PathVariable("fid") Long fid) {
        return Response.no();
    }

    @ApiOperation(value = "更新")
    @PutMapping()
    public Response update(@RequestBody File file) {

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

        return Response.no();
    }

    @ApiOperation(value = "id查询")
    @GetMapping("{id}")
    public Response findById(@PathVariable Long fid) {
        return Response.no();
    }

}
