package ru.gb.cart.controller;


import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.gb.cart.domain.Cart;
import ru.gb.cart.repository.CartRepository;
import ru.gb.product.domain.Product;

import java.net.URI;
import java.util.Optional;

@RestController
@RequestMapping("/carts")
@AllArgsConstructor
public class CartController {
    private final CartRepository cartRepository;

    @GetMapping
    public ResponseEntity<Iterable<Cart>> findAll(){return ResponseEntity.ok(cartRepository.findAll());}

    @GetMapping(value = "/{id}")
    public ResponseEntity<Cart> findById(@PathVariable long id){
        Optional<Cart> mayBeCart = cartRepository.findById((int) id);
        if (mayBeCart.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(mayBeCart.get());
    }

    @PostMapping
    public ResponseEntity<Cart> save(@RequestBody Cart department) {
        Cart newlyCreated = cartRepository.save(department);
        return ResponseEntity.created(URI.create("/departments/" + newlyCreated.getId())).body(newlyCreated);
    }
    @DeleteMapping(value = "/{id}")
        public Object deleteById(@PathVariable int id) {
        Optional<Cart> maybeCart = cartRepository.findById(id);
        if (maybeCart.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        cartRepository.deleteById(id);
        return ResponseEntity.ok();
    }
}
