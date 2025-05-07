package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.SkillsDto;

public interface SkillService {
    SkillsDto saveSkills(SkillsDto skillsDto);

    void deleteSkills(SkillsDto skillsDto);

    boolean existSkills(Integer id);

    SkillsDto getSkillsId(Integer id);

}
