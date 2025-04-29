package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "education")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Education {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(nullable = false , length = 100)
    private String name;

    private String image;

    @Column(name = "start_date" , columnDefinition = "DATE")
    private LocalDateTime startDate;

    @Column(name = "end_date" , columnDefinition = "DATE")
    private LocalDateTime endDate;

}
