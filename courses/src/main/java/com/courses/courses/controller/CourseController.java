package com.courses.courses.controller;


import com.courses.courses.DTO.CourseRequestDTO;
import com.courses.courses.mapper.CourseMapper;
import com.courses.courses.DTO.CourseResponseDTO;
import com.courses.courses.service.CourseService;
import com.courses.courses.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/course")

public class CourseController {
    private final CourseService courseService;

    private final CourseMapper courseMapper;
@Autowired
    public CourseController(CourseService courseService, CourseMapper courseMapper) {
        this.courseService = courseService;

        this.courseMapper = courseMapper;

    }


    @PostMapping("/add")
    public void add(@RequestBody CourseRequestDTO dto) {

        courseService.add(dto);
    }

    @GetMapping("/getAll")
    public List<CourseResponseDTO> findAll() {
        return courseService.findAll().stream().map(courseMapper::toDTO).toList();
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        courseService.delete(id);
    }

    @GetMapping("/student/{studentId}/courses")
    public List<Course> getCoursesForStudent(@PathVariable Long studentId) {
        return courseService.getCoursesForStudent(studentId);
    }

}
