package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.ProjectsDto;
import com.chris.userporfiles.Model.Entity.Projects;

import java.util.List;

public interface ProjectService {

    List<ProjectsDto> getAllProjects();

    ProjectsDto getProjectById(int id);

    ProjectsDto saveProject(ProjectsDto projectDto);

    void deleteProject(ProjectsDto projectDto);

    Boolean existsProject(Integer id);
}
