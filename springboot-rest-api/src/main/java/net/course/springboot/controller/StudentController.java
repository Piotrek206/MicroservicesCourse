package net.course.springboot.controller;

import net.course.springboot.beans.Student;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    List<Student> students = new ArrayList<>();

//    @GetMapping("/student")
//    public Student getStudent() {
//        Student student = new Student(1, "Pjoter", "Test");
//        return student;
//    }

    @GetMapping
    public ResponseEntity<Student> getStudent() {
        Student student = new Student(1, "Pjoter", "Test");
//        return ResponseEntity.ok(student);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @GetMapping("/students")
    public List<Student> getStudents() {
        createStudentList();
        return students;
    }

    @GetMapping("{id}")
    public Student getStudentById(@PathVariable int id) {
        createStudentList();
        return students.get(id);
    }

    @GetMapping("query")
    public Student getStudentByIdInQuery(@RequestParam int id) {
        createStudentList();
        return students.get(id);
    }

    private void createStudentList() {
        students.add(new Student(0, "Pjoter", "Test"));
        students.add(new Student(1, "Pjoter2", "Test2"));
        students.add(new Student(2, "Pjoter3", "Test3"));
    }

    @PostMapping("create")
    @ResponseStatus(HttpStatus.CREATED)
    public Student createStudent(@RequestBody Student student) {
        System.out.println(student);
        return student;
    }

    @PutMapping("{id}/update")
    @ResponseStatus(HttpStatus.OK)
    public Student updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
        student.setId(id);
        System.out.println(student);
        return student;
    }

    @DeleteMapping("{id}/delete")
    @ResponseStatus(HttpStatus.OK)
    public Student deleteStudent(@PathVariable int id) {
        createStudentList();
        return students.get(id);
    }
}
