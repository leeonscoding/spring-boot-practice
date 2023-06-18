package com.leeonscoding.fileuploaddownload;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

public interface StorageService {
    void init();
    String store(MultipartFile file);
    Path getRootPath();
    List<FileInfo> loadAll();
    String load(String fileName);
    Resource loadFileAsResource(String fileName) throws IOException;
}
