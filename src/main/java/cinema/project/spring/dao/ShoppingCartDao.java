package cinema.project.spring.dao;

import cinema.project.spring.model.ShoppingCart;
import cinema.project.spring.model.User;

public interface ShoppingCartDao {
    ShoppingCart add(ShoppingCart shoppingCart);

    ShoppingCart getByUser(User user);

    ShoppingCart update(ShoppingCart shoppingCart);
}
