package com.jw.service;

import com.jw.entity.History;
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
public interface IHistoryService extends IService<History> {

    /**
     * 查询分页数据
     *
     * @param page      页码
     * @param pageCount 每页条数
     * @return IPage<History>
     */
    IPage<History> findListByPage(Integer page, Integer pageCount);

    /**
     * 添加
     *
     * @param history 
     * @return int
     */
    int add(History history);

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
     * @param history 
     * @return int
     */
    int updateData(History history);

    /**
     * id查询数据
     *
     * @param id id
     * @return History
     */
    History findById(Long id);
}
