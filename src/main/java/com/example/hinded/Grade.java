package com.example.hinded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.*;

@Data
@Entity
@Table(name = "Grades")
@NoArgsConstructor
public class Grade {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "points")
    private Integer points;
    @Column(name = "maximum")
    private Integer maximum;
    @Column(name = "percentage")
    private Integer percentage;
    @Column(name = "grade")
    private String grade;
    @Autowired
    public Grade(Integer points, Integer maximum){
        this.points = points;
        this.maximum = maximum;
        this.percentage = calculatePercentage(points,maximum);
        this.grade = calculateGrade();
    }

    private String calculateGrade() {
        if(this.percentage >= 95) {
            return "5+";
        } else if (this.percentage >= 90) {
            return "5";
        } else if (this.percentage >= 85) {
            return "4+";
        } else if (this.percentage >= 75) {
            return "4";
        } else if (this.percentage >= 70) {
            return "4";
        } else if (this.percentage >= 65) {
            return "3+";
        } else if (this.percentage >= 55) {
            return "3";
        } else if (this.percentage >= 50) {
            return "3";
        } else if (this.percentage >= 40) {
            return "2+";
        } else if (this.percentage >= 30) {
            return "2";
        } else if (this.percentage >= 20) {
            return "2-";
        } else return "1";
    }

    private Integer calculatePercentage(Integer points, Integer maximum) {
        float notRounded = (float) points / maximum * 100;
        return Math.round(notRounded);
    }
}
