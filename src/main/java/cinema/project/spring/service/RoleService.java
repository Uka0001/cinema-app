package cinema.project.spring.service;

import cinema.project.spring.model.Role;

public interface RoleService {
    Role add(Role role);

    Role getByName(Role.RoleName roleName);
}
