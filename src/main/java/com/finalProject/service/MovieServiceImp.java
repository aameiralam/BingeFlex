package com.finalProject.service;

import com.finalProject.entity.Movie;
import com.finalProject.repository.MovieRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class MovieServiceImp implements MovieService {

    @Autowired
    private MovieRepository movieRepository;


    @Autowired
    public MovieServiceImp(MovieRepository movieRepository){
        this.movieRepository=movieRepository;
    }


    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepository.save(movie);
    }

    @Override
    public List<Movie> showAllMovie() {
        return movieRepository.findAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepository.findById(id).orElseThrow(() ->
                new EntityNotFoundException("Movie with ID :" + id + "has not been found" ));
    }

//    @Override
//    public Movie updateMovie(Long id) {
//        Movie oldMovieData = movieRepository.findById(movie.getId()).orElseThrow(()->
//                new EntityNotFoundException("Given Movie ID not found"));
//        return movieRepository.save(movie);
//    }

    @Override
    public Movie updateMovie(Long id, Movie movie) {
    Movie oldMovieData = movieRepository.findById(id).orElseThrow(() ->
            new EntityNotFoundException("Invalid Movie ID"));

      return movieRepository.save(movie);
}




    @Override
    public void deleteMovie(Long id) {
            if(!movieRepository.existsById(id)) throw new EntityNotFoundException("Movie with ID " + id + " has not been found"); //if exception thrown it goes to the next line
            movieRepository.deleteById(id);
        }
    }

//    @Override
//    public void deleteMovie(Movie movie) {
//        Movie oldMovieData = movieRepository.findById(movie.getId()).orElseThrow(()->
//                new EntityNotFoundException("Given Movie ID not found"));
//        movieRepository.delete(movie);
//    }



