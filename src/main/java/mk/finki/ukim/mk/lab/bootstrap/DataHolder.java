package mk.finki.ukim.mk.lab.bootstrap;

import jakarta.annotation.PostConstruct;
import mk.finki.ukim.mk.lab.model.Movie;
import mk.finki.ukim.mk.lab.model.Production;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DataHolder {
    public static List<Movie> movies = null;
    public static List<Production> productions = null;

    @PostConstruct
    public void init(){
        productions = new ArrayList<>();
        productions.add(new Production("Production 1","Macedonia","Address 1"));
        productions.add(new Production("Production 2","Serbia","Address 2"));
        productions.add(new Production("Production 3","Bosnia","Address 3"));
        productions.add(new Production("Production 4","Croatia","Address 4"));
        productions.add(new Production("Production 5","USA","Address 5"));

        movies = new ArrayList<>();
        movies.add(new Movie("Title 1","Summary 1",1.0,productions.get(0)));
        movies.add(new Movie("Title 2","Summary 2",2.0,productions.get(1)));
        movies.add(new Movie("Title 3","Summary 3",3.0,productions.get(2)));
        movies.add(new Movie("Title 4","Summary 4",4.0,productions.get(3)));
        movies.add(new Movie("Title 5","Summary 5",5.0,productions.get(4)));
        movies.add(new Movie("Title 6","Summary 6",6.0,productions.get(4)));
        movies.add(new Movie("Title 7","Summary 7",7.0,productions.get(0)));
        movies.add(new Movie("Title 8","Summary 8",8.0,productions.get(1)));
        movies.add(new Movie("Title 9","Summary 9",9.0,productions.get(2)));
        movies.add(new Movie("Title 10","Summary 10",10.0,productions.get(3)));

    }

}
