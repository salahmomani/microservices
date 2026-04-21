package com.teachers.teachers.controller;
import com.teachers.teachers.DTO.CourseResponseDTO;
import com.teachers.teachers.DTO.TeacherRequestDTO;
import com.teachers.teachers.mapeer.TeacherMapper;
import com.teachers.teachers.DTO.TeacherResponseDTO;
import com.teachers.teachers.service.TeacherService;
import com.teachers.teachers.model.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")

public class TeacherController {

    private final TeacherService teacherService;
    private final TeacherMapper teacherMapper;

    @Autowired
    public TeacherController(TeacherService teacherService, TeacherMapper teacherMapper) {
        this.teacherService = teacherService;
        this.teacherMapper = teacherMapper;
    }


    @GetMapping("/getAll")
    public List<TeacherResponseDTO> findAll() {
        return teacherService.findAll().stream().map(teacherMapper::toDTO).toList();
    }

    @PostMapping("/add")
    public void add(@RequestBody TeacherRequestDTO dto) {
        teacherService.add(dto);
    }

    @GetMapping("/getByID/{id}")
    public TeacherResponseDTO findByID(@PathVariable Long id) {
        Teacher teacher = teacherService.findByID(id);
        return teacherMapper.toDTO(teacher);
    }

    @PutMapping("/update")
    public void update(@RequestBody Teacher teacher) {
        teacherService.update(teacher);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        teacherService.deleteTeacher(id);
    }

    @GetMapping("/getTeacherCourses/{teacherId}")
    public List<CourseResponseDTO> getTeacherCourses(@PathVariable Long teacherId) {
        return teacherService.getTeacherCourses(teacherId);
    }
}
