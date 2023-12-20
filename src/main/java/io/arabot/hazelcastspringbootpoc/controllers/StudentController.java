package io.arabot.hazelcastspringbootpoc.controllers;

import io.arabot.hazelcastspringbootpoc.models.Student;
import io.arabot.hazelcastspringbootpoc.services.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> students(@PathVariable("studentId") Integer studentId){
        return ResponseEntity.ok(studentService.getStudents(studentId));
    }

    @PostMapping("/insertStudent")
    public void insertStudent(@RequestBody Student student){
        studentService.addStudent(student);
    }

    @PutMapping("/{studentId}")
    public void updateStudent(@RequestBody Student student, @PathVariable("studentId") Integer studentId){
        studentService.updateStudent(student,studentId);
    }

}
