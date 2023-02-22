package cinema.project.spring.service;

import java.util.List;
import cinema.project.spring.model.Order;
import cinema.project.spring.model.ShoppingCart;
import cinema.project.spring.model.User;

public interface OrderService {
    Order completeOrder(ShoppingCart shoppingCart);

    List<Order> getOrdersHistory(User user);
}
