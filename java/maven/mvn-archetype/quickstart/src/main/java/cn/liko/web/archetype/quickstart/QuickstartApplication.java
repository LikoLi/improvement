package cn.liko.web.archetype.quickstart;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * QuickstartApplication
 *
 * @author liko
 * @date 2020/6/20
 */
@SpringBootApplication
@MapperScan("cn.liko.web.archetype.quickstart.mapper")
public class QuickstartApplication {

    public static void main(String[] args) {
        SpringApplication.run(QuickstartApplication.class, args);
    }

}

