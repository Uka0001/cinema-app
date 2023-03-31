package cinema.project.spring.dao.impl;

import cinema.project.spring.dao.AbstractDao;
import cinema.project.spring.dao.TicketDao;
import cinema.project.spring.model.Ticket;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class TicketDaoImpl extends AbstractDao<Ticket> implements TicketDao {
    public TicketDaoImpl(SessionFactory factory) {
        super(factory, Ticket.class);
    }
}
