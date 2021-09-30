package ru.gb.product.domain;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
@Table
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Product name cannot be blank")
    private String title;

    private int price;

}
