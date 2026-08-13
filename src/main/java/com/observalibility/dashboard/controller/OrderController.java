package com.observalibility.dashboard.controller;
import com.observalibility.dashboard.entity.Order;
import com.observalibility.dashboard.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    public Order getOrder(@PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/high-latency")
    public String highLatency() throws InterruptedException {
        return orderService.highLatency();
    }

    @GetMapping("/error")
    public String error() {
        return orderService.error();
    }

    @GetMapping("/database-error")
    public String databaseError() {
        return orderService.databaseError();
    }
}