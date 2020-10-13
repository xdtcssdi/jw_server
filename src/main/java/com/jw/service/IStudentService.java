package com.jw.service;

import com.jw.entity.Student;
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
public interface IStudentService extends IService<Student> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Student>
     */
    IPage<Student> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param student 
     * @return int
     */
    int add(Student student);

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
     * @param student 
     * @return int
     */
    int updateData(Student student);

    /**
     * id查询数据
     *
     * @param id id
     * @return Student
     */
    Student findById(Long id);
}
