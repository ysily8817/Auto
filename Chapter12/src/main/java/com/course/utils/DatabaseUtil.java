package com.course.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.*;

import java.io.IOException;
import java.io.Reader;

public class DatabaseUtil {

    public static SqlSession getSqlSession() throws IOException {
        //获取配置文件
        Reader reader = Resources.getResourceAsReader("dateBaseConfig.xml");
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(reader);
        //sqlSession用来执行sql语句
        SqlSession sqlSession = factory.openSession();
        return  sqlSession;
    }
}
