package com.finalProject.repository;

import com.finalProject.entity.Movie;
import org.springframework.data.repository.ListCrudRepository;

public interface MovieRepository extends ListCrudRepository<Movie, Long> {
}
