package com.course.controller;

<<<<<<< HEAD
=======
import com.course.model.User;
>>>>>>> 57b2b145dde501fb9c095c864fff2acf276d99aa
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j;
import org.mybatis.spring.SqlSessionTemplate;
<<<<<<< HEAD
import org.springframework.beans.factory.annotation.Autowired;
=======
import org.springframework.web.bind.annotation.RequestBody;
>>>>>>> 57b2b145dde501fb9c095c864fff2acf276d99aa
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Log4j
@RestController
<<<<<<< HEAD
@Api(value = "/", description = "第一个mybitc Demo")
public class Demo {
    //首先获取一个执行sql语句的对象
    @Autowired
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "可以获得用户数",httpMethod = "GET")
    public int getUserCount() {
       return template.selectOne("getUserCount");
=======
@Api(value = "/", description = "mybatic的demo")
public class Demo {
    //获取一个执行sql的对象
    private SqlSessionTemplate template;

    @RequestMapping(value = "/getUserCount", method = RequestMethod.GET)
    @ApiOperation(value = "可以获取到用户数", httpMethod = "GET")
    public int getUserCount() {
        return template.selectOne("getUserCount");
    }

    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public int addUser(@RequestBody User uesr) {
        int result = template.insert("addUser", uesr);
        return result;
    }

    @RequestMapping(value = "updateUser", method = RequestMethod.POST)
    public int updateUser(@RequestBody User user) {
        return template.update("updateUser", user);
    }

    @RequestMapping(value = "deleteUser", method = RequestMethod.GET)
    public int delUser(@RequestBody int id) {
        return template.delete("deleteUser", id);
>>>>>>> 57b2b145dde501fb9c095c864fff2acf276d99aa
    }
}
