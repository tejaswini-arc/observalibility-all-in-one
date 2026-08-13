package com.observalibility.dashboard.service;

import com.observalibility.dashboard.entity.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    public List<Order> getOrders() {

        return List.of(
                new Order(1L, "Customer-A", "CREATED"),
                new Order(2L, "Customer-B", "PROCESSING"),
                new Order(3L, "Customer-C", "COMPLETED")
        );
    }

    public Order getOrder(Long id) {

        return new Order(id, "Customer-" + id, "CREATED");
    }

    public String highLatency() throws InterruptedException {

        Thread.sleep(5000);

        return "Response after 5 seconds";
    }

    public String error() {

        throw new RuntimeException("Intentional AIOps test failure");
    }

    public String databaseError() {

        throw new RuntimeException("Simulated database connection failure");
    }
}