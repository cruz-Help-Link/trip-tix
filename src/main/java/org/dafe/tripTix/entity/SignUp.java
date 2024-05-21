package org.dafe.tripTix.entity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "sign_up")
public class SignUp {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userId")
    private int userId;

    @Column(name = "fullName", nullable = false)
    private String fullName;

    @Column(name = "emailAddress", nullable = false)
    private String emailAddress;

    @Column(name = "password", nullable = false)
    private String password;
}
