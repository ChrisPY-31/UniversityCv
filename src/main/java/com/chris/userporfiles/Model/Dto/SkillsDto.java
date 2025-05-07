package com.chris.userporfiles.Model.Dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SkillsDto {

    private Integer id;

    private Integer idUserDetails;

    private String name;

    private String image;

}
