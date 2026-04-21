package com.courses.courses.service;

import com.courses.courses.DTO.CourseRequestDTO;
import com.courses.courses.repo.CoursesRepo;
import com.courses.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {

    private final CoursesRepo repoCourse;

    @Autowired
    public CourseService(CoursesRepo repoCourse) {
        this.repoCourse = repoCourse;
    }

    public List<Course> findAll() {
        return repoCourse.findAll();
    }

    public void add(CourseRequestDTO dto) {
        Course course = new Course();
        course.setCode(dto.getCode());
        course.setTitle(dto.getTitle());
        repoCourse.save(course);
    }

    public void delete(Long id) {
        repoCourse.deleteById(id);
    }

    public List<Course> getCoursesForStudent(Long studentId) {
        return repoCourse.findByStudentIdContaining(studentId);
    }
}
