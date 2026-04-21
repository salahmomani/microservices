package com.mark.mark.DTO;

import lombok.Data;

import java.util.List;
@Data
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
//    private List<CourseDTO> courses;
}