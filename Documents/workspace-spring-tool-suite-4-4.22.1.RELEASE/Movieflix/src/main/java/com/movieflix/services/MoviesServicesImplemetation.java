package com.movieflix.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movieflix.entities.Movies;
import com.movieflix.repositories.MoviesRepository;

@Service
public class MoviesServicesImplemetation implements MoviesServices
{
	@Autowired
	MoviesRepository morep;

	@Override
	public void addMovies(Movies movie) {
       morep.save(movie);
			}

	@Override
	public List<Movies> viewMovies() {
		List<Movies> movieslist=morep.findAll();
		return movieslist;
	}

	@Override
	public void updateMovie(Movies movie) {
		morep.save(movie);
	}

	@Override
	public void deleteMovie(Integer movieid) {
		morep.deleteById(movieid);	
	}

}
