package com.mark.mark.service;


import com.mark.mark.DTO.ExamResponseDTO;
import com.mark.mark.DTO.MarkRequestDTO;
import com.mark.mark.DTO.StudentResponseDTO;
import com.mark.mark.feign.ExamFeignClient;
import com.mark.mark.feign.StudentFeignClient;
import com.mark.mark.model.Mark;
import com.mark.mark.repo.MarkRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MarkService {

    private final MarkRepo markRepo;
    //    private final StudentsRepo studentRepository;
//    private final ExamRepo examRepository;
    ExamFeignClient examFeignClient;
    StudentFeignClient studentFeignClient;

    @Autowired
    public MarkService(MarkRepo markRepo, ExamFeignClient examFeignClient, StudentFeignClient studentFeignClient) {
        this.markRepo = markRepo;
        this.examFeignClient = examFeignClient;
        this.studentFeignClient = studentFeignClient;
    }

    public Mark addMark(MarkRequestDTO dto) {

        studentFeignClient.getStudent(dto.getStudentId());

        examFeignClient.getExam(dto.getExamId());

        Mark mark = new Mark();
        mark.setScore(dto.getScore());
        mark.setGrade(dto.getGrade());
        mark.setStudentId(dto.getStudentId());
        mark.setExamId(dto.getExamId());

        return markRepo.save(mark);
    }


    public StudentResponseDTO getStudent(Long id) {
        return studentFeignClient.getStudent(id);
    }

    public ExamResponseDTO getExam(Long id) {
        return examFeignClient.getExam(id);
    }

    public List<Mark> findAll() {
        return markRepo.findAll();
    }

    public void delete(Long id) {
        markRepo.deleteById(id);
    }
}
