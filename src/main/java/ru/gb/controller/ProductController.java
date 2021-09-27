package ru.gb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.domain.Product;
import ru.gb.errorHndler.ProductError;
import ru.gb.repository.ProductRepository;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    private final ProductRepository repository;


    public ProductController(ProductRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    @RequestMapping("/all")
    public ResponseEntity<Iterable<Product>> findAll() {
        return ResponseEntity.ok(repository.findAll());
    }

    @GetMapping
    @RequestMapping("/get/{id}")
    public ResponseEntity<Product> findById(@PathVariable long id) {
        Optional<Product> maybeProduct = repository.findById((int) id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(maybeProduct.get());
    }

    @PostMapping
    public ResponseEntity<Product> save(@RequestBody Product product) {
        Product newlyCreated = repository.save(product);
        return ResponseEntity.created(URI.create("/products/" + newlyCreated.getId())).body(newlyCreated);
    }

    @DeleteMapping
    @RequestMapping("/delete/{id}")
    public Object deleteById(@PathVariable int id) {
        Optional<Product> maybeProduct = repository.findById(id);
        if (maybeProduct.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok();
    }


    @ExceptionHandler
    public ResponseEntity<ProductError> handleException(RuntimeException ex) {
        return ResponseEntity.internalServerError()
                .body(new ProductError(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage()));
    }

}
