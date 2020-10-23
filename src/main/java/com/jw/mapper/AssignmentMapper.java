package com.jw.mapper;

import com.jw.entity.Assignment;
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
public interface AssignmentMapper extends BaseMapper<Assignment> {

    @Select("SELECT\n" +
            "DISTINCT assignment.*\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id \n" +
            "JOIN assignment\n" +
            "ON makeup_exam.id = assignment.m_id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id} limit #{currIndex} , #{pageSize}")
    List<Assignment> findAssignmentByTeacherId(@Param("currIndex") Integer page,
                                               @Param("pageSize") Integer pageSize,
                                               @Param("id") Integer id);

    @Select("SELECT\n" +
            "count(DISTINCT assignment.id)\n" +
            "FROM\n" +
            "teacher\n" +
            "JOIN exam\n" +
            "ON teacher.id = exam.teacher_id \n" +
            "JOIN makeup_exam\n" +
            "ON exam.exam_id = makeup_exam.exam_id \n" +
            "JOIN assignment\n" +
            "ON makeup_exam.id = assignment.m_id\n" +
            "WHERE\n" +
            "jw.teacher.id = #{id}")
    int findAssignmentByTeacherIdCount(@Param("id") Integer id);
}
