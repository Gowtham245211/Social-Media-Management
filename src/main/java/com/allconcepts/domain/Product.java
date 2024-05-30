package com.allconcepts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "product")
public class Product {

    @Id
    private Long productId;

    private String productName;

    private Long categoryId;

    private String quantityPerUnit;

    private String unitPrice;

    private String unitsInStock;
}
