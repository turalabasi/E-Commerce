package service.impl;

import model.entity.Order;
import model.entity.User;
import repository.OrderRepository;
import repository.impl.IOrderRepository;
import service.OrderService;

import java.time.LocalDateTime;

public class IOrderService implements OrderService {
    OrderRepository orderRepository = new IOrderRepository();
    @Override
    public void createOrder(User user) {
        Order order = Order.builder()
                .products(user.getCart().getProducts())
                .orderDate(LocalDateTime.now())
                .phone(user.getPhoneNumber())
                .totalPrice(user.getCart().getAccountBalance())
                .build();


        orderRepository.createOrder(order);
    }

    @Override
    public void findAll() {
        System.out.println(orderRepository.findAll());;
    }
}
