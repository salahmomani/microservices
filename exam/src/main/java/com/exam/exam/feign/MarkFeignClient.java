package com.exam.exam.feign;

import com.exam.exam.DTO.MarkResponseDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "MARK-SERVICE")
public interface MarkFeignClient {

    @GetMapping("/mark/exam/{examId}")
    List<MarkResponseDTO> getMarksByExam(@PathVariable Long examId);
}
