package com.jw.service.impl;

import com.jw.entity.Exam;
import com.jw.mapper.ExamMapper;
import com.jw.service.IExamService;
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
public class ExamServiceImpl extends ServiceImpl<ExamMapper, Exam> implements IExamService {

    @Override
    public  IPage<Exam> findListByPage(Integer page, Integer pageCount){
        IPage<Exam> wherePage = new Page<>(page, pageCount);
        Exam where = new Exam();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Exam exam){
        return baseMapper.insert(exam);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Exam exam){
        return baseMapper.updateById(exam);
    }

    @Override
    public Exam findById(Long id){
        return  baseMapper.selectById(id);
    }
}
