package com.teachers.teachers.Feign;

import com.teachers.teachers.DTO.CourseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseFeignClient {
    @GetMapping("/getTeacherCourses/{teacherId}")
    public List<CourseResponseDTO> getTeacherCourses(@PathVariable Long teacherId);
}
