package com.example.jpastudent.Controller;

import com.example.jpastudent.StudentRepository.StudentRepository;
import com.example.jpastudent.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentRestController {
    @Autowired
    StudentRepository studentRepository;

    @GetMapping("/students")
    public List<Student> students() {
        return studentRepository.findAll();
    }

    @PostMapping("/student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student postStudent(@RequestBody Student student) {
        System.out.println(student);
        return studentRepository.save(student);
    }

    //    @PutMapping("/student")
//    public ResponseEntity<Student> putStudent (@RequestBody Student student) {
//        Optional<Student> orgStudent = studentRepository.findById(student.getId());
//        if (orgStudent.isPresent()) {
//            studentRepository.save(student);
//            return new ResponseEntity<>(student, HttpStatus.OK);
//        } else {
//            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
//        }
//    }
    @PutMapping("/student/{id}")
    //Form for standard ifølge ChatGPT at bruge 2 parametre i forbindelse med putmapping - får 405 method not allowed
    public ResponseEntity<Student> putStudent(@PathVariable int id, @RequestBody Student student) {
        Optional<Student> orgStudent = studentRepository.findById(student.getId());
        if (orgStudent.isPresent()) {
            studentRepository.save(student);
            return new ResponseEntity<>(student, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(new Student(), HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("student/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id) {
        Optional<Student> orgStudent = studentRepository.findById(id);
        if (orgStudent.isPresent()) {
            studentRepository.deleteById(id);
            return ResponseEntity.ok("Student deleted");
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found.");
        }
    }

    @GetMapping("/students/{name}")
    public List<Student> getAllStudentsByName(@PathVariable String name) {
        return studentRepository.findAllByName(name);
    }
}
