package com.gene.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Entity
@Table(name = "Person")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int personId;

    @Column(name = "FirstName", nullable = false, length = 50)
    private String firstName;

    @Column(name = "LastName", nullable = false, length = 50)
    private String lastName;

    @Column(name = "Gender")
    private boolean gender;  // true = male, false = female

    @Column(name = "DateOfBirth")
    @Temporal(TemporalType.DATE)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dateOfBirth;

    @Column(name = "PhoneNumber", length = 12)
    private String phoneNumber;

    @Column(name = "IdentityId", length = 12, unique = true)
    private String identityId;

    @Column(name = "Address", length = 100)
    private String address;

    @Column(name = "AdditionalNotes")
    private String additionalNotes;
}
