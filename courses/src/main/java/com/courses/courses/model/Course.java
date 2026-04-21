package com.courses.courses.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String code;

    private String title;

  //  @ManyToMany(mappedBy = "courses")
    @ElementCollection
    private List<Long> studentId = new ArrayList<>();

    @ElementCollection
    private List<Long> teacherId = new ArrayList<>();

    @ElementCollection
    private List<Long> examId = new ArrayList<>();
}
