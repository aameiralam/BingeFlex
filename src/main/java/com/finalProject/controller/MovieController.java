package com.finalProject.controller;

import com.finalProject.entity.Movie;
import com.finalProject.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    @PostMapping("/")
    public ResponseEntity<Movie> postNewMovie(@RequestBody Movie movie) {
        return ResponseEntity.ok(movieService.saveMovie(movie));
    }

    @GetMapping("/")
    public ResponseEntity<List<Movie>> showAllMovies () {
        return ResponseEntity.ok(movieService.showAllMovie());
    }


    @GetMapping("/{id}")
    public ResponseEntity<Movie> getMovieById(@PathVariable Long id){
        return ResponseEntity.ok(movieService.getMovieById(id));
    }


//    @PutMapping("/update")
//    public ResponseEntity<Movie> updateMovie(@RequestBody Movie movie){
//        return ResponseEntity.ok(movieService.updateMovie(movie));
//    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody Movie movie) {

        return ResponseEntity.ok(movieService.updateMovie(id, movie));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable Long id) {
        movieService.deleteMovie(id);
        return ResponseEntity.ok().body("Movie has been deleted");

    }


}
