package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.SkillsMappers;
import com.chris.userporfiles.Model.Dto.SkillsDto;
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
    public SkillsDto saveSkills(SkillsDto skillsDto) {
        Skills skills = SkillsMappers.INSTANCE.toSkills(skillsDto);
        skillsRepository.save(skills);
        return skillsDto;
    }

    @Override
    public void deleteSkills(SkillsDto skillsDto) {
        Skills skills = SkillsMappers.INSTANCE.toSkills(skillsDto);
        skillsRepository.delete(skills);
    }

    @Override
    public boolean existSkills(Integer id) {
        return skillsRepository.existsById(id);
    }

    @Override
    public SkillsDto getSkillsId(Integer id) {
        return skillsRepository.findById(id).map(SkillsMappers.INSTANCE::toSkillsDto).orElse(null);
    }
}
