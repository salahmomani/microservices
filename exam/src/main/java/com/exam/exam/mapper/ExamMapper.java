package com.exam.exam.mapper;

import com.exam.exam.DTO.ExamDTO;
import com.exam.exam.DTO.ExamResponseDTO;
import com.exam.exam.model.Exam;
import org.springframework.stereotype.Component;

@Component
public class ExamMapper {

    public ExamResponseDTO toDTO(Exam exam) {
        ExamResponseDTO dto = new ExamResponseDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setMaxScore(exam.getMaxScore());
        dto.setCourseIds(exam.getCourseIds());
        return dto;
    }

    public static ExamDTO toExamDTO(Exam exam) {
        ExamDTO dto = new ExamDTO();
        dto.setId(exam.getId());
        dto.setName(exam.getName());
        dto.setMaxScore(exam.getMaxScore());
        return dto;
    }

}
