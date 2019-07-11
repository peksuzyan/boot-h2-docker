package com.gmail.eksuzyan.pavel.education.dto;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

/**
 * @author Pavel Eksuzian.
 * Created: 11.07.2019.
 */
@Data
@Entity
@Table(name = "T_PERSON")
public class Person {

    @Id
    @SequenceGenerator(name = "person_seq", sequenceName = "PERSON_SEQ", initialValue = 1_000, allocationSize = 1)
    @GeneratedValue(generator = "person_seq")
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "FULL_NAME", length = 64, nullable = false)
    private String fullName;

    @Temporal(TemporalType.DATE)
    @Column(name = "DATE_OF_BIRTH", nullable = false)
    private Date dateOfBirth;

}
