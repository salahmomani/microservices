package com.eureka.students.mapper;

import com.eureka.students.DTO.StudentResponseDTO;
import com.eureka.students.model.Student;
import org.springframework.stereotype.Component;
@Component
public class StudentMapper {
    public StudentResponseDTO toDTO(Student student) {
        StudentResponseDTO dto = new StudentResponseDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());
        dto.setCourseIds(student.getCourseIds());


//        dto.setCourses(
//                student.getCourses().stream()
//                        .map(CourseMapper::toCourseDTO)
//                        .collect(Collectors.toList())
//        );

        return dto;
    }
}
