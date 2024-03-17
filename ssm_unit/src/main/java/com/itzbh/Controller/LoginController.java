package com.itzbh.Controller;

import com.itzbh.domain.User;
import com.itzbh.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    UserService userService;
    @PostMapping("/loginjudge")
    public Result login( @RequestBody User user, @RequestParam(required = false) boolean remember,HttpSession session, HttpServletRequest request, HttpServletResponse resp){
        String username=user.getUsername();
        String password=user.getPassword();
        User user1 = userService.login(username, password);
        boolean flag;
        if(user1!=null){
            flag=true;
            if(remember){
                Cookie username1 = new Cookie("username", username);
                username1.setPath("/ssm_unit_war"); // 明确指定路径
                Cookie password1 = new Cookie("password", password);
                password1.setPath("/ssm_unit_war"); // 明确指定路径

                username1.setMaxAge(60*60*24*7);
                password1.setMaxAge(60*60*24*7);

                resp.addCookie(username1);
                resp.addCookie(password1);
            }
            session.setAttribute("username",user.getUsername());
            return new Result(Code.LOGIN_OK,flag);
        }
        else{
            flag=false;
            return new Result(Code.LOGIN_ERROR,flag);
        }
    }
    @PostMapping("/register")
    public Result register(@RequestParam String checkCode,@RequestBody User user1,HttpSession session){
        String  real_code = (String)session.getAttribute("checkcodegen");
        if(real_code.equalsIgnoreCase(checkCode)){
            String username= user1.getUsername();
            String password=user1.getPassword();
            boolean flag= userService.Register(username,password);
            return new Result(flag?Code.REGISTER_OK:Code.REGISTER_ERROR,flag);
        }
        else{
            return new Result(Code.REGISTER_CODE_ERROR,false);
        }
    }


}
