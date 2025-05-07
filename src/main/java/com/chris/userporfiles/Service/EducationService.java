package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.EducationDto;
import com.chris.userporfiles.Model.Entity.Education;

public interface EducationService {

    EducationDto saveEducation(EducationDto educationDto);

    void deleteEducation(EducationDto educationDto);

    boolean existsEducation(Integer id);

    EducationDto getEducationId(Integer id);
}
