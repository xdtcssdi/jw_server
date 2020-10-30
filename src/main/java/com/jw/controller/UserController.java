package com.jw.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.R;
import com.jw.Response;
import com.jw.entity.Student;
import com.jw.entity.Teacher;
import com.jw.entity.User;
import com.jw.service.IFileService;
import com.jw.service.IStudentService;
import com.jw.service.ITeacherService;
import com.jw.service.IUserService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author x
 * @since 2020-10-13
 */
@Api(tags = {""})
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private JavaMailSender javaMailSender;

    //这一步是获取application.properties中设置的发件人邮箱地址
    @Value("${spring.mail.username}")
    private String username;

    @Resource
    private IStudentService studentService;
    @Resource
    private ITeacherService iTeacherService;
    @Resource
    private IUserService iUserService;

    @Resource
    private IFileService fileService;

    @GetMapping("/sendMail")
    public Response sendMail2(@RequestParam(value = "to") String[] addressee, @RequestParam("body") String body) {
        try{
            //发邮件
            SimpleMailMessage message = new SimpleMailMessage();
            //发件人邮件地址(上面获取到的，也可以直接填写,string类型)
            message.setFrom(username);
            //收件人邮件地址
            message.setTo(addressee);
            //邮件主题
            message.setSubject("标题");
            //邮件正文
            message.setText(body);
            javaMailSender.send(message);
        }catch (Exception e){
            return Response.no();
        }

        return Response.yes();
    }

    @GetMapping("/userinfo")
    public Response userinfo(@RequestParam("username") String username, @RequestParam("type") String type) {
        if (type.equals("jw")) {
            if (username != null) {
                LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
                userLambdaQueryWrapper.eq(User::getName, username);
                User s = iUserService.getOne(userLambdaQueryWrapper);
                if (s != null)
                    return Response.yes(s);
                return Response.no("获取用户信息失败");
            }
        }
        if (type.equals("teacher")) {
            if (username != null) {
                LambdaQueryWrapper<Teacher> teacherLambdaQueryWrapper = new LambdaQueryWrapper<>();
                teacherLambdaQueryWrapper.eq(Teacher::getUsername, username);
                Teacher t = iTeacherService.getOne(teacherLambdaQueryWrapper);
                if (t != null)
                    return Response.yes(t);
                return Response.no("获取用户信息失败");
            }
        }
        if (type.equals("student")) {
            if (username != null) {
                LambdaQueryWrapper<Student> studentLambdaQueryWrapper = new LambdaQueryWrapper<>();
                studentLambdaQueryWrapper.eq(Student::getUsername, username);
                Student st = studentService.getOne(studentLambdaQueryWrapper);
                if (st != null)
                    return Response.yes(st);
                return Response.no("获取用户信息失败");
            }
        }
        return Response.no();
    }


    @GetMapping("/login")
    public Response login(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          @RequestParam("type") String type) {

        if ("student".equals(type)) {
            QueryWrapper<Student> w = new QueryWrapper<>();
            w.eq("username", username).eq("password", password);
            Student one = studentService.getOne(w);
            if (one != null)
                return Response.yes(one);
            return Response.no("登录失败");
        }
        if ("jw".equals(type)) {
            QueryWrapper<User> w = new QueryWrapper<>();
            w.eq("name", username).eq("password", password);
            User one = iUserService.getOne(w);
            if (one != null)
                return Response.yes(one);
            return Response.no("登录失败");
        }

        if ("teacher".equals(type)) {
            QueryWrapper<Teacher> w = new QueryWrapper<>();
            w.eq("username", username).eq("password", password);
            Teacher one = iTeacherService.getOne(w);
            if (one != null)
                return Response.yes(one);
            return Response.no("登录失败");
        }
        return Response.no("登录失败");
    }

    @PostMapping("/upload_make_up")
    @ResponseBody
    public boolean upload_make_up(@RequestParam("file") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = fileService.batchImportUser(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @PostMapping("/upload_student")
    @ResponseBody
    public boolean upload_student(@RequestParam("file") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = fileService.batchImportStudent(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @PostMapping("/upload_teacher")
    @ResponseBody
    public boolean upload_teacher(@RequestParam("file") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = fileService.batchImportTeacher(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }

    @PostMapping("/upload_exam")
    @ResponseBody
    public boolean upload_exam(@RequestParam("file") MultipartFile file) {
        boolean a = false;
        String fileName = file.getOriginalFilename();
        try {
            a = fileService.batchImportExam(fileName, file);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return a;
    }


}
