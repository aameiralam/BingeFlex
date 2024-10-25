//package com.finalProject;
//
//import com.finalProject.entity.Customer;
//import com.finalProject.entity.Movie;
//import com.finalProject.repository.CustomerRepository;
//import com.finalProject.repository.MovieRepository;
//import com.finalProject.service.CustomerServiceImpl;
//import com.finalProject.service.MovieService;
//import com.finalProject.service.MovieServiceImp;
//import jakarta.persistence.EntityNotFoundException;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.Mockito;
//import org.mockito.MockitoAnnotations;
//
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.Mockito.verify;
//
//public class FinalProjectTest {
//
//    @InjectMocks
//    private MovieServiceImp movieService;
//    @Mock
//    private MovieRepository movieRepository;
//
//    private AutoCloseable autoCloseable;
//
//    @BeforeEach
//    void setup(){
//        autoCloseable = MockitoAnnotations.openMocks(this);
//    }
//
//    @AfterEach
//    void takeDown() throws Exception {
//        autoCloseable.close();
//    }
//
//    @Test
//    public void MovieServiceImpl_updateMovie_Success(){
//        Movie movie = Movie.builder()
//                .Id(1L)
//                .title("Iron Man")
//                .genre("Action")
//                .rating(8)
//                .description("SuperHero Marvel Movie")
//                .releaseYear(2008)
//                .image("")
//                .trailerLink("")
//                .build();
//        Mockito.when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
//        Mockito.when(movieRepository.save(movie)).thenReturn(movie); //saves it after updating
//
//        Movie movie1 = movieService.updateMovie(movie.getId(), movie);
//
//        assertThat(movie1).isEqualTo(movie);
//        assertEquals(movie,movie1);
//
//    }
//
//    @Test
//
//    public void MovieServiceImp_updateMovie_MissingIdThrowsException() {
//
//        Movie movie = Movie.builder()
//                .title("Iron Man")
//                .genre("Action")
//                .rating(8)
//                .description("SuperHero Marvel Movie")
//                .releaseYear(2008)
//                .image("")
//                .trailerLink("")
//                .build();
//
//        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.updateMovie(movie.getId(), movie));
//        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
//        assertThat(throwable.getMessage()).isEqualTo("Movie ID not found");
//    }
//    @ParameterizedTest
//    @ValueSource (longs = {-30l, 1000l, 0l})
//
//    public void MovieServiceImp_updateMovie_InvalidIdThrowException(long id){
//                Movie movie = Movie.builder()
//                        .Id(id)
//                .title("Iron Man")
//                .genre("Action")
//                .rating(8)
//                .description("SuperHero Marvel Movie")
//                .releaseYear(2008)
//                        .image("")
//                        .trailerLink("")
//                .build();
//
//                Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.updateMovie(movie.getId(), movie));
//
//                assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
//                assertThat(throwable.getMessage()).isEqualTo("Invalid Movie ID");
//    }
//
//    @Test
//    public void MovieServiceImp_UpdateMovie_validationOfChange() {
//        Movie oldMovie = Movie.builder()
//                .Id(1L)
//                .title("Iron Man")
//                .genre("Action")
//                .rating(8)
//                .description("SuperHero Marvel Movie")
//                .releaseYear(2008)
//                .image("")
//                .trailerLink("")
//                .build();
//        Movie newMovie = Movie.builder()
//                .Id(2L)
//                .title("SpiderMan")
//                .genre("Action")
//                .rating(9)
//                .description("SuperHero Sony and Marvel Movie")
//                .releaseYear(2005)
//                .image("")
//                .trailerLink("")
//                .build();
//
//        Mockito.when(movieRepository.findById(newMovie.getId())).thenReturn(Optional.of(oldMovie));
//        Mockito.when(movieRepository.save(newMovie)).thenReturn(newMovie);
//
//        Movie result = movieService.updateMovie(newMovie.getId(), newMovie);
//        assertNotEquals(oldMovie, result);
//        assertEquals(newMovie, result);
//    }
//
//    @Test
//    public void MovieServiceImp_DeleteMovie_Success(){
//
//        Long id = 1L;
//
//        Mockito.when(movieRepository.existsById(id)).thenReturn(true);
//        movieService.deleteMovie(id);
//        verify(movieRepository).deleteById(id);
//    }
//
//    @ParameterizedTest
//    @ValueSource(longs = {-15l, 0l, 500l})
//    public void  monsterServiceImp_deleteMonster_invalidIdThrowsException(long id){
//        Mockito.when(movieRepository.existsById(id)).thenReturn(false);
//        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.deleteMovie(id));
//        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
//        assertThat(throwable.getMessage()).isEqualTo("Monster with ID" + id
//                + "has not been found");
//    }
//
//
////    -------------------------------------------------------------------------------------------------------------------
//
//
//
//    }
//
package com.finalProject;

