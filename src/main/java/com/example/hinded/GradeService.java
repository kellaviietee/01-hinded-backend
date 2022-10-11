package com.example.hinded;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {
    private final GradeRepository gradeRepository;

    @Autowired
    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public List<Grade> getAllGrades(){
        return this.gradeRepository.findAll();
    }

    public Grade addNewGrade(Grade grade) {
        this.gradeRepository.save(grade);
        return grade;
    }
}
