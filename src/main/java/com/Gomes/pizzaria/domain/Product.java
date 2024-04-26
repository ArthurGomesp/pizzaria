package com.Gomes.pizzaria.domain;


import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.enums.ProductType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


import java.math.BigDecimal;

@Setter
@Getter
@Entity
@Table(name = "produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String productName;
    private String description;
    @Enumerated(EnumType.STRING)
    private ProductType productType;
    private BigDecimal unitaryValue;

    public Product() {
    }
    public Product(Long id, String productName, String description, BigDecimal unitaryValue) {
        this.id = id;
        this.productName = productName;
        this.description = description;
        this.unitaryValue = unitaryValue;
    }

    public Product(ProductCreateDTO dto) {
        this.productName = dto.getProductName();
        this.description = dto.getDescription();
        this.productType = dto.getProductType();
        this.unitaryValue = dto.getUnitaryValue();
    }

}
