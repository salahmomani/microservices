package com.mark.mark.mapper;


import com.mark.mark.DTO.MarkDTO;
import com.mark.mark.DTO.MarkResponseDTO;
import com.mark.mark.model.Mark;
import org.springframework.stereotype.Component;

@Component
public class MarkMapper {

    public MarkResponseDTO toDTO(Mark mark) {
        MarkResponseDTO dto = new MarkResponseDTO();
        dto.setId(mark.getId());
        dto.setScore(mark.getScore());
        dto.setGrade(mark.getGrade());
        dto.setStudentId(mark.getStudentId());
        dto.setExamId(mark.getExamId());
        return dto;
    }

    public static MarkDTO toMarkDTO(Mark mark) {
        MarkDTO dto = new MarkDTO();
        dto.setId(mark.getId());
        dto.setScore(mark.getScore());
        dto.setGrade(mark.getGrade());
        return dto;
    }


}
