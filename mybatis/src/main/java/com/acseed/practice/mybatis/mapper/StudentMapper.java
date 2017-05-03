package com.acseed.practice.mybatis.mapper;

import com.acseed.practice.mybatis.model.Student;
import org.apache.ibatis.annotations.Param;

/**
 * Created by caohongchen on 17-3-3.
 */
public interface StudentMapper {
    Student getStudentById(@Param("id") int id);

    int insert(Student student);
}
