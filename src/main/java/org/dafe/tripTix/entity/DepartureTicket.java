package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "departure_ticket")
public class DepartureTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int departureTicketId;

    @ManyToOne
    @JoinColumn(name = "departure_id",referencedColumnName = "id", nullable = false)
    private Departure departure;

    @ManyToOne
    @JoinColumn(name = "ticket_id",referencedColumnName = "id", nullable = false)
    private Tickets ticket;

    // Getters and Setters
}
