package com.chris.userporfiles.Repository;

import com.chris.userporfiles.Model.Entity.Languages;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguajesRepository extends ListCrudRepository<Languages, Integer> {
}
