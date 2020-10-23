package com.jw.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jw.entity.Assignment;
import com.jw.mapper.AssignmentMapper;
import com.jw.service.IAssignmentService;
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
public class AssignmentServiceImpl extends ServiceImpl<AssignmentMapper, Assignment> implements IAssignmentService {

    @Override
    public  IPage<Assignment> findListByPage(Integer page, Integer pageCount){
        IPage<Assignment> wherePage = new Page<>(page, pageCount);
        Assignment where = new Assignment();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public IPage<Assignment> findListByPage(Integer page, Integer pageCount, Integer id) {
        IPage<Assignment> wherePage = new Page<>(page, pageCount);
        QueryWrapper<Assignment> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("student_id", id);
        return  baseMapper.selectPage(wherePage, queryWrapper);
    }

    @Override
    public int add(Assignment assignment){
        return baseMapper.insert(assignment);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Assignment assignment){
        return baseMapper.updateById(assignment);
    }

    @Override
    public Assignment findById(Long id){
        return  baseMapper.selectById(id);
    }
}
