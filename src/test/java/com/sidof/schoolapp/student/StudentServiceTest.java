package com.sidof.schoolapp.student;

import com.sidof.schoolapp.enume.Gender;
import com.sidof.schoolapp.model.Student;
import com.sidof.schoolapp.repo.StudentRepository;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static com.sidof.schoolapp.enume.Gender.FEMALE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {
    private StudentService underTest;
    @Mock
    private StudentRepository studentRepository;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(studentRepository);
    }

    @Test
    void canSaveNewStudent() throws BadRequestException {
//        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
//        When
        underTest.saveNewStudent(student);
//        Then
//      Argument Captor
        ArgumentCaptor<Student> studentArgumentCaptor = ArgumentCaptor.forClass(Student.class);
//        Verify that JPA save method has been invoq in our serrvice class.
        verify(studentRepository).save(studentArgumentCaptor.capture());
        Student studentArgumentCaptorValue = studentArgumentCaptor.getValue();
        assertThat(studentArgumentCaptorValue).isEqualTo(student);

    }

    @Test
    void shouldThrowExceptionIfEmailHasBeenTaken() {
    }

    @Test
    void editeStudent() throws BadRequestException {
        //        Given
        Student student = new Student(
                1L,
                "Tsasse",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
        Student studentEdited = new Student(
                1L,
                "Tsasse",
                "belviane@gmail.com",
                LocalDate.of(2008, 1, 1), FEMALE);
//        When
        given(studentRepository.findById(student.getId())).willReturn(Optional.of(student));
//        Student saved = studentRepository.save(student);
        underTest.editeStudent(student);
//        Then
        assertThat(student).isNotEqualTo(studentEdited);
//        assertNotEquals(studentEdited,student);
    }

    @Test
    void shouldThrowExcetionWhenEditeStudent() throws BadRequestException {
        //        Given
        Student student = new Student(
                1L,
                "Tsasse",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);

        given(studentRepository.findById(student.getId())).willReturn(Optional.of(student));
//        Student saved = studentRepository.save(student);
        underTest.editeStudent(student);
//        Then
    }

    @Test
    void ShouldthrownNotFoundStudentIfStudentExist() {
//        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
        given(studentRepository.selectExistsEmail(student.getEmail())).willReturn(true);
//        When
        assertThatThrownBy(() -> underTest.saveNewStudent(student))
                .isInstanceOf(BadRequestException.class)
                .hasMessageContaining("Email " + student.getEmail() + " taken");
    }

    @Test
    void canGetAllStudent() {
//        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
//        When
        underTest.getAllStudent();
//        Then
        verify(studentRepository).findAll();
    }

    @Test
    void canDeleteStudent() {
        //        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
        given(studentRepository.existsById(student.getId())).willReturn(true);
//        When
        underTest.deleteStudent(student.getId());
//        Then
     verify(studentRepository).deleteById(student.getId());
    }

    @Test
    void shouldDiplayErrorWhenDeleteStudent() {
        //        Given
        Student student = new Student(
                1L,
                "Belviane",
                "belviane@gmail.com",
                LocalDate.of(2009, 1, 1),
                Gender.FEMALE);
        given(studentRepository.existsById(student.getId())).willReturn(false);
//        When
//        Then
        assertThatThrownBy(()->underTest.deleteStudent(student.getId()))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("student with "+ student.getId() + " not found");



    }
}
