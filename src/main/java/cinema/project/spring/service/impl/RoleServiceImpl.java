package cinema.project.spring.service.impl;

import cinema.project.spring.service.RoleService;
import cinema.project.spring.dao.RoleDao;
import cinema.project.spring.model.Role;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService {
    private final RoleDao roleDao;

    public RoleServiceImpl(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    @Override
    public Role add(Role role) {
        return roleDao.add(role);
    }

    @Override
    public Role getByName(Role.RoleName roleName) {
        return roleDao.getByName(roleName).orElseThrow(
                () -> new RuntimeException("Couldn't find role: "
                        + roleName)
        );
    }
}
