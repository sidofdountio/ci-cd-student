package com.sidof.schoolappapi.api;

import com.sidof.schoolappapi.student.StudentService;
import org.apache.coyote.BadRequestException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class StudentControllerTest {
    @Mock
    private StudentService studentService;
    private StudentController underTest;


    @BeforeEach
    void setUp() {
        underTest = new StudentController(studentService);
    }

    @Test
    void hello() throws BadRequestException {
//        given
//        when
//        then
        String hello = underTest.hello();
//        assertThat(hello).isEqualTo("hello DevOps");
        verify(studentService).getAllStudent();
    }
}