package cinema.project.spring.dao.impl;

import cinema.project.spring.dao.AbstractDao;
import cinema.project.spring.dao.MovieDao;
import cinema.project.spring.model.Movie;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDaoImpl extends AbstractDao<Movie> implements MovieDao {
    public MovieDaoImpl(SessionFactory factory) {
        super(factory, Movie.class);
    }
}
