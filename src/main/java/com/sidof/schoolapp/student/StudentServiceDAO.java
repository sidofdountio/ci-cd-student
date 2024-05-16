package com.sidof.schoolapp.student;

import com.sidof.schoolapp.model.Student;
import org.apache.coyote.BadRequestException;

import java.util.List;

public interface StudentServiceDAO {
    Student saveNewStudent(Student studentToSave) throws BadRequestException;
    Student getStudentById(Long id) ;
    void editeStudent(Student studentToEdite) throws BadRequestException;
    List<Student> getAllStudent();
   void deleteStudent(Long studentId);
}