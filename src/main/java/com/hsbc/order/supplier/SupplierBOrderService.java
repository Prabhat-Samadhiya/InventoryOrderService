package com.hsbc.order.supplier;

import com.hsbc.order.Order;
import com.hsbc.order.OrderRepository;
import com.hsbc.order.OrderStatus;
import com.hsbc.order.part.Part;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Service
public class SupplierBOrderService implements SupplierOrderService {

    private static final LocalTime START_TIME = LocalTime.of(0, 0);
    private static final LocalTime END_TIME = LocalTime.of(1, 0);

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public void placeOrder(Order order, int quantity) {
        LocalDateTime currentTime = LocalDateTime.now();
        order.setOrderTime(currentTime);
        order.setStatus(OrderStatus.TO_BE_PLACED);
        orderRepository.save(order);
    }

    @Scheduled(cron = "0 0 0 * * *") // Run daily at midnight
    public void placeScheduledOrder() {
        // Implementation for Supplier-B orders between 12-1 AM
        // Fetch all elligile orders pending for order with Supplier B
        List<Order> supplierBOrders = orderRepository.findBysupplierAndStatus(Supplier.SUPPLIER_B, OrderStatus.TO_BE_PLACED);
        for(Order order : supplierBOrders){
            if(LocalTime.now().isAfter(END_TIME)){
                break;
            }
            placeOrder(order);
            order.setStatus(OrderStatus.ORDERED);
            orderRepository.save(order);
        }
    }

    public void placeOrder(Order order){
        System.out.println("Actual implementation of order with Supplier B");
    }
}

