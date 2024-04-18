package com.sidof.schoolappapi.student;

import com.sidof.schoolappapi.enume.Gender;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.time.LocalDate;
import java.util.Optional;

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