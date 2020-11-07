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
            "teacher.username AS t_username,\n" +
            "student.username AS s_username\n" +
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
            "student.username AS susername,\n" +
            "makeup_exam.*,\n" +
            "teacher.username AS tusername\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id\n" +
            "WHERE\n" +
            "teacher.id = #{id} limit #{currIndex} , #{pageSize}")
    List<MakeupExamUName> selectByMyWrapper1(@Param("currIndex") Integer page,
                                             @Param("pageSize") Integer pageSize,
                                             @Param("id") Integer id);

    @Select("SELECT\n" +
            "student.username AS susername,\n" +
            "makeup_exam.*,\n" +
            "teacher.username AS tusername\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id\n" +
            "WHERE student.id = #{id} limit #{currIndex} , #{pageSize}")
    List<MakeupExamUName> selectByMyWrapper2(@Param("currIndex") Integer page,
                                             @Param("pageSize") Integer pageSize,
                                             @Param("id") Integer id);

    @Select("SELECT\n" +
            "count(*)\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id\n" +
            "WHERE\n" +
            "teacher.id = #{id}")
    int count1(@Param("id") Integer id);

    @Select("SELECT\n" +
            "count(*)\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "left JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "left JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "left JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id")
    int count();

    @Select("SELECT\n" +
            "count(*)\n" +
            "FROM\n" +
            "makeup_exam\n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id\n" +
            "WHERE student.id = #{id}")
    int count2(@Param("id") Integer id);
}
