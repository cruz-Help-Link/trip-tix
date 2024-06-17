package org.dafe.tripTix.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;






@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "token")
public class UserToken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userTokenId;

    @Column(name = "tokenId")
    private String tokenId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    // Getters and setters
}