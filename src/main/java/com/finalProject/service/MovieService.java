package com.finalProject.service;

import com.finalProject.entity.Movie;

import java.util.List;

public interface MovieService {

    Movie saveMovie(Movie movie);

    List<Movie> showAllMovie();

    Movie getMovieById(Long id);

    Movie updateMovie(Long id, Movie movie);

//    void deleteMovie(Movie movie);

    void deleteMovie(Long id);
}
