package ru.gb.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.gb.domain.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
}
