package ru.gb.cart.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import ru.gb.product.domain.Product;
import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
@Table
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Cart {
    @Id
    @GeneratedValue
    private long id;
    @NotBlank(message = "Cart name cannot be blank")
    private String name;
    @OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
    private List<Product> products;

    public Cart(String name, List<Product> products) {
        this.name = name;
        this.products = products;
    }
}
