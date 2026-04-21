package com.courses.courses.repo;

import com.courses.courses.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CoursesRepo extends JpaRepository<Course, Long> {
   // List<Course> findByStudentsId(Long studentId);
    List<Course> findByStudentIdContaining(Long studentId);
    //  @Query("SELECT c FROM Course c JOIN c.students s WHERE s.id = :studentId")
   // List<Course> findByStudentsId(@Param("studentId") Long studentId);
}
