package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Mappers.ProjectMappers;
import com.chris.userporfiles.Model.Dto.ProjectsDto;
import com.chris.userporfiles.Model.Entity.Projects;
import com.chris.userporfiles.Repository.ProjectsRepository;
import com.chris.userporfiles.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<ProjectsDto> getAllProjects() {
        return projectsRepository
                .findAll()
                .stream()
                .map(ProjectMappers.INSTANCE::toProjectDto)
                .collect(Collectors.toList());
    }

    @Override
    public ProjectsDto getProjectById(int id) {
        return projectsRepository.findById(id).map(ProjectMappers.INSTANCE::toProjectDto).orElse(null);
    }

    @Override
    public ProjectsDto saveProject(ProjectsDto projectDto) {
        Projects project = ProjectMappers.INSTANCE.toProjects(projectDto);
        projectsRepository.save(project);
        return projectDto;
    }

    @Override
    public void deleteProject(ProjectsDto projectDto) {
        Projects project = ProjectMappers.INSTANCE.toProjects(projectDto);
        projectsRepository.delete(project);
    }

    @Override
    public Boolean existsProject(Integer id) {
        return projectsRepository.existsById(id);
    }


}
