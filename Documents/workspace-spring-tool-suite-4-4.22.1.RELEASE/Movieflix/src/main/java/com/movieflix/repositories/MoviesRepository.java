package com.movieflix.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.movieflix.entities.Movies;

public interface MoviesRepository extends JpaRepository<Movies, Integer>{

}
