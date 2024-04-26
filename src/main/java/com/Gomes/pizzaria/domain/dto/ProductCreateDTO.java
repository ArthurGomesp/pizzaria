package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.enums.ProductType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter @Setter @AllArgsConstructor
public class ProductCreateDTO {
    @NotBlank
    @NotNull
    private String productName;
    @NotNull
    @NotBlank
    private String description;
    @NotNull
    private ProductType productType;
    @NotNull
    private BigDecimal unitaryValue;
}
