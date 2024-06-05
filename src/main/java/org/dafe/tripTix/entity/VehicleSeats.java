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
@Table(name = "vehicle_seat")
public class VehicleSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int vehicleSeatId;

    @ManyToOne
    @JoinColumn(name = "vehicle_id",referencedColumnName = "id", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "ticket_id",referencedColumnName = "id", nullable = false)
    private Tickets ticket;

    @ManyToOne
    @JoinColumn(name = "seat_id",referencedColumnName = "id", nullable = false)
    private Seats seat;
}
