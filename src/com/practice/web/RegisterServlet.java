package com.practice.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class RegisterServlet extends HttpServlet {

	
	/*
		request.getParameter(): 是常见的方法，用于获取单值的参数
		request.getParameterValues(): 用于获取具有多值的参数，比如注册时候提交的 "hobits"，可以是多选的。
		request.getParameterMap(): 用于遍历所有的参数，并返回Map类型。
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

        System.out.println("获取单值参数name:" + request.getParameter("name"));
        
        String[] hobits = request.getParameterValues("hobits");
        System.out.println("获取具有多值的参数hobits: " + Arrays.asList(hobits));
 
        System.out.println("通过 getParameterMap 遍历所有的参数： ");
        Map<String, String[]> parameters = request.getParameterMap();
 
        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }
	}
}
