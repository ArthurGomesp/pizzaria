package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.domain.enums.UserType;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.exception.UnauthorizedProductCreationException;
import com.Gomes.pizzaria.repositories.ProductRepository;
import com.Gomes.pizzaria.services.ProductService;
import com.Gomes.pizzaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private UserService userService;

    @Override
    public Product create(ProductCreateDTO dto, Long id) {
        if (isEmployee(id)) {
            Product product = new Product(dto);
            productRepository.save(product);
            return product;
        } else {
            throw new UnauthorizedProductCreationException("Somente usuarios do tipo funcionarios pode criar produtos");
        }
    }

    @Override
    public ProductInfoDTO findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) return new ProductInfoDTO(product);
        throw new ObjectNotFound("Objeto não encontrado.");
    }


    private Boolean isEmployee(Long id) {
        UserInfoDTO user = userService.findByID(id);
        return user.getUserType().equals(UserType.EMPLOYEE);
    }
}
