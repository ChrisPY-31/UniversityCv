package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.CareerMappers;
import com.chris.userporfiles.Model.Dto.CareerDto;
import com.chris.userporfiles.Model.Entity.Career;
import com.chris.userporfiles.Repository.CareerRepository;
import com.chris.userporfiles.Service.CareerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CareerImpl implements CareerService {

    @Autowired
    private CareerRepository careerRepository;

    @Override
    public CareerDto careerId(Integer id) {

        return careerRepository
                .findById(id)
                .map(CareerMappers.INSTANCE::toCareerDto)
                .orElse(null);

    }

    @Override
    public CareerDto saveCareer(CareerDto careerDto) {
        Career career = CareerMappers.INSTANCE.toCareer(careerDto);
        careerRepository.save(career);
        return careerDto;
    }

    @Override
    public boolean existCareer(Integer id) {
        return careerRepository.existsById(id);
    }

    @Override
    public void deleteCareer(CareerDto careerDto) {
        careerRepository.delete(CareerMappers.INSTANCE.toCareer(careerDto));
    }
}
