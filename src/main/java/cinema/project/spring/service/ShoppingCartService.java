package cinema.project.spring.service;

import cinema.project.spring.model.MovieSession;
import cinema.project.spring.model.ShoppingCart;
import cinema.project.spring.model.User;

public interface ShoppingCartService {
    void addSession(MovieSession movieSession, User user);

    ShoppingCart getByUser(User user);

    void registerNewShoppingCart(User user);

    void clear(ShoppingCart shoppingCart);
}
