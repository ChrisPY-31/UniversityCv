package com.chris.userporfiles.Model.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "social_media")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SocialMedia {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "user_details_id")
    private Integer idUserDetails;

    @Column(name = "platform_name")
    private String paftformName;

    @Column(name = "social_image")
    private String socialImage;

    @Column(name = "porfile_url")
    private String porfileUrl;

    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "user_details_id" , referencedColumnName = "id" , insertable = false, updatable = false )
    private StudentDetails studentDetails;

}
