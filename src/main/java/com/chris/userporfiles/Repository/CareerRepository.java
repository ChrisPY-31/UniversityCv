package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Career;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareerRepository extends ListCrudRepository<Career, Integer> {
}
