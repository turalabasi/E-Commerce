package repository;

import jakarta.persistence.criteria.Order;

import java.util.List;

public interface OrderRepository {
    void createOrder(model.entity.Order order);
    List<Order> findAll();
}
