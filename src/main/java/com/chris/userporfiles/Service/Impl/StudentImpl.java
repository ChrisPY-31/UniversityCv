package com.chris.userporfiles.Service.Impl;


import com.chris.userporfiles.Model.Entity.StudentDetails;
import com.chris.userporfiles.Repository.StudentDetailsPaginationRepository;
import com.chris.userporfiles.Repository.StudentDetailsRepository;
import com.chris.userporfiles.Service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentImpl implements StudentDetailsService {

    @Autowired
    private StudentDetailsRepository studentDetailsRepository;

    @Autowired
    private StudentDetailsPaginationRepository studentDetailsPaginationRepository;

    @Override
    public Page<StudentDetails> getAllStudents(Pageable pageable) {
        return studentDetailsPaginationRepository.findAll(pageable);
    }

    @Override
    public StudentDetails saveStudent(StudentDetails studentDetails) {
        return studentDetailsRepository.save(studentDetails);
    }

    @Override
    public List<StudentDetails> getAllNameAndLastname(String name, String lastName) {
        return studentDetailsRepository.findAllByNameOrLastName(name, lastName);
       // return List.of();
    }

    @Override
    public void deleteStudent(StudentDetails studentDetails) {
        studentDetailsRepository.delete(studentDetails);
    }

    @Override
    public List<StudentDetails> studentCareer(String careerName) {
        return studentDetailsRepository.findAllByCareerCareerName(careerName);
        //return List.of();
    }


}
