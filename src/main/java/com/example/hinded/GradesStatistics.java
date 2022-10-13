package com.example.hinded;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class GradesStatistics {

    private Integer above100;
    private Integer above95;
    private Integer above90;
    private Integer above85;
    private Integer above80;
    private Integer above75;
    private Integer above70;
    private Integer above60;
    private Integer above50;
    private Integer above40;
    private Integer above30;
    private Integer above20;
    private Integer above00;
}
