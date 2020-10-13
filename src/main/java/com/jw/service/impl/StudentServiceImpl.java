package com.jw.service.impl;

import com.jw.entity.Student;
import com.jw.mapper.StudentMapper;
import com.jw.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author x
 * @since 2020-10-13
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {

    @Override
    public  IPage<Student> findListByPage(Integer page, Integer pageCount){
        IPage<Student> wherePage = new Page<>(page, pageCount);
        Student where = new Student();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Student student){
        return baseMapper.insert(student);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Student student){
        return baseMapper.updateById(student);
    }

    @Override
    public Student findById(Long id){
        return  baseMapper.selectById(id);
    }
}
