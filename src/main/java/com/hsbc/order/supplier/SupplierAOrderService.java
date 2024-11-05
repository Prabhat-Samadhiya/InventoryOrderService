package com.hsbc.order.supplier;

import com.hsbc.order.Order;
import com.hsbc.order.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SupplierAOrderService implements SupplierOrderService {


    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(Order order, int quantity) {


            // Logic to place an order with Supplier A
            System.out.println("Order placed with Supplier A for Part ID: " + order.toString() + ", Quantity: " + quantity);
            // Update order status to ORDER_PLACED
            orderRepository.save(order);
        }

}

