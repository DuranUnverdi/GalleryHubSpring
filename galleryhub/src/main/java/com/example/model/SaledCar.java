package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "saled_car",uniqueConstraints =
        {@jakarta.persistence.UniqueConstraint(columnNames = {"gallery_id", "car_id","customer_id"}, name = "unique_saled_car")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SaledCar extends BaseEntity {
    @ManyToOne
    private Gallery gallery;
    @ManyToOne
    private Car car;
    @ManyToOne
    private Customer customer;
}
