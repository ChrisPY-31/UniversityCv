package com.chris.userporfiles.Service;

import com.chris.userporfiles.Model.Dto.StudentDetailDto;
import com.chris.userporfiles.Model.Dto.StudentDto;
import com.chris.userporfiles.Model.Entity.StudentDetails;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;


public interface StudentDetailsService {

    Page<StudentDto> getAllStudents(int page , int size);

    Boolean existStudent(Integer id);

    StudentDetailDto getStudentById(int id);

    StudentDetailDto saveStudent(StudentDetailDto studentDetailsDto);

    List<StudentDto> getAllNameAndLastname(String name , String lastName);

    void deleteStudent(StudentDetailDto studentDetailDto);

    List<StudentDetails> studentCareer(String careerName);
}
