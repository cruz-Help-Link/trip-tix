package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "route")
public class TransportRoute {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "origin_terminal_id")
    private Terminal originTerminal;

    @ManyToOne
    @JoinColumn(name = "destination_terminal_id")
    private Terminal destinationTerminal;

    @ManyToOne
    @JoinColumn(name = "from_state_id")
    private State fromState;
}

