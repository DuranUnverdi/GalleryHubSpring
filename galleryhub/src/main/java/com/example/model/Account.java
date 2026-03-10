package com.example.model;

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
@Table(name = "account")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Account extends BaseEntity {
    @Column (name = "account_no")
    private String accountNo;
    @Column (name = "iban")
    private String iban;
    @Column (name = "amount")
    private BigDecimal amount;
    @Column (name = "currency_type")
    @Enumerated(jakarta.persistence.EnumType.STRING)
    private CurrencyType currencyType;
}
