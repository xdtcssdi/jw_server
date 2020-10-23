package com.jw.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.jw.entity.MakeupExam;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.jw.entity.MakeupExamUName;
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
    @Select("SELECT\n" +
            "makeup_exam.*,\n" +
            "teacher.username AS s_username,\n" +
            "student.username AS t_username\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "left JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "left JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "left JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id limit #{currIndex} , #{pageSize}")
    List<MakeupExamUName> selectByMyWrapper(@Param("currIndex") Integer page, @Param("pageSize") Integer pageSize);

    @Select("SELECT\n" +
            "DISTINCT makeup_exam.*\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id} limit #{currIndex} , #{pageSize}")
    List<MakeupExam> selectByMyWrapper1(@Param("currIndex") Integer page,
                                             @Param("pageSize") Integer pageSize,
                                             @Param("id") Integer id);

    @Select("SELECT\n" +
            "count(distinct makeup_exam.id)\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id}")
    int count1(@Param("id") Integer id);

}
