package com.chris.userporfiles.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "languages")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Languages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(nullable = false , unique = true)
    private String languaje;

    private String proficiency;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_details_id" , referencedColumnName = "id" , insertable = false, updatable = false)
    private StudentDetails studentDetails;
}
