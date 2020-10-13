package com.jw.service.impl;

import com.jw.entity.Chat;
import com.jw.mapper.ChatMapper;
import com.jw.service.IChatService;
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
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {

    @Override
    public  IPage<Chat> findListByPage(Integer page, Integer pageCount){
        IPage<Chat> wherePage = new Page<>(page, pageCount);
        Chat where = new Chat();

        return   baseMapper.selectPage(wherePage, Wrappers.query(where));
    }

    @Override
    public int add(Chat chat){
        return baseMapper.insert(chat);
    }

    @Override
    public int delete(Long id){
        return baseMapper.deleteById(id);
    }

    @Override
    public int updateData(Chat chat){
        return baseMapper.updateById(chat);
    }

    @Override
    public Chat findById(Long id){
        return  baseMapper.selectById(id);
    }
}
