package com.exam.exam.DTO;
import lombok.Data;
@Data
public class ExamRequestDTO {
    private String name;
    private int maxScore;
    private Long courseIds;
}
