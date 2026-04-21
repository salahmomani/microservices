package com.eureka.students.Feign;

import com.eureka.students.DTO.CourseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseFeignClient {
    @GetMapping("/course/student/{studentId}/courses")
    List<CourseResponseDTO> getCoursesForStudent(@PathVariable Long studentId);
}
