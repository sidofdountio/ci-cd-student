package com.sidof.schoolappapi.student;

import com.sidof.schoolappapi.enume.Gender;
import jakarta.persistence.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
public class Student {
    @Id
    @SequenceGenerator(allocationSize = 1,name = "student_sequence")
    @GeneratedValue(strategy = SEQUENCE,generator = "student_sequence")
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String email;
    private LocalDate dob;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private String placeOfBorn;
    private String code;

    public Student(Long id, String firstName, String lastName, String email, LocalDate dob, Gender gender, String placeOfBorn, String code) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
        this.placeOfBorn = placeOfBorn;
        this.code = code;
    }
    public Student(String lastName, String email, LocalDate dob, Gender gender) {
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    public Student(Long id,String lastName, String email, LocalDate dob, Gender gender) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.dob = dob;
        this.gender = gender;
    }

    public Student() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getPlaceOfBorn() {
        return placeOfBorn;
    }

    public void setPlaceOfBorn(String placeOfBorn) {
        this.placeOfBorn = placeOfBorn;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", dob=" + dob +
                ", gender=" + gender +
                ", placeOfBorn='" + placeOfBorn + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
