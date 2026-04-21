package com.courses.courses.mapper;

import com.courses.courses.DTO.CourseDTO;
import com.courses.courses.DTO.CourseResponseDTO;
import com.courses.courses.model.Course;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponseDTO toDTO(Course course) {
        CourseResponseDTO dto = new CourseResponseDTO();

        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setTitle(course.getTitle());
        return dto;
    }


    public static CourseDTO toCourseDTO(Course course) {
        CourseDTO dto = new CourseDTO();
        dto.setId(course.getId());
        dto.setCode(course.getCode());
        dto.setTitle(course.getTitle());
        return dto;
    }

}
