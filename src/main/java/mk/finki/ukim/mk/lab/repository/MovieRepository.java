package mk.finki.ukim.mk.lab.repository;

import lombok.Data;
import mk.finki.ukim.mk.lab.bootstrap.DataHolder;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MovieRepository {
    public List<Movie> findAll(){
        return DataHolder.movies;
    }

    private boolean isTitleAndSummaryMatch(Movie movie, String text) {
        String lowerCaseText = text.toLowerCase();
        return movie.getTitle().toLowerCase().contains(lowerCaseText)
                || movie.getSummary().toLowerCase().contains(lowerCaseText);
    }

    private boolean isRatingMatch(Movie movie, String rating) {
        double movieRating = movie.getRating();
        float requiredRating = Float.parseFloat(rating);
        return movieRating >= requiredRating;
    }

    public List<Movie> searchMovies(String text, String rating){
        List<Movie> result = new ArrayList<>();

        for (Movie movie : DataHolder.movies) {
            if ((text.isEmpty() || isTitleAndSummaryMatch(movie, text)) && (rating.isEmpty() || isRatingMatch(movie, rating))) {
                result.add(movie);
            }
        }
        return result;
    }

    public Optional<Movie> save(String movieTitle, String summary, double rating, Production production){
        Movie movie = new Movie(movieTitle,summary,rating,production);
        DataHolder.movies.removeIf(i->i.getTitle().equals(movie.getTitle()));
        DataHolder.movies.add(movie);
        return Optional.of(movie);
    }

    public Optional<Movie> findById(Long id){
        return DataHolder.movies.stream().filter(i->i.getId().equals(id)).findFirst();
    }

    public void deleteById(Long id){
        DataHolder.movies.removeIf(movie -> movie.getId().equals(id));
    }
}
