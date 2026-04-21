package com.eureka.students.controller;

import com.eureka.students.DTO.*;
import com.eureka.students.mapper.StudentMapper;
import com.eureka.students.model.Student;
import com.eureka.students.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")

public class StudentController {
    private final StudentService studentService;
    private final StudentMapper studentMapper;

    @Autowired
    public StudentController(StudentService studentService, StudentMapper studentMapper) {
        this.studentService = studentService;
        this.studentMapper = studentMapper;
    }


    @GetMapping("/getAll")
    public List<StudentResponseDTO> findAll() {
        return studentService.findAll().stream().map(studentMapper::toDTO).toList();

    }

    @PostMapping("/add")
    public void add(@RequestBody StudentRequestDTO dto) {
        studentService.add(dto);
    }

    @GetMapping("/getByID/{id}")
    public StudentResponseDTO findByID(@PathVariable Long id) {
        Student student = studentService.findByID(id);
        return studentMapper.toDTO(student);
    }

    @PutMapping("/update")
    public void update(@RequestBody Student student) {
        studentService.update(student);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        studentService.delete(id);
    }

    @GetMapping("/getInCourses/{studentId}")
    public List<CourseResponseDTO> getStudentCourses(@PathVariable Long studentId) {
        return studentService.getStudentCourses(studentId);
    }

    @GetMapping("/getStudentExam/{studentId}")
    public List<ExamResponseDTO> getStudentExams(@PathVariable Long studentId) {
        return studentService.getStudentExams(studentId);
    }

    @GetMapping("/getStudentMarks/{studentId}")
    public List<MarkResponseDTO> getStudentMarks(@PathVariable Long studentId) {
        return studentService.getStudentMarks(studentId);
    }
}
