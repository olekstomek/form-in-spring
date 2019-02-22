package com.site.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "contact")
public class Contact {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @NotEmpty(message = "The field can not be empty!")
    @NotNull(message = "Field can not be null!")
    @Column(nullable = false)
    @Pattern(regexp = "^[-_a-zA-Z0-9]+(\\s+[-_a-zA-Z0-9]+)*$", message = "Remove spaces at the beginning and end!")
    private String name;

    @Column(length = 14)
    private String phone;

    @Email(message = "Bad email format")
    @Column(length = 50)
    private String email;

    @Column(length = 14)
    private String fax;
}
