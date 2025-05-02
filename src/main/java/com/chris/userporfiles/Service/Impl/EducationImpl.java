package com.chris.userporfiles.Service.Impl;

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
    public Education saveEducation(Education education) {
        return educationRepository.save(education);
    }

    @Override
    public void deleteEducation(Education education) {
        educationRepository.delete(education);
    }

    @Override
    public boolean existsEducation(Integer id) {
        return educationRepository.existsById(id);
    }

    @Override
    public Education getEducationId(Integer id) {
        return educationRepository.findById(id).orElse(null);
    }
}
