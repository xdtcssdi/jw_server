package com.jw.service;

import org.springframework.web.multipart.MultipartFile;

public interface IFileService {
    boolean batchImportUser(String fileName, MultipartFile file) throws Exception;
    boolean batchImportStudent(String fileName, MultipartFile file) throws Exception;
    boolean batchImportTeacher(String fileName, MultipartFile file) throws Exception;
    boolean batchImportExam(String fileName, MultipartFile file) throws Exception;
}
