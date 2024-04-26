package com.Gomes.pizzaria.services.impl;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.User;
import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.domain.dto.ProductUpdateDTO;
import com.Gomes.pizzaria.domain.dto.UserInfoDTO;
import com.Gomes.pizzaria.domain.enums.UserType;
import com.Gomes.pizzaria.exception.ObjectNotFound;
import com.Gomes.pizzaria.exception.UnauthorizedProductCreationException;
import com.Gomes.pizzaria.repositories.ProductRepository;
import com.Gomes.pizzaria.services.ProductService;
import com.Gomes.pizzaria.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

    @Override
    public ProductInfoDTO update(Long id, ProductUpdateDTO dto) {
        var product = productRepository.findById(id);
        if (!product.isEmpty()) {
            Product product1 = product.get();
            if (dto.getProductName() != null) product1.setProductName(dto.getProductName());
            if (dto.getDescription() != null) product1.setDescription(dto.getDescription());
            if (dto.getProductType() != null) product1.setProductType(dto.getProductType());
            if (dto.getUnitaryValue() != null) product1.setUnitaryValue(dto.getUnitaryValue());
            productRepository.save(product1);
            return new ProductInfoDTO(product1.getProductName(), product1.getDescription(), product1.getProductType(), product1.getUnitaryValue());
        } else {
            throw new ObjectNotFound("Objeto não encontrado.");
        }
    }

    @Override
    public ResponseEntity delete(Long id) {
        productRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    private Boolean isEmployee(Long id){
        UserInfoDTO user = userService.findByID(id);
        return user.getUserType().equals(UserType.EMPLOYEE);
    }
}
