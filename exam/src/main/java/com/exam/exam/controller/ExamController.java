package com.exam.exam.controller;
import com.exam.exam.DTO.*;
import com.exam.exam.mapper.ExamMapper;
import com.exam.exam.service.ExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exam")
public class ExamController {

    private final ExamService examService;
    private final ExamMapper examMapper;

    @Autowired
    public ExamController(ExamService examService, ExamMapper examMapper) {
        this.examService = examService;
        this.examMapper = examMapper;
    }


    @PostMapping("/add")
    public String addExam(@RequestBody ExamRequestDTO dto) {
        examService.add(dto);
        return "Exam Added Successfully!";
    }

    @GetMapping("/all")
    public List<ExamResponseDTO> getAll() {
        return examService.getAll().stream().map(examMapper::toDTO).toList();
    }

    @GetMapping("/course/{courseId}")
    public List<ExamResponseDTO> getByCourse(@PathVariable Long courseId) {
        return examService.getByCourseId(courseId).stream().map(examMapper::toDTO).toList();
    }

    //
//    @GetMapping("/student/{studentId}")
//    public List<ExamResponseDTO> getByStudent(@PathVariable Long studentId) {
//        return examService.getByStudentId(studentId).stream().map(examMapper::toDTO).toList();
//    }
    @GetMapping("/getCourse/{id}")
    public CourseResponseDTO getCourse(@PathVariable Long id) {
        return examService.getCourse(id);
    }

    @GetMapping("/getStudent/{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id) {
        return examService.getAStudent(id);
    }

    @PutMapping("/edit")
    public void update(@RequestBody ExamRequestDTO dto) {
        examService.update(dto);
    }

    @GetMapping("/examMarks/{examId}")
    public List<MarkResponseDTO> getExamMarks(@PathVariable Long examId) {
        return examService.getMarksForExam(examId);
    }

    @GetMapping("/examWithMarks/{id}")
    public ExamWithMarksDTO getExamWithMarks(@PathVariable Long id) {
        return examService.getExamWithMarks(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        examService.delete(id);
    }
}
