package com.courses.courses.DTO;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class CourseResponseDTO {

    private Long id;
    private String code;
    private String title;

    private List<Long> studentId = new ArrayList<>();
    private List<Long> teacherId = new ArrayList<>();
    private List<Long> examId = new ArrayList<>();
}