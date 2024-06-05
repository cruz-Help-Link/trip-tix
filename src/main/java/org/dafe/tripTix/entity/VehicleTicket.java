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
@Table(name = "vehicle_ticket")
public class VehicleTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int vehicleTicketId;

    @ManyToOne
    @JoinColumn(name = "ticket_id",referencedColumnName = "id", nullable = false)
    private Tickets ticket;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;
}
