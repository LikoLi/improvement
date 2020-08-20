package cn.liko.newproject.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloController
 *
 * @author liko
 * @date 2020/6/20
 */
@RestController
public class HelloController {

    public static final String HELLO_WORLD = "Hello World!";

    @GetMapping("/")
    public String index() {
        return HELLO_WORLD;
    }
}
