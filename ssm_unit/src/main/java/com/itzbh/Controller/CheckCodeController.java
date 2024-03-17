package com.itzbh.Controller;

import com.itzbh.util.CheckCodeUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@RestController
@RequestMapping("/codes")
public class CheckCodeController {
    @GetMapping("/generateCheckCode")
    @ResponseBody
    public void generateCheckCode(HttpServletResponse response, HttpSession session) throws IOException {
        String code = CheckCodeUtil.outputVerifyImage(100, 50, response.getOutputStream(), 4);
        session.setAttribute("checkcodegen", code);
    }
}
