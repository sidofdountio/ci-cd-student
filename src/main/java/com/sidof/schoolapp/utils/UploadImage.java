package com.sidof.schoolapp.utils;

import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static java.nio.file.StandardCopyOption.REPLACE_EXISTING;

public class UploadImage {
    private static final String DIRECTORY = "upload/";

    public static String uploadImage(MultipartFile multipartFile) throws IOException {
        String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
        Path fileStorage = Paths.get(DIRECTORY, fileName).toAbsolutePath().normalize();
        if (!Files.exists(fileStorage)) {
            Files.createDirectory(fileStorage);
        }
        Files.copy(multipartFile.getInputStream(), fileStorage, REPLACE_EXISTING);
        return fileName;
    }
}
