package com.example.jpastudent.StudentRepository;

import com.example.jpastudent.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;

public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByName(String name);
}
