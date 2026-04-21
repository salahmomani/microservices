package com.eureka.students.Feign;

import com.eureka.students.DTO.MarkResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MARK-SERVICE")

public interface MarkFeignClient {
    @GetMapping("/mark/student/{studentId}")
    List<MarkResponseDTO> getStudentMarks(@PathVariable Long studentId);
}
