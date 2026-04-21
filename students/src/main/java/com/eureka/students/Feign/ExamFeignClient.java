package com.eureka.students.Feign;

import com.eureka.students.DTO.ExamResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "EXAM-SERVICE")
public interface ExamFeignClient {
    @GetMapping("/exam/student/{studentId}")
    List<ExamResponseDTO> getStudentExams(@PathVariable Long studentId);
}
