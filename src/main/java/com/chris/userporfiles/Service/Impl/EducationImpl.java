package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.EducationMappers;
import com.chris.userporfiles.Model.Dto.EducationDto;
import com.chris.userporfiles.Model.Entity.Education;
import com.chris.userporfiles.Repository.EducationRepository;
import com.chris.userporfiles.Service.EducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EducationImpl implements EducationService {

    @Autowired
    private EducationRepository educationRepository;

    @Override
    public EducationDto saveEducation(EducationDto educationDto) {
        Education education = EducationMappers.INSTANCE.toEducation(educationDto);
        educationRepository.save(education);
        return educationDto;
    }

    @Override
    public void deleteEducation(EducationDto educationDto) {
        Education education = EducationMappers.INSTANCE.toEducation(educationDto);
        educationRepository.delete(education);
    }

    @Override
    public boolean existsEducation(Integer id) {
        return educationRepository.existsById(id);
    }

    @Override
    public EducationDto getEducationId(Integer id) {
        return educationRepository.findById(id).map(EducationMappers.INSTANCE::toEducationDto).orElse(null);
    }
}
