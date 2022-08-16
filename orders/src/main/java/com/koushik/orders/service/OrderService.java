package com.koushik.orders.service;

import com.koushik.orders.model.Order;

import java.util.List;
import java.util.Optional;

public interface OrderService {

    public Order addOrder(Order order);

    public List<Order> getAllOrders();

    public Optional<Order> getOrderById(Long orderId);

    public Optional<Order> updateOrder(Long orderId, Order order);

    public void deleteOrder(Long OrderId);
}
