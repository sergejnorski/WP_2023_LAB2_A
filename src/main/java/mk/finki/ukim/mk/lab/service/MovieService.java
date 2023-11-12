package mk.finki.ukim.mk.lab.service;

import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<Movie> listAll();
    List<Movie> searchMovies(String text, String rating);
    Optional<Movie> save(String movieTitle, String summary, double rating, Long productionId);
    Optional<Movie> findById(Long id);
    void deleteById(Long id);
}