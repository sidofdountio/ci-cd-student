package com.sidof.schoolapp.student;

import com.sidof.schoolapp.enume.Gender;
import com.sidof.schoolapp.model.Student;
import com.sidof.schoolapp.repo.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {
    @Autowired
    private StudentRepository underTest;

    @AfterEach
    void tearDown() {
        underTest.deleteAll();
    }

    @Test
    void selectExistEmail(){
//        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
//        When
        underTest.save(student);
//        Then
        boolean existsEmail = underTest.selectExistsEmail(student.getEmail());
        assertThat(existsEmail).isTrue();
    }
}