package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departure")
public class Departure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int departureId;

    @Column(length = 20, nullable = false, columnDefinition = "varchar(20) default 'Not available'")
    private String nightTime;

    @Column(length = 20, nullable = false, columnDefinition = "varchar(20) default 'Not available'")
    private String early;

    @Column(length = 20, nullable = false, columnDefinition = "varchar(20) default 'Not available'")
    private String midDay;

    @Column(length = 20, nullable = false, columnDefinition = "varchar(20) default 'Not available'")
    private String late;

    @OneToMany(mappedBy = "departure")
    private List<DepartureTicket> departureTickets;

    // Getters and Setters
}
