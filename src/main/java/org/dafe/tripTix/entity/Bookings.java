package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "bookings")
public class Bookings {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ticketId")
    private int ticketId;

    @Column(name = "userChoice", nullable = false)
    private String userChoice;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private SignUp signUp;

    @Column(name = "location_from", nullable = false)
    private String locationFrom;

    @Column(name = "location_to", nullable = false)
    private String locationTo;

    @Column(name = "trip_type", nullable = false)
    private String tripType;

    @Column(name = "departs_day", nullable = false)
    private Date departsDay;

    @Column(name = "return_day", nullable = false)
    private Date returnDay;

    @Column(name = "is_adult", nullable = false)
    private boolean isAdult;

    @Column(name = "is_child", nullable = false)
    private boolean isChild;

    // Getters and setters
}
