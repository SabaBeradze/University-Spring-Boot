package dev.boot.controller;

import dev.boot.dto.CourseRegistrationDTO;
import dev.boot.service.CourseRegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping("/registrations")
public class CourseRegistrationController {
    private final CourseRegistrationService courseRegistrationService;

    public CourseRegistrationController(CourseRegistrationService courseRegistrationService) {
        this.courseRegistrationService = courseRegistrationService;

    }

    @PostMapping
    public ResponseEntity<CourseRegistrationDTO> save(long studentId, long courseId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(courseRegistrationService.save(studentId, courseId));
    }

    @PostMapping("/{student_id}/{course_id}/{grade}")
    public Optional<CourseRegistrationDTO> assignGrade(@PathVariable(name = "student_id") long student_id,@PathVariable(name = "course_id") long course_id, @PathVariable(name = "grade") int grade) {
        return courseRegistrationService.assignGrade(student_id,course_id, grade);
    }

    @GetMapping("/{id}")
    public Optional<CourseRegistrationDTO> findById(@PathVariable(name = "id") long Id) {
        return courseRegistrationService.findById(Id);
    }

    @GetMapping
    public Iterable<CourseRegistrationDTO> findAll() {
        return courseRegistrationService.findAll();
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(name = "id") long Id) {
        findById(Id).ifPresent(courseRegistrationService::delete);
    }

    @DeleteMapping("delete/{student_id}/{course_id}")
    public void delete(@PathVariable(name = "student_id") long student_id, @PathVariable(name = "course_id") long course_id) {
        StreamSupport.stream(findAll().spliterator(), false).
                forEach(el -> {
                    if (el.getCourse().getID() == course_id && el.getStudent().getId() == student_id) {
                        courseRegistrationService.delete(el);
                    }
                });

    }







}
