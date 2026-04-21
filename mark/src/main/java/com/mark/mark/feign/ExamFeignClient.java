package com.mark.mark.feign;

import com.mark.mark.DTO.ExamResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "EXAM-SERVICE")
public interface ExamFeignClient {

    @GetMapping("/exam/{id}")
    ExamResponseDTO getExam(@PathVariable Long id);
}
