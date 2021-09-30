package ru.gb.product.repository;

import org.springframework.stereotype.Repository;

import java.awt.*;


@Repository
public interface
ProductRepository extends CrudRepository<Product, Integer> {
}
