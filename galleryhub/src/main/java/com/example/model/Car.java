package com.example.model;

import com.example.enums.CarStatusType;
import com.example.enums.CurrencyType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Entity
@Table(name = "car")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Car extends BaseEntity {
    @Column(name = "plaka")
    private String plaka;
    @Column(name = "brand")
    private String brand;
    @Column(name = "model")
    private String model;
    @Column(name = "year")
    private Integer year;
    @Column(name = "color")
    private BigDecimal price;
    @Column(name = "currency_type")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private CurrencyType currencyType;
    @Column(name = "damage_price")
    private BigDecimal damagePrice;
    @Column(name = "car_status_type")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private CarStatusType carStatusType;
}
