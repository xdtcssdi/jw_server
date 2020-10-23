package com.jw.service;

import com.jw.entity.Assignment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.core.metadata.IPage;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author x
 * @since 2020-10-13
 */
public interface IAssignmentService extends IService<Assignment> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Assignment>
     */
    IPage<Assignment> findListByPage(Integer page, Integer pageCount);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @param id student_id
     * @return IPage<Assignment>
     */
    IPage<Assignment> findListByPage(Integer page, Integer pageCount, Integer id);

    /**
     * 添加
     *
     * @param assignment 
     * @return int
     */
    int add(Assignment assignment);

    /**
     * 删除
     *
     * @param id 主键
     * @return int
     */
    int delete(Long id);

    /**
     * 修改
     *
     * @param assignment 
     * @return int
     */
    int updateData(Assignment assignment);

    /**
     * id查询数据
     *
     * @param id id
     * @return Assignment
     */
    Assignment findById(Long id);
}
