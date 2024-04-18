package com.sidof.schoolapp.student;

import com.sidof.schoolapp.enume.Gender;

public class StudentDTO {
    private String lastName;
    private String email;
    private Gender gender;

    public StudentDTO(String lastName, String email, Gender gender) {
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Student studentFormed(StudentDTO studentDTO){
        var student = new Student();
        student.setLastName(studentDTO.getLastName());
        student.setEmail(studentDTO.getEmail());
        student.setGender(studentDTO.getGender());
        return student;
    }
}
