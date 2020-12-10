package com.mercury.final_server.dao;

import com.mercury.final_server.bean.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student, Long> {
}
