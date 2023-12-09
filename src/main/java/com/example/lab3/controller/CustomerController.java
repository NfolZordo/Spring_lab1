package com.example.lab3.controller;

import com.example.lab3.model.Customer;
import com.example.lab3.model.Product;
import com.example.lab3.model.Shop;
import com.example.lab3.repository.CustomerRepository;
import com.example.lab3.repository.ProductsRepository;
import com.example.lab3.repository.ShopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductsRepository productRepository;

    // Отримати всіх покупців
    @GetMapping("/getAllCustomers")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    // Отримати покупця за ідентифікатором
    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional
                .map(customer -> ResponseEntity.ok().body(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    // Зберегти нового покупця
    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(
            @RequestParam String name,
            @RequestParam Integer phone,
            @RequestParam Integer shopId
    ) {
        Optional<Shop> shopOptional = shopRepository.findById(shopId);

        if (shopOptional.isPresent()) {
            Shop shop = shopOptional.get();
            Customer customer = new Customer();
            customer.setName(name);
            customer.setPhone(phone);
            customer.setShop(shop);
            Customer savedCustomer = customerRepository.save(customer);
            return ResponseEntity.ok(savedCustomer);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    // Видалити покупця за ідентифікатором
    @DeleteMapping("/deleteCustomer/{id}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Integer id) {
        customerRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/addProductForCustomer/{id}")
    public ResponseEntity<Customer> addProductForCustomer(
            @PathVariable Integer id,
            @RequestParam Integer productId
    ) {
        Optional<Customer> existingCustomerOptional = customerRepository.findById(id);

        if (existingCustomerOptional.isPresent()) {
            Customer existingCustomer = existingCustomerOptional.get();
            Product product = productRepository.findById(productId.intValue());

            if (product != null) {
                Set<Product> products = new HashSet<>();
                products.add(product);
                existingCustomer.setProducts(products);
                Customer savedCustomer = customerRepository.save(existingCustomer);
                return ResponseEntity.ok(savedCustomer);
            } else {
                return ResponseEntity.notFound().build();
            }
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
}