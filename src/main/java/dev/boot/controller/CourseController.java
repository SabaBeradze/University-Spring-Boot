package dev.boot.controller;

import dev.boot.dto.CourseDTO;
import dev.boot.service.CourseService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/courses")
public class CourseController {
    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @PostMapping
    public ResponseEntity<CourseDTO> save(@RequestBody  CourseDTO clientDTO) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(courseService.save(clientDTO));
    }


    @GetMapping
    public Iterable<CourseDTO> findAll() {
        return courseService.findAll();
    }

    @PutMapping("/{id}")
    public CourseDTO upDate(@PathVariable(name = "id") long Id , @RequestBody CourseDTO entity) {
        return courseService.upDate(Id,entity);
    }


    @GetMapping("/{id}")
    public Optional<CourseDTO> findById( @PathVariable long id) {
        return courseService.findById(id);
    }

    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable long id) {
        findById(id).ifPresent(courseService::delete);

    }

}
