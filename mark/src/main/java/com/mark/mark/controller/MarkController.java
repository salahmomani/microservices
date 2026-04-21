package com.mark.mark.controller;


import com.mark.mark.DTO.ExamResponseDTO;
import com.mark.mark.DTO.StudentResponseDTO;
import com.mark.mark.mapper.MarkMapper;
import com.mark.mark.DTO.MarkRequestDTO;
import com.mark.mark.DTO.MarkResponseDTO;
import com.mark.mark.service.MarkService;
import com.mark.mark.model.Mark;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mark")
public class MarkController {
    private final MarkService markService;
    private final MarkMapper markMapper;

    @Autowired
    public MarkController(MarkService markService, MarkMapper markMapper) {
        this.markService = markService;
        this.markMapper = markMapper;
    }

    @GetMapping("/exam/{id}")
    ExamResponseDTO getExam(@PathVariable Long id) {
        return markService.getExam(id);
    }

    @GetMapping("/student/{id}")
    StudentResponseDTO getStudent(@PathVariable Long id) {
        return markService.getStudent(id);
    }

    @PostMapping("/add")
    public MarkResponseDTO add(@RequestBody MarkRequestDTO dto) {
        Mark saved = markService.addMark(dto);
        return markMapper.toDTO(saved);
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id) {
        markService.delete(id);
    }

    @GetMapping("/all")
    public List<MarkResponseDTO> findAll() {
        return markService.findAll().stream().map(markMapper::toDTO).toList();
    }
}
