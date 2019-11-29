package com.maker.studentsApp.web;

import com.maker.studentsApp.commons.StudentException;
import com.maker.studentsApp.domain.entity.Student;
import com.maker.studentsApp.domain.resource.StudentResource;
import com.maker.studentsApp.repository.StudentRepository;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.Resources;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("api/student")
@CrossOrigin(origins =  "*", methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.PUT, RequestMethod.POST})
@Api(value = "Student Management System")
public class StudentApi {

    private StudentRepository studentRepository;

    @Autowired
    public StudentApi(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @ApiOperation(value = "Get Students available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful list of Students retrieved of the repository."),
            @ApiResponse(code = 204, message = "The resource that you were trying to retrieve no exist.")
    })
    @GetMapping
    public ResponseEntity getStudents() {

        List<StudentResource> students = studentRepository.findAll().stream()
                .map(StudentResource::new).collect(Collectors.toList());
        final Resources<StudentResource> resources = new Resources<>(students);
        final String uriString = ServletUriComponentsBuilder.fromCurrentRequest().build().toUriString();
        resources.add(new Link(uriString, "self"));
        return ResponseEntity.ok(resources);
    }


    @ApiOperation(value = "Get Employees avaible", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful registration of the employee in the repository."),
            @ApiResponse(code = 204, message = "The resource that you were trying to registry is already exist.")
    })
    @GetMapping("/{id}")
    public ResponseEntity getStudent(@PathVariable Long id) {
        return studentRepository.findById(id).map(p -> ResponseEntity.ok(new StudentResource(p))).get();
    }

    @ApiOperation(value = "Register Employees available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful registration of the employee in the repository."),
            @ApiResponse(code = 409, message = "The resource that you were trying to registry is already exist.")
    })
    @PostMapping
    public ResponseEntity registerStudent(@RequestBody Student student) {
        studentRepository.save(student);
        URI uri =MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentResource(student));
    }

    @ApiOperation(value = "Register Employees available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful registration of the employee in the repository."),
            @ApiResponse(code = 409, message = "The resource that you were trying to registry is already exist.")
    })

    @PutMapping("/{id}")
    public ResponseEntity updateStudent(@PathVariable("id") final long id, @RequestBody Student student) {
        studentRepository.save(student);
        URI uri =MvcUriComponentsBuilder.fromController(getClass()).path("/{id}").buildAndExpand(student.getId()).toUri();
        return ResponseEntity.created(uri).body(new StudentResource(student));
    }


    @ApiOperation(value = "Register Employees available", response = List.class)
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successful registration of the employee in the repository."),
            @ApiResponse(code = 409, message = "The resource that you were trying to registry is already exist.")
    })

    @DeleteMapping("/{id}")
    public ResponseEntity deleteStudent(@PathVariable("id") final long id) throws StudentException {

        return studentRepository.findById(id).map( p -> {
            studentRepository.delete(p);
            return ResponseEntity.noContent().build();
        }).orElseThrow(()-> new StudentException("Error ocurred when you try to delete the student."));
    }


}
