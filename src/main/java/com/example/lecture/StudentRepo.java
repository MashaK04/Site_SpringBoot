package com.example.lecture;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface StudentRepo extends JpaRepository<Student, Integer> {
    @Query("SELECT p FROM Student p WHERE CONCAT(p.ID, p.firstName, p.lastName, p.av, p.city) LIKE %?1%")
    public List<Student> search(String keyword);
}
