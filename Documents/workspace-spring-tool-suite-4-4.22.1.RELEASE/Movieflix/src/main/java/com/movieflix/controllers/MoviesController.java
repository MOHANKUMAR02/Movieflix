package com.movieflix.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.movieflix.entities.Movies;
import com.movieflix.services.MoviesServices;
import com.movieflix.services.UserService;

@Controller
public class MoviesController {

	@Autowired
	MoviesServices moserv;
	

	public MoviesController(MoviesServices moserv) {
		super();
		this.moserv = moserv;
	}

	@PostMapping("map-addMovies")
	public String addmovies(@ModelAttribute Movies movie) {
		moserv.addMovies(movie);
		return "movieaddsuccess";

	}

	@GetMapping("viewmovies")
	public String viewMoviesList(Model model) {
		List<Movies> moviesList=moserv.viewMovies();
		model.addAttribute("viewAllMovies", moviesList);
		return "viewmovies";

	}

	@GetMapping("viewUserMovies")
	public String viewMoviesUserList(Model model) {
		List<Movies> moviesList=moserv.viewMovies();
		model.addAttribute("viewAllMovies", moviesList);
		return "viewusermovies";

	}

	@PostMapping("map-UpdateMovies")
	public String updateMovie(@ModelAttribute Movies movie )
	{
		moserv.updateMovie(movie);
		return "updatemoviesuccess";
	}

	@PostMapping("map_deleteMovies")
	public String deletemovies(Integer movieid)
	{
		moserv.deleteMovie(movieid);
		return "deletemoviesuccessful";
	}


}
