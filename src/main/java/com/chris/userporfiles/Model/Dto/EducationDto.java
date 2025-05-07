package com.chris.userporfiles.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EducationDto {

    private Integer id;

    private Integer idUserDetails;

    private String name;

    private LocalDateTime dateStart;

    private LocalDateTime dateEnd;



}
