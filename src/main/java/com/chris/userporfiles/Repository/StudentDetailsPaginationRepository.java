package com.chris.userporfiles.Repository;


import com.chris.userporfiles.Model.Entity.StudentDetails;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentDetailsPaginationRepository extends PagingAndSortingRepository<StudentDetails , Integer> {

}
