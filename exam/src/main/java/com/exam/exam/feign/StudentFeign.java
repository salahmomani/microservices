package com.exam.exam.feign;

import com.exam.exam.DTO.StudentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentFeign {
    @GetMapping("/student/getByID/{id}")
    public StudentResponseDTO getStudent(@PathVariable Long id);

}
