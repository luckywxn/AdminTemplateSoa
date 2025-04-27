package com.strongculture.service.service.common;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    String fileUpload(@RequestParam(value = "path") String path, @RequestPart(value = "file") MultipartFile file);
}
