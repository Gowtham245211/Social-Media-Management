package com.allconcepts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "order")
public class Order {

    @Id
    private Long orderId;

    private String orderDate;

    private Long customerId;

    private String totalAmount;

    private String shippingAddress;

    private String orderStatus;
}
