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
        List<Grade> allGrades = this.gradeRepository.findAll();
        allGrades.sort((g1, g2) -> Integer.compare(g2.getId(), g1.getId()));
        return allGrades;
    }

    public Grade addNewGrade(Grade grade) {
        this.gradeRepository.save(grade);
        return grade;
    }

    public GradesStatistics getGradesStatistics() {
        Integer above100 = getGradesCount("5+");
        Integer above95 = getGradesCount("5");
        Integer above90 = getGradesCount("5-");
        Integer above85 = getGradesCount("4+");
        Integer above80 = getGradesCount("4");
        Integer above75 = getGradesCount("4-");
        Integer above70 = getGradesCount("3+");
        Integer above60 = getGradesCount("3");
        Integer above50 = getGradesCount("3-");
        Integer above40 = getGradesCount("2+");
        Integer above30 = getGradesCount("2");
        Integer above20 = getGradesCount("2-");
        Integer above00 = getGradesCount("1");
        return new GradesStatistics(above100,above95,above90,above85,above80,above75,above70,above60,
                                                                above50,above40,above30,above20,above00);
    }

    private Integer getGradesCount(String gradeValue) {
        Integer counter = 0;
        List<Grade> allGrades = getAllGrades();
        for (Grade grade : allGrades) {
            if(grade.getGrade().equals(gradeValue)) {
                counter++;
            }
        }
        return  counter;
    }

    public GradesStatistics clearDatabase() {
        this.gradeRepository.deleteAll();
        return new GradesStatistics(0,0,0,0,0,0,0,0,0,0,0,0,0);
    }
}
