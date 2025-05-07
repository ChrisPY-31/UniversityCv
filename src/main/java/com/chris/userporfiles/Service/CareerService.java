package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.CareerDto;
import com.chris.userporfiles.Model.Entity.Career;

public interface CareerService {

    CareerDto careerId(Integer id);

    CareerDto saveCareer(CareerDto careerDto);

    boolean existCareer(Integer id);

    void deleteCareer(CareerDto careerDto);
}
