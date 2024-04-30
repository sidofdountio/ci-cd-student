package com.sidof.schoolapp.student;

import org.apache.coyote.BadRequestException;

import java.util.List;

public interface StudentServiceDAO {
    Student saveNewStudent(Student studentToSave) throws BadRequestException;
    void editeStudent(Student studentToEdite) throws BadRequestException;
    List<Student> getAllStudent();
   void deleteStudent(Long studentId);
}