package com.strongculture.service.service.common;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class FileServiceImpl implements FileService{
    @Override
    public String fileUpload(String path, MultipartFile file) {
        return "";
    }
}
