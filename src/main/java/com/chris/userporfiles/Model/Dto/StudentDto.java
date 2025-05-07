package com.chris.userporfiles.Model.Dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer id;
    private String studentName;
    private String studentLastName;
    private String studentImage;
    private CareerDto career;


}
