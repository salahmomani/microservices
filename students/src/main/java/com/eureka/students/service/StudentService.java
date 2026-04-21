package com.eureka.students.service;

import com.eureka.students.DTO.CourseResponseDTO;
import com.eureka.students.DTO.ExamResponseDTO;
import com.eureka.students.DTO.MarkResponseDTO;
import com.eureka.students.DTO.StudentRequestDTO;
import com.eureka.students.Feign.CourseFeignClient;
import com.eureka.students.Feign.ExamFeignClient;
import com.eureka.students.Feign.MarkFeignClient;
import com.eureka.students.repo.StudentsRepo;
import com.eureka.students.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {


    private final StudentsRepo repoStudents;
    CourseFeignClient courseFeignClient;
    ExamFeignClient examFeignClient;
    MarkFeignClient markFeignClient;

    @Autowired
    public StudentService(StudentsRepo repoStudents, CourseFeignClient courseFeignClient, ExamFeignClient examFeignClient, MarkFeignClient markFeignClient) {
        this.repoStudents = repoStudents;
        this.courseFeignClient = courseFeignClient;
        this.examFeignClient = examFeignClient;
        this.markFeignClient = markFeignClient;
    }
//    public StudentService(StudentsRepo repoStudents) {
//        this.repoStudents = repoStudents;
//    }

    public List<Student> findAll() {
        return repoStudents.findAll();
    }

    public void add(StudentRequestDTO dto) {
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourseIds(dto.getCourseIds());

        repoStudents.save(student);
    }

    public Student findByID(Long id) {
        return repoStudents.findById(id).orElseThrow(()->new RuntimeException("student not found"));
    }

    public void update(Student student) {
        repoStudents.save(student);
    }

    public void delete(Long id) {
        repoStudents.deleteById(id);
    }

    public List<CourseResponseDTO> getStudentCourses(Long studentId) {
        return courseFeignClient.getCoursesForStudent(studentId);
    }

    public List<ExamResponseDTO> getStudentExams(Long studentId) {
        return examFeignClient.getStudentExams(studentId);
    }

    public List<MarkResponseDTO> getStudentMarks(Long studentId) {
        return markFeignClient.getStudentMarks(studentId);
    }
}