import com.finalProject.entity.Movie;
import com.finalProject.repository.MovieRepository;
import com.finalProject.service.MovieServiceImp;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class FinalProjectTest {

    @InjectMocks
    private MovieServiceImp movieService;
    @Mock
    private MovieRepository movieRepository;

    private AutoCloseable autoCloseable;

    @BeforeEach
    void setup(){
        autoCloseable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void takeDown() throws Exception {
        autoCloseable.close();
    }

    @Test
    public void MovieServiceImpl_updateMovie_Success(){
        Movie movie = Movie.builder()
                .Id(1L)
                .title("Iron Man")
                .genre("Action")
                .rating(8)
                .description("SuperHero Marvel Movie")
                .releaseYear(2008)
                .image("")
                .trailerLink("")
                .build();
        Mockito.when(movieRepository.findById(movie.getId())).thenReturn(Optional.of(movie));
        Mockito.when(movieRepository.save(movie)).thenReturn(movie); //saves it after updating

        Movie movie1 = movieService.updateMovie(movie.getId(), movie);

        assertThat(movie1).isEqualTo(movie);
        assertEquals(movie,movie1);

    }

    @Test
    public void MovieServiceImp_updateMovie_MissingIdThrowsException() {
        Movie movie = Movie.builder()
                .title("Iron Man")
                .genre("Action")
                .rating(8)
                .description("SuperHero Marvel Movie")
                .releaseYear(2008)
                .image("")
                .trailerLink("")
                .build();

        Mockito.when(movieRepository.findById(movie.getId())).thenReturn(Optional.empty());

        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.updateMovie(movie.getId(), movie));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Invalid Movie ID");
    }

    @ParameterizedTest
    @ValueSource (longs = {-30L, 1000L, 0L})
    public void MovieServiceImp_updateMovie_InvalidIdThrowException(long id){
        Movie movie = Movie.builder()
                .Id(id)
                .title("Iron Man")
                .genre("Action")
                .rating(8)
                .description("SuperHero Marvel Movie")
                .releaseYear(2008)
                .image("")
                .trailerLink("")
                .build();

        Mockito.when(movieRepository.findById(id)).thenReturn(Optional.empty());

        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.updateMovie(movie.getId(), movie));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Invalid Movie ID");
    }

    @Test
    public void MovieServiceImpl_UpdateMovie_validationOfChange() {
        Movie oldMovie = Movie.builder()
                .Id(1L)
                .title("Iron Man")
                .genre("Action")
                .rating(8)
                .description("SuperHero Marvel Movie")
                .releaseYear(2008)
                .image("")
                .trailerLink("")
                .build();
        Movie newMovie = Movie.builder()
                .Id(1L) // Updated to use the same ID
                .title("SpiderMan")
                .genre("Action")
                .rating(9)
                .description("SuperHero Sony and Marvel Movie")
                .releaseYear(2005)
                .image("")
                .trailerLink("")
                .build();

        Mockito.when(movieRepository.findById(newMovie.getId())).thenReturn(Optional.of(oldMovie));
        Mockito.when(movieRepository.save(newMovie)).thenReturn(newMovie);

        Movie result = movieService.updateMovie(newMovie.getId(), newMovie);
        assertNotEquals(oldMovie, result);
        assertEquals(newMovie, result);
    }

    @Test
    public void MovieServiceImp_DeleteMovie_Success(){
        Long id = 1L;

        Mockito.when(movieRepository.existsById(id)).thenReturn(true);
        movieService.deleteMovie(id);
        verify(movieRepository).deleteById(id);
    }

    @ParameterizedTest
    @ValueSource(longs = {-15L, 0L, 500L})
    public void MovieServiceImp_deleteMovie_invalidIdThrowsException(long id){
        Mockito.when(movieRepository.existsById(id)).thenReturn(false);
        Throwable throwable = assertThrows(EntityNotFoundException.class, () -> movieService.deleteMovie(id));
        assertThat(throwable).isInstanceOf(EntityNotFoundException.class);
        assertThat(throwable.getMessage()).isEqualTo("Movie with ID " + id + " has not been found");
    }
}
