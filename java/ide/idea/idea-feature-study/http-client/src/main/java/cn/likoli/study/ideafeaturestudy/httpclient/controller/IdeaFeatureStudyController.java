package cn.likoli.study.ideafeaturestudy.httpclient.controller;

import org.springframework.web.bind.annotation.*;

/**
 * IdeaFeatureStudyController
 *
 * @author liko
 * @date 2020/8/27
 */
@RestController
public class IdeaFeatureStudyController {

    @GetMapping("/api/json/get")
    public String test1(@RequestParam("id") String id, @RequestBody String key) {
        return String.format("Receive data id = {%s}, key = {%s}", id, key);
    }

}
