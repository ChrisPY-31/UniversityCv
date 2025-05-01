package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Aptitudes;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AptitudesRepository extends ListCrudRepository<Aptitudes , Integer> {
}
