package com.jw.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jw.entity.MakeupExam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author x
 * @since 2020-10-13
 */
public interface MakeupExamMapper extends BaseMapper<MakeupExam> {
    @Select("SELECT * FROM makeup_exam ${ew.customSqlSegment}")
    List<MakeupExam> selectByMyWrapper(@Param(Constants.WRAPPER) Wrapper<MakeupExam> examWrapper);
}
