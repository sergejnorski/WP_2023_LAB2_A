package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movies = null;

    @PostConstruct
    public void init(){
        movies = new ArrayList<>();
        movies.add(new Movie("Title 1","Summary 1",1.0));
        movies.add(new Movie("Title 2","Summary 2",2.0));
        movies.add(new Movie("Title 3","Summary 3",3.0));
        movies.add(new Movie("Title 4","Summary 4",4.0));
        movies.add(new Movie("Title 5","Summary 5",5.0));
        movies.add(new Movie("Title 6","Summary 6",6.0));
        movies.add(new Movie("Title 7","Summary 7",7.0));
        movies.add(new Movie("Title 8","Summary 8",8.0));
        movies.add(new Movie("Title 9","Summary 9",9.0));
        movies.add(new Movie("Title 10","Summary 10",10.0));
    }

}
