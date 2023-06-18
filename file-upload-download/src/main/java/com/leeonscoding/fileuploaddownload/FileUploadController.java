package com.leeonscoding.fileuploaddownload;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class FileUploadController {

    @Autowired
    private StorageService storageService;

    @PostMapping("/upload")
    public ResponseEntity<FileUploadResponse> uploadFiles(@RequestParam("file1") MultipartFile[] multipartFile) {

        List<String> files = Stream.of(multipartFile)
                .map(file -> storageService.store(file))
                .collect(Collectors.toList());

        FileUploadResponse fileUploadResponse = new FileUploadResponse(files);

        return new ResponseEntity<>(fileUploadResponse, HttpStatus.OK);
    }

    @GetMapping("/files")
    public ResponseEntity<List<FileInfo>> getAllFiles() {
        return new ResponseEntity<>(storageService.loadAll(), HttpStatus.OK);
    }

    @GetMapping("/file/{fileName}")
    public ResponseEntity<FileInfo> getFile(@PathVariable String fileName) {
        return new ResponseEntity<>(new FileInfo(storageService.load(fileName)), HttpStatus.OK);
    }

    @GetMapping("/download/{fileName}")
    public ResponseEntity<Resource> downloadFile(@PathVariable String fileName) throws IOException {
        Resource file = storageService.loadFileAsResource(fileName);

        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_OCTET_STREAM)
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFilename() + "\"")
                .body(file);
    }
}
