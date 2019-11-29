package com.maker.studentsApp.repository;

import com.maker.studentsApp.domain.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * The interface Student repository.
 */
@RepositoryRestResource(path = "students", collectionResourceRel = "students", itemResourceRel = "student")
public interface StudentRepository extends JpaRepository<Student, Long> {
}
