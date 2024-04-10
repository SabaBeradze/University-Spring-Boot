package dev.boot.service;


import dev.boot.domain.Student;
import dev.boot.dto.StudentDTO;
import dev.boot.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public StudentDTO save(StudentDTO entity) {
        return new StudentDTO(studentRepository.save(entity.toStudent()));
    }

    public StudentDTO update(long id, StudentDTO studentDTO) {
        Optional<StudentDTO> existingStudent = findById(id);

        if (existingStudent.isPresent()) {
            Student existingEntity = existingStudent.get().toStudent();
            existingEntity.setFirstName(studentDTO.getFirstName());
            existingEntity.setLastName(studentDTO.getLastName());
            existingEntity.setBirthday(studentDTO.getBirthDay());
            existingEntity.setEmail(studentDTO.getEmail());

            return new StudentDTO(studentRepository.save(existingEntity));
        }

        studentDTO.setId(id);
        return save(studentDTO);
    }

    public Iterable<StudentDTO> findAll() {
        return StreamSupport.stream(studentRepository.findAll().spliterator(), false)
                .map(StudentDTO::new)
                .collect(Collectors.toSet());
    }


    public Optional<StudentDTO> findById(long Id) {
        return studentRepository.findById(Id).map(StudentDTO::new);
    }

    public void delete(StudentDTO courseDTO) {
        studentRepository.delete(courseDTO.toStudent());
    }
}
