package com.example.jpastudent.StudentRepository;

import com.example.jpastudent.model.Student;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StudentRepositoryTest {
    @Autowired
    StudentRepository studentRepository;

    @Test
    void testOneKevin() {
        List<Student> list = studentRepository.findAllByName("Kevin");
        assertEquals(1, list.size());
    }

    @Test
    void testOneViggo() {
        Student s1 = new Student();
        s1.setName("Viggo");
        s1.setBornDate(LocalDate.of(1990, 11, 11));
        studentRepository.save(s1);
        List<Student> list = studentRepository.findAllByName(s1.getName());
        assertEquals(1, list.size());
    }

}