package com.eureka.students.DTO;

import lombok.Data;

import java.util.List;
@Data
public class ExamResponseDTO {
    private Long id;
    private String name;
    private int maxScore;
    private Long courseId;
}
