package com.maker.studentsApp.domain.resource;

import com.maker.studentsApp.domain.entity.Student;
import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

import java.util.List;

@Data
public class StudentsResponse extends ResourceSupport {

    private List<Student> students;



    public StudentsResponse(List<Student> students) {
        this.students = students;
    }
}
