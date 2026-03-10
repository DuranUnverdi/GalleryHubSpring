package com.example.model;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "gallery_car", uniqueConstraints =
        {@jakarta.persistence.UniqueConstraint(columnNames = {"gallery_id", "car_id"}, name = "unique_gallery_car")})
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GalleryCar extends BaseEntity {
    @ManyToOne
    private Gallery gallery;
    @ManyToOne
    private Car car;
}
