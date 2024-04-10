package dev.boot.controller;

import dev.boot.dto.StudentDTO;
import dev.boot.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> save(@RequestBody StudentDTO studentDTO) {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(studentService.save(studentDTO));
    }

    @PutMapping("/{id}")
    public StudentDTO upDate(@PathVariable(name = "id") long Id ,@RequestBody StudentDTO entity) {
        return studentService.update(Id,entity);
    }

    @GetMapping
    public Iterable<StudentDTO> findAll() {
        return studentService.findAll();
    }


    @GetMapping("/{id}")
    public Optional<StudentDTO> findById(@PathVariable(name = "id") long Id) {
        return studentService.findById(Id);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable(name = "id")long Id) {
        findById(Id).ifPresent(studentService::delete);
    }
}