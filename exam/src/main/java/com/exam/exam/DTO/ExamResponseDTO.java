package com.exam.exam.DTO;

import lombok.Data;

import java.util.List;

@Data
public class ExamResponseDTO {
    private Long id;
    private String name;
    private int maxScore;
   // private Long courseId;
    private List<Long> courseIds;
}
