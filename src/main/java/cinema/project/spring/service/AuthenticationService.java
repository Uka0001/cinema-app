package cinema.project.spring.service;

import cinema.project.spring.model.User;

public interface AuthenticationService {
    User register(String email, String password);
}
