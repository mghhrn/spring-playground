package com.mghhrn.demo.service;

import com.mghhrn.demo.dao.StudentRepository;
import com.mghhrn.demo.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository;

    public StudentServiceImpl(StudentRepository repository) {
        this.repository = repository;
    }



    @Override
    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    @Override
    public Student randomUpdateOnStudent(Long studentId) {
        
    }
}
