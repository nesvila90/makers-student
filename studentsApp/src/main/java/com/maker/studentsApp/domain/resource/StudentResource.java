package com.maker.studentsApp.domain.resource;

import com.maker.studentsApp.domain.entity.Student;
import com.maker.studentsApp.web.StudentApi;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.hateoas.ResourceSupport;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;

/**
 * The type Student resource.
 */
@Data
@Slf4j
@EqualsAndHashCode(callSuper = false)
public class StudentResource extends ResourceSupport {

    private String firstname;
    private String lastname;
    private String email;

    /**
     * Instantiates a new Student resource.
     *
     * @param student the student
     */
    public StudentResource(final Student student) {

        Long id = student.getId();
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.email = student.getEmail();
        add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(StudentApi.class).getStudent(id)).withSelfRel());
        add(ControllerLinkBuilder.linkTo(ControllerLinkBuilder.methodOn(StudentApi.class).getStudent(id)).withRel("student"));


    }


}
