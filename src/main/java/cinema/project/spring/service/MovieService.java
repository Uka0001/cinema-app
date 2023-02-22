package cinema.project.spring.service;

import java.util.List;
import cinema.project.spring.model.Movie;

public interface MovieService {
    Movie add(Movie movie);

    Movie get(Long id);

    List<Movie> getAll();
}
