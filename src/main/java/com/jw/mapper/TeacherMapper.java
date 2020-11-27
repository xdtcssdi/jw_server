package com.jw.mapper;

import com.jw.entity.MakeupExamUName;
import com.jw.entity.Res1;
import com.jw.entity.Res2;
import com.jw.entity.Teacher;
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
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select("SELECT\n" +
            "DISTINCT teacher.username,\n" +
            "teacher.`subject`,\n" +
            "teacher.phone,\n" +
            "teacher.email\n" +
            "FROM\n" +
            "student\n" +
            "JOIN makeup_exam\n" +
            "ON student.id = makeup_exam.student_id \n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id WHERE\n" +
            "student.id = #{id} limit #{currIndex} , #{pageSize}")
    List<Teacher> selectByMyWrapper(@Param("currIndex") Integer page,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("id") Integer id);
    @Select("SELECT\n" +
            "count(DISTINCT teacher.username)\n" +
            "FROM\n" +
            "student\n" +
            "JOIN makeup_exam\n" +
            "ON student.id = makeup_exam.student_id \n" +
            "JOIN exam\n" +
            "ON makeup_exam.exam_id = exam.exam_id \n" +
            "JOIN teacher\n" +
            "ON exam.teacher_id = teacher.id WHERE\n" +
            "student.id = #{id}")
    int count(@Param("id") Integer id);


    @Select("SELECT\n" +
            "DISTINCT student.username,\n" +
            "student.phone,\n" +
            "student.email\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id} limit #{currIndex} , #{pageSize}")
    List<Teacher> selectByMyWrapper1(@Param("currIndex") Integer page,
                                    @Param("pageSize") Integer pageSize,
                                    @Param("id") Integer id);
    @Select("SELECT\n" +
            "count(DISTINCT student.username)\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id \n" +
            "JOIN student\n" +
            "ON makeup_exam.student_id = student.id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id}")
    int count1(@Param("id") Integer id);

    @Select("SELECT DISTINCT id, username FROM teacher")
    List<Res2> options();
}
