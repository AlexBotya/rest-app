package ru.gb.web.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.web.product.domain.Product;

@Repository
public interface
ProductRepository extends CrudRepository<Product, Integer> {
}
