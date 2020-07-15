package org.liko.improvement.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
public class EasyExcelController {

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        User user = new User("liko", "liko");
        User user1 = new User("test", "test");
        List<User> userList = Arrays.asList(user, user1);


        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        String fileName = URLEncoder.encode("测试", "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
        EasyExcel.write(response.getOutputStream(), User.class)
                .sheet("test")
                .doWrite(userList);

//
//        // 这里注意 有同学反应使用swagger 会导致各种问题，请直接用浏览器或者用postman
//        response.setContentType("application/vnd.ms-excel");
//        response.setCharacterEncoding("utf-8");
//        // 这里URLEncoder.encode可以防止中文乱码 当然和easyexcel没有关系
//        String fileName = URLEncoder.encode("测试", "UTF-8");
//        response.setHeader("Content-disposition", "attachment;filename=" + fileName + ".xlsx");
//        EasyExcel.write(response.getOutputStream(), DownloadData.class).sheet("模板").doWrite(data());

    }

    @RequestMapping("/test")
    public void test() {

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String username;
    private String password;
}
