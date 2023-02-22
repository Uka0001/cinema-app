package cinema.project.spring.dao;

import java.util.Optional;

import cinema.project.spring.model.User;

public interface UserDao {
    User add(User user);

    Optional<User> get(Long id);

    Optional<User> findByEmail(String email);
}
