package com.kb.shop.domain;

import com.kb.shop.domain.enums.ShippingStatus;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class ShippingInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Order id
    private Long orderId;

    // OrderItem id
    private Long orderItemId;

    // shippingStatus
    @Enumerated(EnumType.STRING)
    private ShippingStatus shippingStatus;

}
