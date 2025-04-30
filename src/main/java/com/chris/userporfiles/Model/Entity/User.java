package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "username" , nullable = false , length = 20)
    private String userName;

    @Column(nullable = false , length = 200)
    private String password;

    @Column(length = 50)
    private String email;

    @Column(nullable = false , columnDefinition = "SMALLINT")
    private Boolean locked;

    @Column(nullable = false , columnDefinition = "SMALLINT")
    private Boolean disabled;

    @OneToOne
    @JoinColumn(name = "user_id" , referencedColumnName = "id" , insertable = false , updatable = false)
    private UserDetails userDetails;
}
