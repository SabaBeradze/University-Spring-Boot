package dev.boot.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table
@Getter
@Setter
@SequenceGenerator(name = "ID_GEN2", sequenceName = "ID_SEQ2", allocationSize = 1)
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ID_GEN2")
    private long ID;

    @Column
    @NotBlank(message = "Name is mandatory")
    private String courseCode;
    @Column
    @NotBlank(message = "Name is mandatory")
    private String courseName;
    @Column(name = "EFF_FRO")
    private LocalDate EFF_FRO;
    @Column(name = "EFF_TO")
    private LocalDate EFF_TO;
    @Column(name = "Start_Date")
    private LocalDate startDate;
    @Column(name = "End_Date")
    private LocalDate EndDate;
    @Column(name = "Max_Number_Of_Students")
    private int maximumNumberOfStudents ;
    @Column(name = "Max_Number_Of_Registration")
    private int numberOfRegistration ;


//    @OneToMany(mappedBy = "student")
//    private Set<CourseRegistration> registrations;

}
