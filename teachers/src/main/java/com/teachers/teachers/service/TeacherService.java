package com.teachers.teachers.service;


//import com.jpa.ProjectJPA.Model.Teacher;
//import com.jpa.ProjectJPA.Repo.TeacherRepo;

import com.teachers.teachers.DTO.CourseResponseDTO;
import com.teachers.teachers.DTO.TeacherRequestDTO;
import com.teachers.teachers.Feign.CourseFeignClient;
import com.teachers.teachers.model.Teacher;
import com.teachers.teachers.repo.TeacherRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherService {

    private final TeacherRepo repoTeacher;

    private final CourseFeignClient courseFeignClient;

    public TeacherService(TeacherRepo repoTeacher,
                          CourseFeignClient courseFeignClient) {
        this.repoTeacher = repoTeacher;
        this.courseFeignClient = courseFeignClient;
    }

    public List<Teacher> findAll() {
        return repoTeacher.findAll();
    }

    public void add(TeacherRequestDTO dto) {
        Teacher teacher = new Teacher();
        teacher.setName(dto.getName());
        teacher.setEmail(dto.getEmail());
        teacher.setCourseIds(dto.getCourseIds());
        repoTeacher.save(teacher);
    }

    public Teacher findByID(Long id) {
        return repoTeacher.findById(id).orElseThrow(() -> new RuntimeException("teacher not found"));
    }

    public void update(Teacher teacher) {
        repoTeacher.save(teacher);
    }

    public void deleteTeacher(Long id) {
        repoTeacher.deleteById(id);
    }

    public List<CourseResponseDTO> getTeacherCourses(Long teacherId) {
        return courseFeignClient.getTeacherCourses(teacherId);
    }
}
