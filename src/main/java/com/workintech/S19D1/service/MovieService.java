package com.workintech.S19D1.service;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();
    Movie findById(int id);
    Movie save(Movie movie);
    void delete(int id);
}
