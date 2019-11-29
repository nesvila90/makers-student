package com.maker.studentsApp.domain.entity;

import com.maker.studentsApp.domain.entity.base.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class Student extends BaseEntity {

    private String firstname;
    private String lastname;
    private String email;

    public Student(final Student student) {
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.email = student.getEmail();
    }

    public Student(final Student student, final long id) {
        setId(id);
        this.firstname = student.getFirstname();
        this.lastname = student.getLastname();
        this.email = student.getEmail();
    }
}
