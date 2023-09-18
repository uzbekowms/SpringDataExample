package com.example.springmvcexample.domain.repository;

import com.example.springmvcexample.domain.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    Student findAllByEmailEquals(String email);

    boolean existsByEmail(String email);

    @Query("select s from Student s where s.fullName = :fullName")
    Student findTop(@Param("fullName") String name);

    @Modifying
    @Query("update Student s set s.fullName = :name")
    Student updateName(String name);
}
