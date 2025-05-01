package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.Projects;

import java.util.List;

public interface ProjectService {

    List<Projects> getAllProjects();

    Projects getProjectById(int id);

    Projects saveProject(Projects project);

    void deleteProject(Projects project);

    Boolean existsProject(Integer id);
}
