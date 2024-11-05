package com.hsbc.order;

import com.hsbc.order.supplier.SupplierOrderService;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private OrderServiceFactory orderRepository;

    @Scheduled(cron = "0 0 0 * * *") // Run daily at midnight
    public void placeScheduledOrder() {
        // Implementation for Supplier-B orders between 12-1 AM
    }

    public Order placeOrder(OrderRequest request) {
        // Save Draft order in DB with status as TO_BE_ORDERED
        orderRepository.save(OrderRequest);

        // Based on Supplier, order will be placed either immediality and status updated
        // to ORDER_PLACED.
        SupplierOrderService supplierOrderService = OrderServiceFactory.getOrderService(request.getSupplier());
        supplierOrderService.placeOrder(part, quantityToOrder);


    }
}
