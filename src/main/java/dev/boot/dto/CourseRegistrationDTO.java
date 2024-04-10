package dev.boot.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.boot.domain.Student;
import dev.boot.domain.Course;
import dev.boot.domain.CourseRegistration;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(title = "Student", description = "Students information of the college")

public class CourseRegistrationDTO {
    private final CourseRegistration courseRegistration;

    public CourseRegistrationDTO() {
        this(new CourseRegistration());
    }

    public CourseRegistrationDTO(CourseRegistration courseRegistration) {
        this.courseRegistration = courseRegistration;
    }

    public CourseRegistration toCourseRegistration() {
        return courseRegistration;
    }

    @Schema
    public long getId() {
        return courseRegistration.getId();
    }

    @Schema
    @JsonIgnore

    public Student getStudent() {
        return courseRegistration.getStudent();
    }

    @JsonIgnore
    @Schema
    public Course getCourse() {
        return courseRegistration.getCourse();
    }

    @Schema
    public long getStudentId() {
        return courseRegistration.getStudent().getId();
    }

    @Schema
    public long getCourseId() {
        return courseRegistration.getStudent().getId();
    }

    @Schema
    public int getGrade() {
        return courseRegistration.getGrade();
    }

    @Schema
    public LocalDate getRegistrationDate() {
        return courseRegistration.getRegistrationDate();
    }

    @Schema
    public int getNumberOfRegistration() {
        return courseRegistration.getNumberOfRegistration();
    }

    @Schema

    public void setId(long Id) {
        courseRegistration.setId(Id);
    }


    public void setGrade(int grade) {
        courseRegistration.setGrade(grade);
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        courseRegistration.setRegistrationDate(registrationDate);
    }

    public void setCourse(Course course) {
        this.courseRegistration.setCourse(course);
    }

    public void setStudent(Student student) {
        courseRegistration.setStudent(student);
    }

    public void setNumberOfRegistration(int number) {
        courseRegistration.setNumberOfRegistration(number);
    }
}
