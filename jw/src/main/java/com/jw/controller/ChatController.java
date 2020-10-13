package com.jw.controller;


import com.alibaba.druid.sql.visitor.functions.Char;
import com.jw.Response;
import com.jw.entity.Chat;
import com.jw.mapper.ChatMapper;
import com.jw.service.impl.ChatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author xx
 * @since 2020-10-13
 */
@RestController
@RequestMapping("/chat")
public class ChatController {
    @Autowired
    ChatServiceImpl service;

    @GetMapping("/add")
    public Response add(@RequestParam("uid1") Integer uid1,
                        @RequestParam("uid2") Integer uid2,
                        @RequestParam("msg") String msg
                        ){
        Chat c = new Chat();
        c.setMsg(msg);
        c.setUid1(uid1);
        c.setUid2(uid2);
        service.save(c);
        return Response.no();
    }


}
