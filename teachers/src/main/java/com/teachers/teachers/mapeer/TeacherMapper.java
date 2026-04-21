package com.teachers.teachers.mapeer;


import com.teachers.teachers.DTO.TeacherRequestDTO;
import com.teachers.teachers.DTO.TeacherResponseDTO;
import com.teachers.teachers.model.Teacher;
import org.springframework.stereotype.Component;

@Component
public class TeacherMapper {

    public TeacherResponseDTO toDTO(Teacher teacher) {
        TeacherResponseDTO dto = new TeacherResponseDTO();
        dto.setId(teacher.getId());
        dto.setName(teacher.getName());
        dto.setEmail(teacher.getEmail());
        dto.setCourseIds(teacher.getCourseIds());

        return dto;
    }
    public Teacher toEntity(TeacherRequestDTO dto) {
        Teacher teacher = new Teacher();

        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        teacher.setCourseIds(dto.getCourseIds());

        return teacher;
    }
}
