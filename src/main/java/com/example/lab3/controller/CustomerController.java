package com.example.lab3.controller;

import com.example.lab3.model.Customer;
import com.example.lab3.model.Product;
import com.example.lab3.model.ProductsPrice;
import com.example.lab3.model.Shop;
import com.example.lab3.repository.CustomerRepository;
import com.example.lab3.repository.ProductsRepository;
import com.example.lab3.repository.ShopRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private ShopRepository shopRepository;
    @Autowired
    private ProductsRepository productRepository;

    @GetMapping("/getAllCustomers")
    public ResponseEntity<Iterable<Customer>> getAllCustomers() {
        Iterable<Customer> customers = customerRepository.findAll();
        return ResponseEntity.ok(customers);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<Customer> getCustomerById(@PathVariable Integer id) {
        Optional<Customer> customerOptional = customerRepository.findById(id);

        return customerOptional
                .map(customer -> ResponseEntity.ok().body(customer))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/saveCustomer")
    public ResponseEntity<Customer> saveCustomer(
            @RequestParam String name,
            @RequestParam Integer phone,
            @RequestParam Integer shopId
    ) {
        try {
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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

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

    @GetMapping("/getProductsAndPricesByPhone")
    public ResponseEntity<Map<String, List<Double>>> getProductsAndPricesByPhone(@RequestParam Integer phone) {
        Customer customer = customerRepository.findByPhone(phone);
        Map<String, List<Double>> productsAndPrices = new HashMap<>();
        for (Product product : customer.getProducts()) {
            List<Double> prices = productRepository.findPriceByProductAndCustomer(product.getId(), customer.getShop().getId())
                    .stream()
                    .map(result -> Double.valueOf(result[2].toString()))
                    .collect(Collectors.toList());
            productsAndPrices.put(product.getName(), prices);
        }

        return ResponseEntity.ok(productsAndPrices);
    }

}