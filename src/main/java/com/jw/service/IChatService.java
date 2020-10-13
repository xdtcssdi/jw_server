package com.jw.service;

import com.jw.entity.Chat;
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
public interface IChatService extends IService<Chat> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<Chat>
     */
    IPage<Chat> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param chat 
     * @return int
     */
    int add(Chat chat);

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
     * @param chat 
     * @return int
     */
    int updateData(Chat chat);

    /**
     * id查询数据
     *
     * @param id id
     * @return Chat
     */
    Chat findById(Long id);
}
