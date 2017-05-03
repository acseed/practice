package com.acseed.practice.mybatis;

import com.acseed.practice.mybatis.mapper.StudentMapper;
import com.acseed.practice.mybatis.model.Sex;
import com.acseed.practice.mybatis.model.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by caohongchen on 17-3-2.
 */
public class Main {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

        Student student = new Student();
        student.setId(1);
        student.setAge(28);
        student.setName("acseed");
        student.setSex(Sex.MALE);

        SqlSession sqlSession = sqlSessionFactory.openSession();
//        sqlSession.insert("com.acseed.practice.mybatis.mapper.StudentMapper.insert", student);
//        Student s = sqlSession.selectOne("com.acseed.practice.mybatis.mapper.StudentMapper.getStudentById", 1);
//        sqlSession.commit();

        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);
        Student st = studentMapper.getStudentById(1);
        System.out.println();
    }
}
