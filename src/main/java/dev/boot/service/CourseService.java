package dev.boot.service;

import dev.boot.domain.Course;
import dev.boot.dto.CourseDTO;
import dev.boot.repository.CourseRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class CourseService {
    private final CourseRepository courseRepo;

    public CourseService(CourseRepository courseRepo) {
        this.courseRepo = courseRepo;
    }

    public CourseDTO save(CourseDTO entity) {
        return new CourseDTO(courseRepo.save(entity.toCourse()));
    }

    public CourseDTO upDate(long id, CourseDTO courseDTO) {
        Optional<CourseDTO> element = findById(id);

        if (element.isPresent()) {
            Course entity= element.get().toCourse();
            entity.setID(courseDTO.getCourseId());
            entity.setEndDate(courseDTO.getEndDate());
            entity.setStartDate(courseDTO.getStartDate());
            entity.setCourseName(courseDTO.getCourseName());

            return new CourseDTO(courseRepo.save(entity));
        }

        return save(courseDTO);
    }
    public Iterable<CourseDTO> findAll() {
        return StreamSupport.stream(courseRepo.findAll().spliterator(), false)
                .map(CourseDTO::new)
                .collect(Collectors.toSet());
    }


    public Optional<CourseDTO> findById(long Id) {
        return courseRepo.findById(Id).map(CourseDTO::new);
    }
    public void delete(CourseDTO courseDTO) {
        courseRepo.delete(courseDTO.toCourse());
    }
}
