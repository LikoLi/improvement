package cn.likoli.springframework.security.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * DemoController
 *
 * @author liko
 * @date 2020/8/11
 */
@Slf4j
@Controller
@RequestMapping("/demo")
public class DemoController {

    @GetMapping
    @ResponseBody
    public String index() {
        log.info("index in");
        return "Welcome to learn Spring Security!";
    }
}
