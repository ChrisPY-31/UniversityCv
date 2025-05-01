package com.chris.userporfiles.Service.Impl;

import com.chris.userporfiles.Model.Entity.Projects;
import com.chris.userporfiles.Repository.ProjectsRepository;
import com.chris.userporfiles.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProjectImpl implements ProjectService {

    @Autowired
    private ProjectsRepository projectsRepository;

    @Override
    public List<Projects> getAllProjects() {
        return projectsRepository.findAll();
    }

    @Override
    public Projects getProjectById(int id) {
        return projectsRepository.findById(id).orElse(null);
    }

    @Override
    public Projects saveProject(Projects project) {
        return projectsRepository.save(project);
    }

    @Override
    public void deleteProject(Projects project) {
        projectsRepository.delete(project);
    }

    @Override
    public Boolean existsProject(Integer id) {
        return projectsRepository.existsById(id);
    }


}
