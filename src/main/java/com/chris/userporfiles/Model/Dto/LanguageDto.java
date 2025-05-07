package com.chris.userporfiles.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class LanguageDto {

    private Integer id;

    private Integer idUserDetails;

    private String name;

    private String nivel;


}
