package com.gene.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@Table(name = "SearchCase")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SearchCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int caseId;

    @Column(name = "PersonId", nullable = false)
    private int personId;  // Foreign key to Person (the missing person)

    @Column(name = "ReportedBy", nullable = false)
    private int reportedBy;  // Foreign key to Person (who reported the case)

    @Column(name = "DateReported")
    @Temporal(TemporalType.DATE)
    private Date dateReported;

    @Column(name = "SearchStatus", length = 50)
    private String searchStatus;

    @Column(name = "LastKnownLocation", length = 100)
    private String lastKnownLocation;

    @Column(name = "AdditionalInfo")
    private String additionalInfo;
}
