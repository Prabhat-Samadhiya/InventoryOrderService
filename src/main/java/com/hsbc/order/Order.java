package com.hsbc.order;

import com.hsbc.order.supplier.Supplier;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.time.LocalDateTime;

@Entity
@Data
@EqualsAndHashCode
@ToString
public class Order {
    @Id
    private Long orderId;
    private Long partId;
    @Enumerated(EnumType.STRING)
    private Supplier supplier;
    private int orderQty;
    private LocalDateTime orderTime;
    private OrderStatus status;

    // Getters and Setters
}

