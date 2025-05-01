package com.chris.userporfiles.Model.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "skills")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Skills {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(name = "skill_name")
    private String skillName;

    private String image;

    @ManyToOne
    @JoinColumn(name = "user_details_id" , referencedColumnName = "id" , insertable = false , updatable = false)
    private StudentDetails studentDetails;
}
