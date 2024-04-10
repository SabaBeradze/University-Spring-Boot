package dev.boot.dto;


import dev.boot.domain.Course;
import io.swagger.v3.oas.annotations.media.Schema;

import java.time.LocalDate;

@Schema(title = "Course", description = "Course of the student")

public class CourseDTO {
    private final Course course;

    public CourseDTO() {
        this(new Course());
    }

    public CourseDTO(Course account) {
        this.course = account;
    }

    public Course toCourse() {
        return course;
    }

    @Schema(title = "Course name")
    public String getCourseName() {
        return course.getCourseName();
    }

    @Schema(title = "Course start Date")

    public LocalDate getStartDate() {
        return course.getStartDate();
    }

    @Schema(title = "Course end Date")
    public LocalDate getEndDate() {
        return course.getEndDate();
    }

    public int getCourseCapacity() {
        return course.getMaximumNumberOfStudents();
    }

    public String getCourseCode() {
        return course.getCourseCode();
    }

    public LocalDate getEFF_FRO() {
        return course.getEFF_FRO();
    }

    public LocalDate getEFF_TO() {
        return course.getEFF_TO();
    }
    public  int getNumberOfRegistration(){
        return course.getNumberOfRegistration();
    }
    @Schema(title = " Id Of course")
    public long getCourseId() {
        return course.getID();
    }

    @Schema(hidden = true)
    public void setCourseId(long id) {
        course.setID(id);
    }



    public void setCourseName(String courseName) {
        course.setCourseName(courseName);
    }

    public void setStartDate(LocalDate startDate) {
        course.setStartDate(startDate);
    }

    public void setEndDate(LocalDate endDate) {
        course.setEndDate(endDate);
    }

    public void setCapacity(int number) {
        course.setMaximumNumberOfStudents(number);
    }

    public void setCourseCode(String code) {
        course.setCourseCode(code);
    }


    public void setEFF_FRO(LocalDate date) {
         course.setEFF_FRO(date);
    }

    public void setEFF_TO(LocalDate date) {
         course.setEFF_TO(date);
    }

    public void  setNumberOfRegistration(int number){
        course.setNumberOfRegistration(number);
    }

}
