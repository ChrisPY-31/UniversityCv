package com.chris.userporfiles.Service.Impl;


import com.chris.userporfiles.Mappers.StudentDetailMappers;
import com.chris.userporfiles.Mappers.StudentMappers;
import com.chris.userporfiles.Model.Dto.StudentDetailDto;
import com.chris.userporfiles.Model.Dto.StudentDto;
import com.chris.userporfiles.Model.Entity.StudentDetails;
import com.chris.userporfiles.Repository.StudentDetailsPaginationRepository;
import com.chris.userporfiles.Repository.StudentDetailsRepository;
import com.chris.userporfiles.Service.StudentDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    public Page<StudentDto> getAllStudents(int page , int size) {
        Pageable pageStudents = PageRequest.of(page, size);
        return studentDetailsPaginationRepository.findAll(pageStudents).map(StudentMappers.INSTANCE::toStudentDto);
    }

    @Override
    public Boolean existStudent(Integer id) {
        return studentDetailsRepository.existsById(id);
    }

    @Override
    public StudentDetailDto getStudentById(int id) {
        return studentDetailsRepository
                .findById(id)
                .map(StudentDetailMappers.INSTANCE::toStudentDetailDto)
                .orElse(null);
    }

    @Override
    public StudentDetailDto saveStudent(StudentDetailDto studentDetailDto) {
        StudentDetails studentDetails = StudentDetailMappers.INSTANCE.toStudentDetails(studentDetailDto);
        studentDetailsRepository.save(studentDetails);
        return studentDetailDto;
    }

    @Override
    public List<StudentDto> getAllNameAndLastname(String name, String lastName) {
        return studentDetailsRepository
                .findAllByNameOrLastName(name, lastName)
                .stream()
                .map(StudentMappers.INSTANCE::toStudentDto)
                .toList();
       // return List.of();
    }

    @Override
    public void deleteStudent(StudentDetailDto studentDetailDto) {
        StudentDetails studentDetails = StudentDetailMappers.INSTANCE.toStudentDetails(studentDetailDto);
        studentDetailsRepository.delete(studentDetails);
    }

    @Override
    public List<StudentDetails> studentCareer(String careerName) {
        return studentDetailsRepository.findAllByCareerCareerName(careerName);
        //return List.of();
    }


}
