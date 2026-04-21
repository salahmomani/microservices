package com.eureka.students.DTO;

import lombok.Data;

import java.util.List;

@Data
public class StudentResponseDTO {
    private Long id;
    private String name;
    private String email;
   private List<Long> courseIds;
}