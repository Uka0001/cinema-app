package cinema.project.spring.dao.impl;

import cinema.project.spring.dao.AbstractDao;
import cinema.project.spring.dao.RoleDao;
import cinema.project.spring.exception.DataProcessingException;
import cinema.project.spring.model.Role;
import java.util.Optional;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RoleDaoImpl extends AbstractDao<Role> implements RoleDao {
    public RoleDaoImpl(SessionFactory factory) {
        super(factory, Role.class);
    }

    @Override
    public Optional<Role> getByName(Role.RoleName roleName) {
        try (Session session = factory.openSession()) {
            Query<Role> getByNameQuery = session.createQuery(
                    "FROM Role WHERE roleName = :roleName", Role.class);
            getByNameQuery.setParameter("roleName", roleName);
            return getByNameQuery.uniqueResultOptional();
        } catch (Exception e) {
            throw new DataProcessingException("Role with name " + roleName + " not found", e);
        }

    }
}
