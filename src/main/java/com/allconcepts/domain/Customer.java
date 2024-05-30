package com.allconcepts.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "customer")
public class Customer {

    @Id
    private Long customerId;

    private String firstName;

    private String lastName;

    private String email;

    @Field(name = "phone_number")
    private String phoneNo;

    private String city;
}
