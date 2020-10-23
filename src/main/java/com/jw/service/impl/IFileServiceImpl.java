package com.jw.service.impl;

import com.jw.entity.Exam;
import com.jw.entity.MakeupExam;
import com.jw.entity.Student;
import com.jw.entity.Teacher;
import com.jw.service.*;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.Date;
import java.util.Objects;

@Service
public class IFileServiceImpl implements IFileService {
    @Autowired
    private IMakeupExamService makeupExamService;
    @Autowired
    private IStudentService studentService;
    @Autowired
    private ITeacherService teacherService;
    @Autowired
    private IExamService examService;

    @Override
    public boolean batchImportUser(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        for (int r = 0; r <= Objects.requireNonNull(sheet).getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }
            int examId = (int) row.getCell(0).getNumericCellValue();
            String subject = row.getCell(1).getStringCellValue();
            int studentId = (int) row.getCell(2).getNumericCellValue();
            String req = row.getCell(3).getStringCellValue();
            Date stime = row.getCell(4).getDateCellValue();
            Date etime = row.getCell(5).getDateCellValue();
            System.out.println(examId + " " + subject + " " + studentId + " " + req + " " + stime + " " + etime);
//            System.out.println(row.getCell(0).getStringCellValue());
            MakeupExam exam = new MakeupExam();
            exam.setExamId(examId);
            exam.setClasses(subject);
            exam.setSTime(stime);
            exam.setETime(etime);
            exam.setStudentId(studentId);
            exam.setReq(req);
            makeupExamService.add(exam);
        }

        return notNull;
    }

    @Override
    public boolean batchImportStudent(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        for (int r = 0; r <= Objects.requireNonNull(sheet).getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String phone = "" + (int)row.getCell(2).getNumericCellValue();
            String email = row.getCell(3).getStringCellValue();

            System.out.println(username + " " + password + " " + phone + " " + email);

            Student student = new Student();
            student.setEmail(email);
            student.setPassword(password);
            student.setPhone(phone);
            student.setUsername(username);
            studentService.add(student);
        }

        return notNull;
    }

    @Override
    public boolean batchImportTeacher(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        for (int r = 0; r <= Objects.requireNonNull(sheet).getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            String username = row.getCell(0).getStringCellValue();
            String password = row.getCell(1).getStringCellValue();
            String subject = row.getCell(2).getStringCellValue();
            String phone = "" + (int)row.getCell(3).getNumericCellValue();
            String email = row.getCell(4).getStringCellValue();

            System.out.println(username + " " + password + " " + subject + " " + phone + " " + email);

            Teacher teacher = new Teacher();
            teacher.setEmail(email);
            teacher.setPassword(password);
            teacher.setPhone(phone);
            teacher.setUsername(username);
            teacher.setSubject(subject);
            teacherService.add(teacher);
        }

        return notNull;    }

    @Override
    public boolean batchImportExam(String fileName, MultipartFile file) throws Exception {
        boolean notNull = false;

        if (!fileName.matches("^.+\\.(?i)(xls)$") && !fileName.matches("^.+\\.(?i)(xlsx)$")) {
            throw new Exception("上传文件格式不正确");
        }
        boolean isExcel2003 = true;
        if (fileName.matches("^.+\\.(?i)(xlsx)$")) {
            isExcel2003 = false;
        }
        InputStream is = file.getInputStream();
        Workbook wb = null;
        if (isExcel2003) {
            wb = new HSSFWorkbook(is);
        } else {
            wb = new XSSFWorkbook(is);
        }
        Sheet sheet = wb.getSheetAt(0);
        if(sheet!=null){
            notNull = true;
        }

        for (int r = 0; r <= Objects.requireNonNull(sheet).getLastRowNum(); r++) {
            Row row = sheet.getRow(r);
            if (row == null){
                continue;
            }

            int examid = (int)row.getCell(1).getNumericCellValue();
            int teacherid = (int)row.getCell(2).getNumericCellValue();

            Exam exam = new Exam();
            exam.setExamId(examid);
            exam.setTeacherId(teacherid);
            examService.add(exam);
        }

        return notNull;
    }
}
