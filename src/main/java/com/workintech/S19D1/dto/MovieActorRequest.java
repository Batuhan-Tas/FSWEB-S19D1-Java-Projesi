package com.workintech.S19D1.dto;

import com.workintech.S19D1.entity.Actor;
import com.workintech.S19D1.entity.Movie;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MovieActorRequest {
    private Movie movie;
    private Actor actor;
}
