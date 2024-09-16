package com.movieflix.entities;

import org.springframework.web.client.HttpClientErrorException.Forbidden;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Movies {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	int movieid;
	String movieName;
	@Column(length=2000)
	String link;
	String genres;
	String cast;
	String director;
	public Movies() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Movies(int movieid, String movieName, String link, String genres, String cast, String director) {
		super();
		this.movieid = movieid;
		this.movieName = movieName;
		this.link = link;
		this.genres = genres;
		this.cast = cast;
		this.director = director;
	}
	public int getMovieid() {
		return movieid;
	}
	public void setMovieid(int movieid) {
		this.movieid = movieid;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
	public String getGenres() {
		return genres;
	}
	public void setGenres(String genres) {
		this.genres = genres;
	}
	public String getCast() {
		return cast;
	}
	public void setCast(String cast) {
		this.cast = cast;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	@Override
	public String toString() {
		return "Movies [movieid=" + movieid + ", movieName=" + movieName + ", link=" + link + ", genres=" + genres
				+ ", cast=" + cast + ", director=" + director + "]";
	}
	


}
