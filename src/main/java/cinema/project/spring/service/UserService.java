package cinema.project.spring.service;

import java.util.Optional;
import cinema.project.spring.model.User;

public interface UserService {
    User add(User user);

    User get(Long id);

    Optional<User> findByEmail(String email);
}
