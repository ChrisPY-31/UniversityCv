package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Projects;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectsRepository extends ListCrudRepository<Projects , Integer> {
}
