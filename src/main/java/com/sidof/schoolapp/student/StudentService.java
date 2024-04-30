package com.sidof.schoolapp.student;

import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService implements StudentServiceDAO{
    @Autowired
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public Student saveNewStudent(Student student) throws BadRequestException {
        Boolean existsEmail = studentRepository.selectExistsEmail(student.getEmail());
        if(existsEmail){
            throw new BadRequestException("Email "+student.getEmail()+" taken");
        }
        return studentRepository.save(student);
    }

    @Override
    public void editeStudent(Student studentToEdit) throws BadRequestException {
        // Retrieve the existing student from the database using the student's ID
        Student existingStudent = studentRepository.findById(studentToEdit.getId())
                .orElseThrow(() -> new IllegalArgumentException("Student not found"));
       studentRepository.save(existingStudent);

    }

    @Override
    public List<Student> getAllStudent() {
        return studentRepository.findAll();
    }

    @Override
    public void deleteStudent(Long studentId) {
        if(!studentRepository.existsById(studentId)){
            throw new NullPointerException("student with "+ studentId + " not found");
        }
        studentRepository.deleteById(studentId);
    }
}
