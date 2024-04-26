package com.Gomes.pizzaria.services;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.domain.dto.ProductUpdateDTO;
import org.springframework.http.ResponseEntity;

public interface ProductService {
    Product create(ProductCreateDTO dto, Long id);
    ProductInfoDTO findById(Long id);
    ProductInfoDTO update(Long id, ProductUpdateDTO dto);
    ResponseEntity delete(Long id);
}
