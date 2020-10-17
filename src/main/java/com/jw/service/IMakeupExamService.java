package com.jw.service;

import com.jw.entity.MakeupExam;
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
public interface IMakeupExamService extends IService<MakeupExam> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MakeupExam>
     */
    IPage<MakeupExam> findListByPage(Integer page, Integer pageCount);

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<MakeupExam>
     */
    IPage<MakeupExam> findListByPageAndTeacher(Integer page, Integer pageCount);


    /**
     * 添加
     *
     * @param makeupExam 
     * @return int
     */
    int add(MakeupExam makeupExam);

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
     * @param makeupExam 
     * @return int
     */
    int updateData(MakeupExam makeupExam);

    /**
     * id查询数据
     *
     * @param id id
     * @return MakeupExam
     */
    MakeupExam findById(Long id);
}
