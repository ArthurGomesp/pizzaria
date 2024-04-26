package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor
public class ProductCreateDTO {
    private String productName;
    private String description;
    private ProductType productType;
    private BigDecimal unitaryValue;
}
