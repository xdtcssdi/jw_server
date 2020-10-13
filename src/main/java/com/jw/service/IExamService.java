package com.jw.service;

import com.jw.entity.Exam;
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
public interface IExamService extends IService<Exam> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Exam>
     */
    IPage<Exam> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param exam 
     * @return int
     */
    int add(Exam exam);

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
     * @param exam 
     * @return int
     */
    int updateData(Exam exam);

    /**
     * id查询数据
     *
     * @param id id
     * @return Exam
     */
    Exam findById(Long id);
}
