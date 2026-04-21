package com.exam.exam.feign;

import com.exam.exam.DTO.CourseResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "COURSE-SERVICE")
public interface CourseFeign {
    @GetMapping("/course/getByID/{id}")
    public CourseResponseDTO getCourse(@PathVariable Long id);
}
