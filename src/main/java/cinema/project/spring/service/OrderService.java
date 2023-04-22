package cinema.project.spring.service;

import cinema.project.spring.model.Order;
import cinema.project.spring.model.ShoppingCart;
import cinema.project.spring.model.User;
import java.util.List;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
