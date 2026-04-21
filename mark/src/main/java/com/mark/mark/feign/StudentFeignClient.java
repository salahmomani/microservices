package com.mark.mark.feign;

import com.mark.mark.DTO.StudentResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "STUDENT-SERVICE")
public interface StudentFeignClient {

    @GetMapping("/student/getByID/{id}")
    StudentResponseDTO getStudent(@PathVariable Long id);
}