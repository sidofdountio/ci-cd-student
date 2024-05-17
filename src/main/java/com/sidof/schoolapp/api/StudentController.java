package com.sidof.schoolapp.api;

import com.sidof.schoolapp.model.Student;
import com.sidof.schoolapp.student.StudentService;
import lombok.AllArgsConstructor;
import org.apache.coyote.BadRequestException;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;
import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.IMAGE_PNG_VALUE;

@RestController
@RequestMapping("/api/v1/school")
@CrossOrigin(origins = "*", maxAge = 3600, allowedHeaders = "*")
@AllArgsConstructor
public class StudentController {
    //    private static final String DIRECTORY = System.getProperty("user.home") + "/Downloads/profile";
    private static final String DIRECTORY = "upload/";
    private final StudentService studentService;

    @GetMapping
    public String hello() throws BadRequestException {
        return "hello devOps";
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> students() {
        List<Student> allStudent = studentService.getAllStudent();
        System.out.println();
        return new ResponseEntity<>(allStudent, OK);
    }

    @GetMapping("/student/{id}")
    public ResponseEntity<Student> getStudent(@PathVariable("id") Long id) {
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<Student>(student, OK);
    }

    @PostMapping
    public ResponseEntity<Student> add(@RequestBody Student student) throws BadRequestException {
        Student savedNewStudent = studentService.saveNewStudent(student);

        return new ResponseEntity<>(savedNewStudent, CREATED);
    }

    @PostMapping("/upload/{id}")
    public ResponseEntity<String> uploadStudentImageUrl(@RequestParam("file") MultipartFile multipartFile,
                                                        @PathVariable("id") Long id) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Path fileStorage = Paths.get(DIRECTORY, fileName).toAbsolutePath().normalize();
        Files.copy(multipartFile.getInputStream(), fileStorage, REPLACE_EXISTING);
        Student student = studentService.getStudentById(id);
        String profileImage = getProfileImage(fileName);
        student.setImageUrl(profileImage);
        studentService.editeStudent(student);
        return ResponseEntity.ok().body(fileName);
    }

    @GetMapping(path = "/image/{imageUrl}", produces = IMAGE_PNG_VALUE)
    public byte[] getImage(@PathVariable("imageUrl") String imageUrl) throws IOException {
        return Files.readAllBytes(Paths.get(DIRECTORY + "/" + imageUrl));
    }

    @GetMapping(path = "/image", produces = IMAGE_PNG_VALUE)
    public byte[] image(@PathVariable("imageUrl") String imageUrl) throws IOException {
        return Files.readAllBytes(Paths.get(DIRECTORY + "/" + imageUrl));
    }

    private String getProfileImage(String fileName) {
//        list
        return ServletUriComponentsBuilder.fromCurrentContextPath().path("/api/v1/school/image/"+fileName).toUriString();
    }
}
