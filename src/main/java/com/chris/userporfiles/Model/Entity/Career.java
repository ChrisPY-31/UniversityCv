package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "career")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(name = "career_name" , nullable = false , length = 50)
    private String careerName;

    @OneToOne(mappedBy = "career" )
    private StudentDetails studentDetails;
}
