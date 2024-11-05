package com.hsbc.order.supplier;

import com.hsbc.order.Order;

public interface SupplierOrderService {
    void placeOrder(Order order, int quantity);
}

