package com.sidof.schoolapp.model;

import com.sidof.schoolapp.enume.Gender;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
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
    private String imageUrl;

}
