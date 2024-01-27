package com.Gomes.pizzaria.domain.dto;

import com.Gomes.pizzaria.domain.Product;
import com.Gomes.pizzaria.domain.enums.ProductType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Optional;

@Getter
@Setter
@AllArgsConstructor
public class ProductInfoDTO {
        private String productName;
        private String description;
        private ProductType productType;
        private BigDecimal unitaryValue;

        public ProductInfoDTO(Optional<Product> product) {
                this.productName = product.get().getProductName();
                this.description = product.get().getDescription();
                this.productType = product.get().getProductType();
                this.unitaryValue = product.get().getUnitaryValue();
        }
}
