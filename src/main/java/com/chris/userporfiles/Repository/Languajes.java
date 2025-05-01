package com.chris.userporfiles.Repository;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Languajes extends ListCrudRepository<Languajes , Integer> {
}
