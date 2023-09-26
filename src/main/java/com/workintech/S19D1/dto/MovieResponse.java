package com.workintech.S19D1.dto;

import jdk.jfr.DataAmount;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MovieResponse {
    private int movieId;
    private String name;
    private String directorName;
    private int rating;
    private LocalDate releaseDate;

}
