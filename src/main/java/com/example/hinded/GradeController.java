package com.example.hinded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
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
        Grade addedGrade = new Grade(grade.getPoints(), grade.getMaximum());
        return this.gradeService.addNewGrade(addedGrade);
    }
    @GetMapping(path = "/stats")
    public GradesStatistics getGradeStatistics(){
        return gradeService.getGradesStatistics();
    }
    @GetMapping(path = "/clear")
    public GradesStatistics clearDatabase() {
        return gradeService.clearDatabase();
    }
}
