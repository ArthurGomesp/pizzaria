package com.Gomes.pizzaria.services;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;

public interface ProductService {
    Product create(ProductCreateDTO dto, Long id);
    ProductInfoDTO findById(Long id);
}
