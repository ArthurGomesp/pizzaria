package com.Gomes.pizzaria.controller;


import com.Gomes.pizzaria.domain.Product;

import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.dto.ProductInfoDTO;
import com.Gomes.pizzaria.domain.dto.ProductUpdateDTO;
import com.Gomes.pizzaria.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/produto")
public class productContoller {
    @Autowired
    private ProductService productService;

    @PostMapping("/{id}")
    public ResponseEntity create(@RequestBody ProductCreateDTO dto, @PathVariable @RequestBody Long id){
        Product product = productService.create(dto, id);
        return ResponseEntity.status(HttpStatus.CREATED).body(product);
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable @RequestBody Long id){
        ProductInfoDTO product = productService.findById(id);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }
    @PutMapping("/{id}")
    public ResponseEntity update(@PathVariable @RequestBody Long id, @RequestBody ProductUpdateDTO dto){
        ProductInfoDTO product = productService.update(id, dto);
        return ResponseEntity.status(HttpStatus.OK).body(product);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable @RequestBody Long id){
        return productService.delete(id);
    }
}
