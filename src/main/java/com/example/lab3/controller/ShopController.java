package com.example.lab3.controller;


import com.example.lab3.model.Shop;
import com.example.lab3.repository.ShopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    @GetMapping("/getAllShops")
    public ResponseEntity<Iterable<Shop>> getAllShops() {
        Iterable<Shop> shops = shopRepository.findAll();
        return ResponseEntity.ok(shops);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        return shopRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/saveShop")
    @Transactional
    public ResponseEntity<String> saveShop(
            @RequestParam String name,
            @RequestParam String address
    ) {
        try {
            shopRepository.save(name, address);
            return ResponseEntity.ok("OK");
        }
        catch (Error e) {
            return ResponseEntity.ok(e.toString());

        }
    }

    @PutMapping("/updateShop/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable Integer id, @RequestBody Shop updatedShop) {
        return shopRepository.findById(id)
                .map(existingShop -> {
                    existingShop.setName(updatedShop.getName());
                    existingShop.setAddress(updatedShop.getAddress());
                    Shop savedShop = shopRepository.save(existingShop);
                    return ResponseEntity.ok(savedShop);
                })
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/deleteShop/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Integer id) {
        shopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}