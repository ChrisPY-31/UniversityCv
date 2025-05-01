package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Education;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EducationRepository extends ListCrudRepository<Education, Integer> {
}
