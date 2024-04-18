package com.sidof.schoolappapi.api;

import com.sidof.schoolappapi.enume.Gender;
import com.sidof.schoolappapi.student.Student;
import com.sidof.schoolappapi.student.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

@RestController
@RequestMapping("/api/v1/school")
@CrossOrigin(origins = "*", maxAge = 3600,allowedHeaders = "*")
@AllArgsConstructor
public class StudentController {                                                            

    private  final  StudentService studentService;

    @GetMapping
    public String hello() throws BadRequestException {
        return "hello devOps";
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> students() {
        List<Student> allStudent = studentService.getAllStudent();
        return new ResponseEntity<>(allStudent,OK);
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student ) throws BadRequestException {
        Student savedNewStudent = studentService.saveNewStudent(student);
        return new ResponseEntity<>(savedNewStudent,CREATED);
    }
}
