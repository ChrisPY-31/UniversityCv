package com.chris.userporfiles.Repository;


import com.chris.userporfiles.Model.Entity.StudentDetails;

import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentDetailsRepository extends ListCrudRepository<StudentDetails, Integer> {

    List<StudentDetails> findAllByNameOrLastName(String name, String lastName);

    List<StudentDetails> findAllByCareerCareerName(String career);


}
