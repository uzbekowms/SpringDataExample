package com.example.springmvcexample.web.controller;

import com.example.springmvcexample.domain.model.Group;
import com.example.springmvcexample.domain.model.Student;
import com.example.springmvcexample.domain.repository.GroupRepository;
import com.example.springmvcexample.domain.repository.StudentRepository;
import com.example.springmvcexample.domain.service.StudentService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService service;
    private final StudentRepository repository;
    private final GroupRepository groupRepository;

    @GetMapping
    public List<Student> findAllStudents() {
        return service.findAll();
    }

    @GetMapping("/{id}")
    public Student findStudent(@PathVariable int id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Not found student with id - " + id));
    }

    @PostMapping
    public Student saveStudent(@RequestBody Student student, @RequestParam(name = "group_id") int id) {
        Group group = groupRepository.findById(id).orElseThrow();
        student.setGroup(group);
        return service.save(student);
    }
}
