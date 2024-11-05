package com.hsbc.order;

import com.hsbc.order.supplier.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public List<Order> findBysupplierAndStatus(Supplier supplier, OrderStatus status);

}
