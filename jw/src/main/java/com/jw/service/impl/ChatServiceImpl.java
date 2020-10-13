package com.jw.service.impl;

import com.jw.entity.Chat;
import com.jw.mapper.ChatMapper;
import com.jw.service.IChatService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author xx
 * @since 2020-10-13
 */
@Service
public class ChatServiceImpl extends ServiceImpl<ChatMapper, Chat> implements IChatService {

}
