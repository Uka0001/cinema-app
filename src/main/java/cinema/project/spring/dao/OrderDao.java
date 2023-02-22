package cinema.project.spring.dao;

import java.util.List;

import cinema.project.spring.model.Order;
import cinema.project.spring.model.User;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
