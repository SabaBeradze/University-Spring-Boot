package dev.boot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.time.LocalDate;

@Table(name = "student_course")
@Entity
@Getter
@Setter
@SequenceGenerator(name = "ID_GEN1", sequenceName = "ID_SEQ1", allocationSize = 1)
public class CourseRegistration {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN1")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "course_id")
    private Course course;

    @Column
    @Min(0)
    @Max(100)
    private int grade=0;

    @Column
    private LocalDate registrationDate;

    @Column
    @Min(0)
    private int numberOfRegistration=0;

    // additional properties
    // standard constructors, getters, and setters
}