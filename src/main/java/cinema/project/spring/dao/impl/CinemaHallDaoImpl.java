package cinema.project.spring.dao.impl;

import cinema.project.spring.dao.AbstractDao;
import cinema.project.spring.dao.CinemaHallDao;
import cinema.project.spring.model.CinemaHall;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class CinemaHallDaoImpl extends AbstractDao<CinemaHall> implements CinemaHallDao {
    public CinemaHallDaoImpl(SessionFactory factory) {
        super(factory, CinemaHall.class);
    }
}
