package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Entity.StudentDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentDetailsService {


    Page<StudentDetails> finAllStudents(Pageable pageable);

    StudentDetails saveStudent(StudentDetails studentDetails);

    List<StudentDetails> findAllNameAndLastname(String name , String lastName);

    void deleteStudent(StudentDetails studentDetails);

    List<StudentDetails> studentCareer(String careerName);
}
