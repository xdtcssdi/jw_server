package com.jw.service.impl;

import com.jw.entity.Teacher;
import com.jw.mapper.TeacherMapper;
import com.jw.service.ITeacherService;
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
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements ITeacherService {

    @Override
    public  IPage<Teacher> findListByPage(Integer page, Integer pageCount){
        IPage<Teacher> wherePage = new Page<>(page, pageCount);
        Teacher where = new Teacher();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Teacher teacher){
        return baseMapper.insert(teacher);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Teacher teacher){
        return baseMapper.updateById(teacher);
    }

    @Override
    public Teacher findById(Long id){
        return  baseMapper.selectById(id);
    }
}
