package com.exam.exam.service;


import com.exam.exam.DTO.*;
import com.exam.exam.feign.CourseFeign;
import com.exam.exam.feign.MarkFeignClient;
import com.exam.exam.feign.StudentFeign;
import com.exam.exam.model.Exam;
import com.exam.exam.repo.ExamRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExamService {

    private final ExamRepo repoExam;
    CourseFeign courseFeign;
    StudentFeign studentFeign;
    MarkFeignClient markFeignClient;

    @Autowired

    public ExamService(ExamRepo repoExam, CourseFeign courseFeign, StudentFeign studentFeign, MarkFeignClient markFeignClient) {
        this.repoExam = repoExam;
        this.courseFeign = courseFeign;
        this.studentFeign = studentFeign;
        this.markFeignClient = markFeignClient;
    }

    public List<MarkResponseDTO> getMarksForExam(Long examId) {
        return markFeignClient.getMarksByExam(examId);
    }

    public void add(ExamRequestDTO dto) {
        Exam exam = new Exam();
        exam.setMaxScore(dto.getMaxScore());
        exam.setName(dto.getName());
        exam.setCourseIds(List.of(dto.getCourseIds()));
        repoExam.save(exam);
    }

    public List<Exam> getAll() {
        return repoExam.findAll();
    }

    public List<Exam> getByCourseId(Long courseId) {
        return repoExam.findByCourseIdsContaining(courseId);
    }

//    public List<Exam> getByStudentId(Long studentId) {
//        return repoExam.findByStudentId(studentId);
//    }

    public CourseResponseDTO getCourse(Long id) {
        return courseFeign.getCourse(id);
    }

    public StudentResponseDTO getAStudent(Long id) {
        return studentFeign.getStudent(id);
    }
    public ExamWithMarksDTO getExamWithMarks(Long examId) {
        Exam exam = repoExam.findById(examId)
                .orElseThrow(() -> new RuntimeException("Exam not found"));

        List<MarkResponseDTO> marks = markFeignClient.getMarksByExam(examId);

        return new ExamWithMarksDTO(
                exam.getId(),
                exam.getName(),
                exam.getMaxScore(),
                exam.getCourseIds(),
                marks
        );
    }

    public void update(ExamRequestDTO dto) {
        Exam exam = new Exam();
        exam.setMaxScore(dto.getMaxScore());
        exam.setName(dto.getName());
        exam.setCourseIds(List.of(dto.getCourseIds()));
        repoExam.save(exam);
    }

    public void delete(Long id) {
        repoExam.deleteById(id);
    }
}
