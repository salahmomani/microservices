package com.exam.exam.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExamWithMarksDTO {
    private Long id;
    private String name;
    private int maxScore;
    private List<Long> courseIds;
    private List<MarkResponseDTO> marks; // marks from MarkService
}
