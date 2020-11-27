package com.jw.mapper;

import com.jw.entity.Exam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jw.entity.ExamInfo;
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
public interface ExamMapper extends BaseMapper<Exam> {

    @Select("SELECT\n" +
            "DISTINCT makeup_exam.classes,\n" +
            "teacher.username,\n" +
            "exam.id\n" +
            "FROM\n" +
            "exam\n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id limit #{currIndex} , #{pageSize}")
    List<ExamInfo> findAll(@Param("currIndex") Integer page, @Param("pageSize") Integer pageSize);

    @Select("SELECT count(DISTINCT exam.exam_id) FROM exam LEFT JOIN makeup_exam ON exam.exam_id = makeup_exam.exam_id left JOIN teacher ON exam.teacher_id = teacher.id")
    int count();
}