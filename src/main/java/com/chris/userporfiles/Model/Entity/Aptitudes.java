package com.chris.userporfiles.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "aptitudes")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aptitudes {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "id_project")
    private Integer idProject;

    @Column(length = 50 , nullable = false)
    private String name;

    @ManyToOne
    @JoinColumn(name = "id_project" , referencedColumnName = "id_Projects" , insertable = false , updatable = false)
    @JsonIgnore
    private Projects project;
}
