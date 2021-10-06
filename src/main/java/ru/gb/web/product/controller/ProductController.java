package ru.gb.web.product.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;
import ru.gb.web.product.domain.Product;
import ru.gb.web.product.errorHndler.ProductError;
import ru.gb.web.product.repository.ProductRepository;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@Secured({"ROLE_ADMIN"})
public class ProductController {
    private final ProductRepository productRepository;

    public ProductController(ProductRepository repository) {
        this.productRepository = repository;
    }

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(productRepository.findAll());
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        Optional<Product> maybeProduct = productRepository.findById((int) id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(maybeProduct.get());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newlyCreated = productRepository.save(product);
        return ResponseEntity.created(URI.create("/products/" + newlyCreated.getId())).body(newlyCreated);
    }

    @DeleteMapping(value = "/{id}")
    public Object deleteById(@PathVariable int id) {
        Optional<Product> maybeProduct = productRepository.findById(id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        productRepository.deleteById(id);
        return ResponseEntity.ok();
    }


    @ExceptionHandler
    public ResponseEntity<ProductError> handleException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(new ProductError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

}
