package com.course.server;

import com.course.bean.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@Api(value = "/", description = "这是我全部的post方法")
public class MyPostMethod {

    private Cookie cookie;
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ApiOperation(value = "登录接口,登录后获取cookie信息", httpMethod = "post")
    public String login(HttpServletResponse response,
                        @RequestParam(value = "userName", required = true) String name,
                        @RequestParam(value = "passWord", required = true) String password) {
        if(name.equals("ycm") && password.equals("123456")) {
            cookie = new Cookie("login", "ture");
            response.addCookie(cookie);
            return "恭喜你登录成功";
        }
        return "用户名或密码有误";
    }

    @RequestMapping(value = "/getUserList", method = RequestMethod.POST)
    @ApiOperation(value = "返回用户信息", httpMethod = "post")
    public String getUserList(HttpServletRequest request,
                            @RequestBody User user) {
        User users = null;
        users.setName("张老板");
        users.setAge("30");
        users.setSex("man");
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login") && cookie.getValue().equals("ture")) {
                return users.toString();
            }
        }
        return "参数有误";

    }
}
