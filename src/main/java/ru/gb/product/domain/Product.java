package ru.gb.product.domain;

import lombok.*;
import ru.gb.cart.domain.Cart;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
@Table(name =  "products")
public class Product {
    @Id
    @GeneratedValue
    private int id;
    @NotBlank(message = "Product name cannot be blank")
    private String title;

    private int price;
    @ManyToOne
    @JoinColumn (name = "cart_id")
    private Cart cart;

}
