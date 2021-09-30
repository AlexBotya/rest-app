package ru.gb.product.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.product.domain.Product;

@Repository
public interface
ProductRepository extends CrudRepository<Product, Integer> {
}
