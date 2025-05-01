package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "student_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_id")
    private Integer idUser;

    @Column(name = "career_id")
    private Integer idCareer;

    @Column(length = 100 , nullable = false)
    private String name;

    @Column(name = "last_name" , nullable = false)
    private String lastName;

    private String image;

    @Column(length = 100)
    private String titular;

    @Column(length = 100)
    private String location;

    @Column(length = 100)
    private String holder;

    @Column(name = "birth_date")
    private String birthDate;

    @Column(length = 100)
    private String description;

    @Column(length = 100)
    private String position;

    private String curriculum;

    @Column(columnDefinition = "DATE")
    private LocalDateTime updated ;

    @Column(name = "created_at" , columnDefinition = "DATE")
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "studentDetails")
    private User user;

    @OneToMany(mappedBy = "studentDetails")
    private List<SocialMedia> socialMedia;

    @OneToMany(mappedBy = "studentDetails")
    private List<Education> education;

    @OneToMany(mappedBy = "studentDetails")
    private List<Languages> languages;

    @OneToMany(mappedBy = "studentDetails")
    private List<Projects> projects;

    @OneToMany(mappedBy = "studentDetails")
    private List<Skills> skills;

    @OneToOne
    @JoinColumn(name = "user_details_id" , referencedColumnName = "id" , insertable = false, updatable = false)
    private Career career;

}
