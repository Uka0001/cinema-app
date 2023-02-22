package cinema.project.spring.dao;

import java.util.Optional;

import cinema.project.spring.model.Role;

public interface RoleDao {
    Role add(Role role);

    Optional<Role> getByName(Role.RoleName roleName);
}
