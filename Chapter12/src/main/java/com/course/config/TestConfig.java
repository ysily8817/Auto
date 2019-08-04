package com.course.config;

import org.apache.http.client.CookieStore;
import org.apache.http.impl.client.DefaultHttpClient;

public class TestConfig {
    public static String loginUrl;
    public static String updateUserInfo;
    public static String getUserInfo;
    public static String getUserList;
    public static String addUser;

    public static DefaultHttpClient defaultHttpClient;
    public static CookieStore cookieStore;

}
