package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Model.Entity.Skills;
import com.chris.userporfiles.Repository.SkillsRepository;
import com.chris.userporfiles.Service.SkillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SkillsImpl implements SkillService {

    @Autowired
    private SkillsRepository skillsRepository;

    @Override
    public Skills saveSkills(Skills skills) {
        return skillsRepository.save(skills);
    }

    @Override
    public void deleteSkills(Skills skills) {
        skillsRepository.delete(skills);
    }

    @Override
    public boolean existSkills(Integer id) {
        return skillsRepository.existsById(id);
    }

    @Override
    public Skills getSkillsId(Integer id) {
        return skillsRepository.findById(id).orElse(null);
    }
}
