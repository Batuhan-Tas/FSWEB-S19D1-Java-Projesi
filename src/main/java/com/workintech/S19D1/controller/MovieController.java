package com.workintech.S19D1.controller;

import com.workintech.S19D1.dto.MovieActorRequest;
import com.workintech.S19D1.dto.MovieActorResponse;
import com.workintech.S19D1.dto.MovieResponse;
import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import com.workintech.S19D1.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/")
    public List<MovieResponse> findAll(){
        List<MovieResponse> movieResponses = new ArrayList<>();
        List<Movie> movies = movieService.findAll();
        for(Movie movie: movies){
            movieResponses.add(new MovieResponse(movie.getId(),movie.getName(),movie.getDirectorName(),movie.getRating(),movie.getReleaseDate()));
        }
        return movieResponses;

    }

    @GetMapping("/{id}")
    public Movie findById(@PathVariable int id){
        return movieService.findById(id);
    }

    @PostMapping("/")
    public MovieActorResponse save(@RequestBody MovieActorRequest movieActorRequest){
        Movie movie = movieActorRequest.getMovie();
        Actor actor = movieActorRequest.getActor();
        movie.addActor(actor);
        Movie savedMovie = movieService.save(movie);
        return new MovieActorResponse(movie, actor.getId(), actor.getFirstName(), actor.getLastName(), actor.getBirthDate());
    }

    @PutMapping("/{id}")
    public MovieResponse update(@RequestBody Movie movie,@PathVariable int id){
        Movie foundMovie = movieService.findById(id);
        if(foundMovie != null){
            movie.setId(id);
            movie.setActors(foundMovie.getActors());
            Movie updatedMovie = movieService.save(movie);
            return new MovieResponse(movie.getId(),movie.getName(),movie.getDirectorName(),movie.getRating(),movie.getReleaseDate());
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable int id){
        movieService.delete(id);
    }
}
