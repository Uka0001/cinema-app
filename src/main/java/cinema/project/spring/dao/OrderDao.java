package cinema.project.spring.dao;

import cinema.project.spring.model.Order;
import cinema.project.spring.model.User;
import java.util.List;

public interface OrderDao {
    Order add(Order order);

    List<Order> getOrdersHistory(User user);
}
