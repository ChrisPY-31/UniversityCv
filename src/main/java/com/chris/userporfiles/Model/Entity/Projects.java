package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "projects")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Projects {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_Projects")
    private Integer idProjects;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(length = 100 , nullable = false)
    private String title;

    @Column(nullable = false)
    private String image;

    @Column(nullable = false)
    private String description;

    @Column(name = "project_url")
    private String projectUrl;

    @Column(name = "start_date" , columnDefinition = "DATE")
    private LocalDate startDate;

    @Column(name = "end_date" , columnDefinition = "DATE")
    private LocalDate endDate;

    @ManyToOne
    @JoinColumn(name = "user_details_id" , referencedColumnName = "id" , insertable = false , updatable = false)
    private UserDetails userDetails;

    @OneToMany(mappedBy = "project")
    private List<Aptitudes> aptitudes;
}
