package dev.boot.service;

import dev.boot.domain.Student;
import dev.boot.dto.CourseRegistrationDTO;
import dev.boot.repository.CourseRepository;
import dev.boot.repository.SelectCourseRepository;
import dev.boot.repository.StudentRepository;
import dev.boot.domain.Course;
import dev.boot.domain.CourseRegistration;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseRegistrationService {
    private final SelectCourseRepository repository;
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;


    public CourseRegistrationService(SelectCourseRepository repository, StudentRepository studentRepository, CourseRepository courseRepository) {
        this.repository = repository;
        this.studentRepository = studentRepository;
        this.courseRepository = courseRepository;

    }

    public CourseRegistrationDTO save(long studentId, long courseId) {

        Student student = studentRepository.findById(studentId).orElseThrow(() -> new EntityNotFoundException("Student not found"));
        Course course = courseRepository.findById(courseId).orElseThrow(() -> new EntityNotFoundException("Course not found"));


        return new CourseRegistrationDTO(repository.save(canRegister(student, course)));
    }

    public Optional<CourseRegistrationDTO> findById(Long aLong) {
        return repository.findById(aLong).map(CourseRegistrationDTO::new);
    }

    public Iterable<CourseRegistrationDTO> findAll() {
        return StreamSupport.stream(repository.findAll().spliterator(), false)
                .map(CourseRegistrationDTO::new)
                .collect(Collectors.toSet());
    }

    public Optional<CourseRegistrationDTO> assignGrade(long student_id, long course_id, int grade) {
        var record = StreamSupport.stream(findAll().spliterator(), false).filter(el -> el.getStudent().getId() == student_id && el.getCourseId() == course_id).findFirst();
        record.ifPresent(courseRegistrationDTO -> courseRegistrationDTO.setGrade(grade));


        return record;
    }

    public void delete(CourseRegistrationDTO entity) {
        repository.delete(entity.toCourseRegistration());
    }

    private CourseRegistration canRegister(Student student, Course course) {
        try {

            long number = StreamSupport.stream(findAll().spliterator(), false).
                    filter(el -> (el.getCourse().getCourseCode().equals(course.getCourseCode()) && el.getStudent().equals(student))
                    ).count();

            if (number < course.getNumberOfRegistration()) {
                CourseRegistration courseRegistration = new CourseRegistration();
                courseRegistration.setStudent(student);
                courseRegistration.setCourse(course);
                courseRegistration.setNumberOfRegistration((int) number + 1);
                courseRegistration.setRegistrationDate(LocalDate.now());
                return courseRegistration;

            }
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "bed parammeters", e);
        }
        return null;
    }


}
