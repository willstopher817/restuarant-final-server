package com.mercury.final_server.service;

import com.mercury.final_server.bean.Student;
import com.mercury.final_server.dao.StudentDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public List<Student> getAllStudents() {
        return studentDao.findAll();
    }

    public Student getOneStudent(Long id) {
        return studentDao.findById(id).orElse(new Student());
    }

}
