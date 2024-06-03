package com.allconcepts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {

    @Id
    private Long orderId;

    private LocalDateTime orderDate;

    private Long customerId;

    private Long productId;

    private Integer totalAmount;

    private String shippingAddress;

    private String orderStatus;
}
