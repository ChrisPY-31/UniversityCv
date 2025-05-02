package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.Education;

public interface EducationService {

    Education saveEducation(Education education);

    void deleteEducation(Education education);

    boolean existsEducation(Integer id);

    Education getEducationId(Integer id);
}
