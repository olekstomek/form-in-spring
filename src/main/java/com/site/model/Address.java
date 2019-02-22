package com.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "address")
public class Address {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    Long id;

    @NotNull(message = "Field can not be null!")
    @Column(nullable = false, length = 40)
    String street;

    String zip;

    String state;

    @NotNull(message = "Field can not be null!")
    @Column(nullable = false)
    String city;

    @NotNull(message = "Field can not be null!")
    @Column(nullable = false)
    String country;
}
