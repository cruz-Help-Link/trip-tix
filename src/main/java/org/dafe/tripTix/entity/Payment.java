package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "payment")
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "reference")
    private String reference;

    @Column(name = "amount")
    private BigDecimal amount;

    @Column(name = "gateway_response")
    private String gatewayResponse;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking bookings;
}
