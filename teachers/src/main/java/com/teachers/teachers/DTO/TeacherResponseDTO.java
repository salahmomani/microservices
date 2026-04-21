package com.teachers.teachers.DTO;

import lombok.Data;

import java.util.List;

@Data
public class TeacherResponseDTO {
    private Long id;
    private String name;
    private String email;
    private List<Long> courseIds;

}
