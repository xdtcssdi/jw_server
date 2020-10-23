package com.jw;

import java.net.URL;
import java.util.List;

import com.jw.entity.MakeupExamUName;
import com.jw.mapper.MakeupExamMapper;
import com.jw.service.MailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @desciption 用户管理测试类
 * @author ChenXiHua
 * @date 2019年2月19日
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = JwApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserTest {

    /**
     * @LocalServerPort 提供了 @Value("${local.server.port}") 的代替
     */
    @LocalServerPort
    private int port;

    private URL base;

    @Autowired
    private TestRestTemplate restTemplate;

    @Before
    public void setUp() throws Exception {
        String url = String.format("http://localhost:%d/", port);
        System.out.println(String.format("port is : [%d]", port));
        this.base = new URL(url);
    }

    @Autowired
    private MakeupExamMapper mapper;

    /**
     * 向"/test"地址发送请求，并打印返回结果
     * @throws Exception
     */
    @Test
    public void test1() throws Exception {
        List<MakeupExamUName> makeupExams = mapper.selectByMyWrapper(1, 1);
        System.out.println(makeupExams);
    }
}