package cinema.project.spring.dao;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import cinema.project.spring.model.MovieSession;

public interface MovieSessionDao {
    MovieSession add(MovieSession movieSession);

    Optional<MovieSession> get(Long id);

    List<MovieSession> findAvailableSessions(Long movieId, LocalDate date);

    MovieSession update(MovieSession movieSession);

    void delete(Long id);
}
