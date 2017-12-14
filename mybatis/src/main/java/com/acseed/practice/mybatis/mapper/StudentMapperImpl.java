package com.acseed.practice.mybatis.mapper;

import com.acseed.practice.mybatis.model.Student;

/**
 * Created by caohongchen on 17-8-21.
 */
public class StudentMapperImpl implements StudentMapper {
    public Student getStudentById(int id) {
        System.out.println("invoke real impl");
        return new Student();
    }

    public int insert(Student student) {
        System.out.println("invoke real impl");
        return 0;
    }
}
