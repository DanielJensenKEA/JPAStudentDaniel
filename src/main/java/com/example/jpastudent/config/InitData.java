package com.example.jpastudent.config;

import com.example.jpastudent.StudentRepository.StudentRepository;
import com.example.jpastudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Component
public class InitData implements CommandLineRunner {
    @Autowired
    StudentRepository studentRepository;

    @Override
    public void run(String... args) throws Exception {
        Student s1 = new Student();
        s1.setName("Jens");
        s1.setBornDate(LocalDate.of(1990, 11, 12));
        s1.setBornTime(LocalTime.of(12, 11, 1));
        studentRepository.save(s1);
        studentRepository.save(s1);

        s1.setId(0);
        s1.setName("Kevin");
        studentRepository.save(s1);
    }
}
