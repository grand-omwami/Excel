package com.Dsfx.ExcelUpload.Service;

import com.Dsfx.ExcelUpload.Model.Files;
import com.Dsfx.ExcelUpload.Repository.FilesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class FilesStorageService {

    private final FilesRepository filesRepository;

    @Autowired
    public FilesStorageService(FilesRepository filesRepository) {
        this.filesRepository = filesRepository;
    }

    public Files store(MultipartFile file) throws IOException {
        if (file == null || file.isEmpty()) {
            throw new IllegalArgumentException("File cannot be null or empty");
        }

        String fileName = StringUtils.cleanPath(Objects.requireNonNull(file.getOriginalFilename()));
        Files fileDB = new Files(fileName, file.getContentType(), file.getBytes());

        return filesRepository.save(fileDB);
    }

    public Files getFile(String id) {
        Optional<Files> fileOptional = filesRepository.findById(id);
        if (fileOptional.isPresent()) {
            return fileOptional.get();
        } else {
            throw new RuntimeException("File not found with id: " + id);
        }
    }

    public Stream<Files> getAllFiles() {
        return filesRepository.findAll().stream();
    }
}
