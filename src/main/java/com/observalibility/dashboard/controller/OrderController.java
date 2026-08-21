package com.observalibility.dashboard.controller;
import com.observalibility.dashboard.entity.Order;
import com.observalibility.dashboard.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
@Tag(name = "Order Controller", description = "Endpoints for order management and monitoring incidents")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    @Operation(summary = "Get all orders", description = "Retrieve a list of all orders (normal operation)")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved orders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get order by ID", description = "Retrieve a specific order by its ID")
    @ApiResponse(responseCode = "200", description = "Successfully retrieved order")
    public Order getOrder(@Parameter(description = "Order ID") @PathVariable Long id) {
        return orderService.getOrder(id);
    }

    @GetMapping("/high-latency")
    @Operation(summary = "High latency test", description = "Test endpoint that simulates high latency for monitoring")
    @ApiResponse(responseCode = "200", description = "Response with simulated delay")
    public String highLatency() throws InterruptedException {
        return orderService.highLatency();
    }

    @GetMapping("/error")
    @Operation(summary = "Error test", description = "Test endpoint that throws RuntimeException for error monitoring")
    @ApiResponse(responseCode = "500", description = "Intentional error for testing")
    public String error() {
        return orderService.error();
    }

    @GetMapping("/database-error")
    @Operation(summary = "Database error test", description = "Test endpoint that simulates database connection failure")
    @ApiResponse(responseCode = "500", description = "Simulated database error for testing")
    public String databaseError() {
        return orderService.databaseError();
    }
}