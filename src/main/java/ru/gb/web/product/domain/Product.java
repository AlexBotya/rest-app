package ru.gb.web.product.domain;

import lombok.*;
import lombok.experimental.FieldDefaults;
import ru.gb.web.cart.domain.Cart;
import ru.gb.web.category.domain.Category;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@EqualsAndHashCode
@Table(name =  "products")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Product {
    @Id
    @GeneratedValue
    int id;
    @NotBlank(message = "Product name cannot be blank")
    String title;

    int price;
    @ManyToOne
    @JoinColumn (name = "cart_id")
    Cart cart;
    @ManyToMany
    List<Category> categories;


}
