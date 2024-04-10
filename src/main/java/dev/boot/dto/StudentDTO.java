package dev.boot.dto;


import dev.boot.domain.Student;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(title = "Student", description = "Students information of the college")

public class StudentDTO {
    private final Student student;

    public StudentDTO() {
        this(new Student());
    }

    public StudentDTO(Student student) {
        this.student = student;
    }

    public Student toStudent() {
        return student;
    }

    @Schema(description = "Name of the student")
    public String getFirstName() {
        return student.getFirstName();
    }

    @Schema(description = "Name of the student")
    public String getLastName() {
        return student.getLastName();
    }

    @Schema(description = "mail of student")
    public String getEmail() {
        return student.getEmail();
    }

    @Schema(description = "birthday of student")
    public LocalDate getBirthDay() {
        return student.getBirthday();
    }

    @Schema(description = "id of student")
    public long getId() {
        return student.getId();
    }

    @Schema(hidden = true)
    public void setId(long id) {
        student.setId(id);
    }

    public void setFirstName(String name) {
        student.setFirstName(name);
    }

    public void setLastName(String name) {
        student.setLastName(name);
    }

    public void setEmail(String email) {
        student.setEmail(email);
    }

    public void setBirthDay(LocalDate birthDay) {
        student.setBirthday(birthDay);
    }


}
