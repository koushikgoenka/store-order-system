package com.koushik.orders.service.serviceImpl;

import com.koushik.orders.model.Order;
import com.koushik.orders.repository.OrderRepository;
import com.koushik.orders.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order addOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    @Override
    public Optional<Order> getOrderById(Long orderId) {
        return orderRepository.findById(orderId);
    }

    @Override
    public Optional<Order> updateOrder(Long orderId, Order order) {

        Optional<Order> savedOrderOptional = orderRepository.findById(orderId);
        if (savedOrderOptional.isPresent()) {
            Order savedOrder = savedOrderOptional.get();
            savedOrder.setItemList(order.getItemList());
            savedOrder.setTotalPrice(order.getTotalPrice());
            orderRepository.save(savedOrder);
            return Optional.of(savedOrder);
        }
        return Optional.empty();
    }

    @Override
    public void deleteOrder(Long orderId) {
        orderRepository.deleteById(orderId);
    }
}
