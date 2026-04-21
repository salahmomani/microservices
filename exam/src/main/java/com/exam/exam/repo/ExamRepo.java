package com.exam.exam.repo;

import com.exam.exam.model.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExamRepo extends JpaRepository<Exam, Long> {
    List<Exam> findByCourseIdsContaining(Long courseId);

   // List<Exam> findByCourseId(Long courseId);
 //   List<Exam> findByCourseIdsContaining(Long courseId);

    //List<Exam> findByStudentId(Long studentId);
}
