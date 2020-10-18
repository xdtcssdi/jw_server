package com.jw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jw.entity.MakeupExam;
import com.jw.mapper.MakeupExamMapper;
import com.jw.service.IMakeupExamService;
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
public class MakeupExamServiceImpl extends ServiceImpl<MakeupExamMapper, MakeupExam> implements IMakeupExamService {

    @Override
    public  IPage<MakeupExam> findListByPage(Integer page, Integer pageCount){
        IPage<MakeupExam> wherePage = new Page<>(page, pageCount);
        MakeupExam where = new MakeupExam();
        QueryWrapper<MakeupExam> query = Wrappers.query(where);

        return baseMapper.selectPage(wherePage, query);
    }

    @Override
    public IPage<MakeupExam> findListByPageAndTeacher(Integer page, Integer pageCount) {
        IPage<MakeupExam> wherePage = new Page<>(page, pageCount);
        MakeupExam where = new MakeupExam();
        return baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(MakeupExam makeupExam){
        return baseMapper.insert(makeupExam);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(MakeupExam makeupExam){
        return baseMapper.updateById(makeupExam);
    }

    @Override
    public MakeupExam findById(Long id){
        return  baseMapper.selectById(id);
    }
}
