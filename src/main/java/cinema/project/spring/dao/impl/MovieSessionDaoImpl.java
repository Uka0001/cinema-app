package cinema.project.spring.dao.impl;

import java.time.LocalDate;
import java.util.List;

import cinema.project.spring.dao.AbstractDao;
import cinema.project.spring.dao.MovieSessionDao;
import cinema.project.spring.exception.DataProcessingException;
import cinema.project.spring.model.MovieSession;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDaoImpl extends AbstractDao<MovieSession> implements MovieSessionDao {
    public MovieSessionDaoImpl(SessionFactory factory) {
        super(factory, MovieSession.class);
    }

    @Override
    public List<MovieSession> findAvailableSessions(Long movieId, LocalDate date) {
        try (Session session = factory.openSession()) {
            Query<MovieSession> getAvailableSessions = session.createQuery(
                    "FROM MovieSession m WHERE m.movie.id = :id "
                            + "AND DATE_FORMAT(showTime, '%Y-%m-%d') = :date", MovieSession.class);
            getAvailableSessions.setParameter("id", movieId);
            getAvailableSessions.setParameter("date", date.toString());
            return getAvailableSessions.getResultList();
        } catch (Exception e) {
            throw new DataProcessingException("Session for movie with id "
                    + movieId + " and show date " + date + " not found", e);
        }
    }
}
