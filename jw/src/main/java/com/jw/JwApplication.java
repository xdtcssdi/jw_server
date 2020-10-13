package com.jw;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.jw.mapper")
public class JwApplication {
    public static void main(String[] args) {
        String[] argument = new String[args.length + 2];
        System.setProperty("spring.devtools.restart.enabled", "false");
        System.arraycopy(args, 0, argument, 0, args.length);

        argument[args.length] = "--async.log.level=INFO";
        argument[args.length + 1] = "--async.log.output=console";

        try {
            SpringApplication.run(JwApplication.class, args);
        }catch (Exception e){
            e.printStackTrace();
        }

    }

}
