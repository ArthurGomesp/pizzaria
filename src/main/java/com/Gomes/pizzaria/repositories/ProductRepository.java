package com.Gomes.pizzaria.repositories;

import com.Gomes.pizzaria.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByProductName(String productName);


}
