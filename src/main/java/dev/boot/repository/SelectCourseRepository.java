package dev.boot.repository;


import dev.boot.domain.Student;
import dev.boot.domain.CourseRegistration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.Collection;

public interface SelectCourseRepository extends CrudRepository<CourseRegistration,Long> {

    @Query("from  CourseRegistration where  grade =: point")
    Collection<Student> findAllStudentsByGrade(@Param("point") int point);
    Collection<Student> findAllByCourseId(@Param("CourseId") int Id);

}

