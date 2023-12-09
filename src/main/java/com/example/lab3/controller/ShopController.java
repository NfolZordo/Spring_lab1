package com.example.lab3.controller;


import com.example.lab3.model.Shop;
import com.example.lab3.repository.ShopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopRepository shopRepository;

    // Отримати всі магазини
    @GetMapping("/getAllShops")
    public ResponseEntity<Iterable<Shop>> getAllShops() {
        Iterable<Shop> shops = shopRepository.findAll();
        return ResponseEntity.ok(shops);
    }

    // Отримати магазин за ідентифікатором
    @GetMapping("/{id}")
    public ResponseEntity<Shop> getShopById(@PathVariable Integer id) {
        return shopRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Зберегти новий магазин
    @PostMapping("/saveShop")
    public ResponseEntity<Shop> saveShop(@RequestBody Shop shop) {
        Shop savedShop = shopRepository.save(shop);
        return ResponseEntity.ok(savedShop);
    }

    // Змінити існуючий магазин
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

    // Видалити магазин за ідентифікатором
    @DeleteMapping("/deleteShop/{id}")
    public ResponseEntity<Void> deleteShop(@PathVariable Integer id) {
        shopRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}