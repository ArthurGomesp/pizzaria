package com.Gomes.pizzaria.domain;


import com.Gomes.pizzaria.domain.dto.ProductCreateDTO;
import com.Gomes.pizzaria.domain.enums.ProductType;
import jakarta.persistence.*;


import java.math.BigDecimal;

@Entity
@Table(name = "produto")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ProductType getProductType() {
        return productType;
    }

    public void setProductType(ProductType productType) {
        this.productType = productType;
    }

    public BigDecimal getUnitaryValue() {
        return unitaryValue;
    }

    public void setUnitaryValue(BigDecimal unitaryValue) {
        this.unitaryValue = unitaryValue;
    }
}
