package com.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.NotBlank;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "client")
public class Client {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotBlank
    @Column(nullable = false)
    @NotEmpty(message = "The field can not be empty!")
    @NotNull(message = "Field can not be null!")
    @Size(min = 3, message = "Input 3 letter")
    @Pattern(regexp = "^[-_a-zA-Z0-9]+(\\s+[-_a-zA-Z0-9]+)*$")
    private String name;

    @NotNull(message = "Field can not be null!")
    @Column(nullable = false)
    private Boolean isCompany;

    @Column(length = 14)
    private String regNo;

    @Column(length = 11)
    @Pattern(regexp = "^[0-9]*$", message = "Enter the correct value (only digits)")
    private String vatId;

    @OneToOne(cascade = CascadeType.ALL)
    private Contact contact;

    //@NotEmpty(message = "Complete at least one field!")
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Contact> contacts = new HashSet<>();

    @OneToOne(cascade = CascadeType.ALL)
    private Address address;

    @OneToOne(cascade = CascadeType.ALL)
    private ShippingAddress shippingAddress;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Address> shippingAddresses = new HashSet<>();
}