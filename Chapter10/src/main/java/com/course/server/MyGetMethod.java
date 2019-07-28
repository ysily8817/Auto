package com.course.server;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController //我是要被你扫描的类
@Api(value = "/", description = "这是我全部的get方法")
public class MyGetMethod {

    //返回一个cookie信息的接口
    @RequestMapping(value = "/getCookies",method = RequestMethod.GET)
    @ApiOperation(value = "获取cookies", httpMethod = "get")
    public String getCookies(HttpServletResponse response) {
        Cookie cookie = new Cookie("login","true");
        response.addCookie(cookie);
        return "恭喜你获得cookies成功";
    }
    //携带cookie信息的接口请求
    @RequestMapping(value = "/get/with/cookies", method = RequestMethod.GET)
    @ApiOperation(value = "携带cookie信息进行请求", httpMethod = "get")
    public String getWithCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();

        if(Objects.isNull(cookies)) {
            return "没有携带cookies信息";
        }
        for (Cookie cookie : cookies) {
            if(cookie.getName().equals("login") && cookie.getValue().equals("true")) {
                return "恭喜你请求成功";
            }
        }
        return "携带的cookies有误";
    }

    //携带参数的get请求，第一种请求方式
    //uri:http://127.0.0.1:8888/get/with/param?start=1&end=5
    @RequestMapping(value = "/get/with/param", method = RequestMethod.GET)
    @ApiOperation(value = "携带参数的第一种get请求", httpMethod = "get")
    public Map<String, Integer> getWithParam(@RequestParam Integer start, @RequestParam Integer end) {
        Map<String, Integer> mapList = new HashMap<>();
        mapList.put("鞋子", 500);
        mapList.put("衣服", 300);
        mapList.put("篮球", 150);

        return  mapList;
    }

    //携带参数的get请求，第二种请求方式
    //uri:http://127.0.0.1:8888/get/with/param/1/5
    @RequestMapping(value = "/get/with/param2/{start}/{end}")
    @ApiOperation(value = "携带参数的第二种get请求", httpMethod = "get")
    public Map getWithParam2(@PathVariable Integer start, @PathVariable Integer end) {
        Map<String, Integer> mapList = new HashMap<>();
        mapList.put("鞋子2", 500);
        mapList.put("衣服2", 300);
        mapList.put("篮球2", 150);

        return  mapList;
    }
}
