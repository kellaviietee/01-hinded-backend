package com.example.hinded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class GradeController {
    private final GradeService gradeService;

    @Autowired
    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }
    @GetMapping(path = "/all")
    public List<Grade> getAllGrades() {
        return this.gradeService.getAllGrades();
    }
    @PostMapping(path = "/add")
    public Grade addGrade(@RequestBody Grade grade) {
        return this.gradeService.addNewGrade(grade);
    }
}
