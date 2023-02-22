package cinema.project.spring.dao;

import java.util.List;
import java.util.Optional;

import cinema.project.spring.model.CinemaHall;

public interface CinemaHallDao {
    CinemaHall add(CinemaHall cinemaHall);

    Optional<CinemaHall> get(Long id);

    List<CinemaHall> getAll();
}
