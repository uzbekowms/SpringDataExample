package com.example.springmvcexample.web.controller;

import com.example.springmvcexample.domain.model.Group;
import com.example.springmvcexample.domain.model.Student;
import com.example.springmvcexample.domain.repository.GroupRepository;
import com.example.springmvcexample.domain.repository.StudentRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/groups")
public class GroupController {

    private final GroupRepository repository;
    private final StudentRepository studentRepository;

    @GetMapping
    public List<Group> findAllGroups() {
        return repository.findAll();
    }

    @PostMapping
    public Group saveGroup(@RequestBody Group group) {
        return repository.save(group);
    }

    @PostMapping("/{id}")
    public Group addStudent(@RequestParam(name = "student_id") int studentId, @PathVariable int id) {
        Group group = repository.findById(id).orElseThrow(() -> new EntityNotFoundException("Doesnt exists"));
        Student student = studentRepository.findById(studentId).orElseThrow();
        group.getStudents().add(student);
        return repository.save(group);
    }
}
