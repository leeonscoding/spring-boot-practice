package com.leeonscoding.fileuploaddownload;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class StorageServiceImpl implements StorageService{

    @Value("${storage.upload.path}")
    private String path;

    @Bean
    @Override
    public void init() {
        Path uploadPath = Paths.get(path);

        if(Files.notExists(uploadPath)) {
            try {
                Files.createDirectories(uploadPath);
            } catch (IOException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    @Override
    public String store(MultipartFile file) {
        init();
        String fileName = file.getOriginalFilename();
        try (
                InputStream inputStream = file.getInputStream()
        ) {
            Path filePath = getRootPath().resolve(fileName);

            Files.copy(inputStream, filePath, StandardCopyOption.REPLACE_EXISTING);

            return filePath.toString();

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

        return "/";
    }

    @Override
    public Path getRootPath() {
        return Paths.get(path);
    }

    @Override
    public List<FileInfo> loadAll() {
        try {
            return Files.list(getRootPath())
                    .map(file -> new FileInfo(file.toString()))
                    .collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public String load(String fileName) {
        Path filePath = getRootPath().resolve(fileName);
        if(Files.exists(filePath)) {
            return filePath.toString();
        }
        return "/";
    }

    @Override
    public Resource loadFileAsResource(String fileName) throws IOException {
        Path filePath = getRootPath().resolve(fileName);
        if(Files.exists(filePath)) {
            return new UrlResource(filePath.toUri());
        } else {
            throw new IOException("File not found");
        }
    }

}
