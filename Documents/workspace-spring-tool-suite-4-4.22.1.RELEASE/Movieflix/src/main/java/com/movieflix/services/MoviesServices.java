package com.movieflix.services;

import java.util.List;

import com.movieflix.entities.Movies;

public interface MoviesServices {

	public void addMovies(Movies movie);
	public List<Movies> viewMovies();
	public void updateMovie(Movies movie );
	public void deleteMovie(Integer movieid );
	
}
