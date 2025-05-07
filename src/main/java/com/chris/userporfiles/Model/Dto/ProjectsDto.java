package com.chris.userporfiles.Model.Dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectsDto {
    private Integer id;

    private Integer idUserDetails;

    private String name;

    private String image;

    private String description;

    private String urlProject;

    private LocalDate dateStart;

    private LocalDate dateEnd;

    private List<AptitudesDto> aptitudes;

}
