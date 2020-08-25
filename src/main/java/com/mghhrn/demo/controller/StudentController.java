package com.mghhrn.demo.controller;

import com.mghhrn.demo.service.StudentService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/student")
public class StudentController {

    private final StudentService studentService;

    private final Logger logger = LogManager.getLogger(StudentController.class);

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @Transactional
    @GetMapping
    public String getAllStudents() {
        logger.info("All student controller has been called!");
        return studentService.getAllStudents().toString();
    }
}
