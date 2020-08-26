package com.mghhrn.demo.service;

import com.mghhrn.demo.dao.StudentRepository;
import com.mghhrn.demo.entity.Student;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

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

    @Transactional
    @Override
    public Student randomUpdateOnStudent(Long studentId, String newFirstName) throws Exception {
        Optional<Student> studentOptional = repository.findById(studentId);
        Student student = studentOptional.orElseThrow(() -> new IllegalArgumentException("can not find the student"));
        renameAllExcept(newFirstName, studentId);
        student.setFirstName(newFirstName);
        repository.save(student);
//        Random random = new Random();
//        if (random.nextInt(10) % 2 == 0) {
//            throw new RuntimeException("Random exception happened in Service!");
//        }
        return student;
    }

    @Transactional
    @Override
    public void renameAllExcept(String newFirstName, Long exceptionalStudentId) {
        List<Student> studentList = repository.findAll()
                .stream()
                .filter(s -> !s.getId().equals(exceptionalStudentId))
                .map(s -> {
                    s.setFirstName(newFirstName);
                    return s;
                })
                .collect(Collectors.toList());
        repository.saveAll(studentList);
    }
}
