package ru.gb.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.cart.domain.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
