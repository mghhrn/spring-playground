package com.mghhrn.demo.service;

import com.mghhrn.demo.entity.Student;

import java.util.List;

public interface StudentService {

    List<Student> getAllStudents();

    Student randomUpdateOnStudent(Long studentId, String newFirstName) throws Exception;

    void renameAllExcept(String newFirstName, Long exptionalStudentId);
}
