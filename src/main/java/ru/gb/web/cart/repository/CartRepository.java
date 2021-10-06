package ru.gb.web.cart.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.web.cart.domain.Cart;
@Repository
public interface CartRepository extends CrudRepository<Cart, Integer> {
}
