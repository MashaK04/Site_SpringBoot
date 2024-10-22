package com.example.lecture;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    @Autowired
    private StudentRepo repo;
    public List<Student> listAll(String keyword) {
        if (keyword != null) {
            return repo.search(keyword);
        }
        return repo.findAll();
    }
    public void save(Student student) {
        repo.save(student);
    }
    public Student findById(Integer id) {
        return repo.findById(id).get();
    }
    public void deleteById(Integer id) {
        repo.deleteById(id);
    }
}