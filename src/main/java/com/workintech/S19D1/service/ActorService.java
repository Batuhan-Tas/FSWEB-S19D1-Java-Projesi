package com.workintech.S19D1.service;

import com.workintech.S19D1.entity.Actor;

import java.util.List;

public interface ActorService {
    List<Actor> findAll();
    Actor findById(int id);
    Actor save(Actor actor);
    void delete(int id);
}
