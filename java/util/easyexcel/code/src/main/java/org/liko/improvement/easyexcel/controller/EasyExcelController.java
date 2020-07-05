package org.liko.improvement.easyexcel.controller;

import com.alibaba.excel.EasyExcel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EasyExcelController {

    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        List<User> userList = new ArrayList<>();
        User user = new User("liko", "liko");
        User user1 = new User("test", "test");

        response.setContentType("application/vnd.ms-excel");
        response.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=\"test.xlsx\"");
        EasyExcel.write(response.getOutputStream(), User.class)
                .autoCloseStream(Boolean.FALSE)
                .sheet("test")
                .doWrite(userList);

    }
}

@Data
@NoArgsConstructor
@AllArgsConstructor
class User {
    private String username;
    private String password;
}
