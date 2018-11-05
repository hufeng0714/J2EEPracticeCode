package com.practice.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
  
public class LoginServlet extends HttpServlet {
	
    public LoginServlet() {
        System.out.println("LoginServlet 构造方法 被调用");
    }
 
    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }
	
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取中文的参数
        request.setCharacterEncoding("UTF-8"); 
        
        String name = request.getParameter("name");
        String password = request.getParameter("password");
        /*
         * 输出参数到浏览器页面
         */
        //返回中文的响应
        response.setContentType("text/html; charset=UTF-8");
        
        response.getWriter().println("<h1>"+name+"</h1>");
        response.getWriter().println("<h1>"+password+"</h1>");
  
        System.out.println("name:" + name);
        System.out.println("password:" + password);
        
        //request的常见方法
        
        System.out.println("浏览器发出请求时的完整URL，包括协议 主机名 端口(如果有): " + request.getRequestURL());
        System.out.println("浏览器发出请求的资源名部分，去掉了协议和主机名: " + request.getRequestURI());
        System.out.println("请求行中的参数部分: " + request.getQueryString());
        System.out.println("浏览器所处于的客户机的IP地址: " + request.getRemoteAddr());
        System.out.println("浏览器所处于的客户机的主机名: " + request.getRemoteHost());
        System.out.println("浏览器所处于的客户机使用的网络端口: " + request.getRemotePort());
        System.out.println("服务器的IP地址: " + request.getLocalAddr());
        System.out.println("服务器的主机名: " + request.getLocalName());
        System.out.println("得到客户机请求方式: " + request.getMethod());
        
        /*
		 判断账号密码是否为 admin 123，如果是就打印
		success 否则就打印 fail
		
		根据账号密码，创建对应的html字符串。	
		然后通过response.getWriter().println() 发送到浏览器。
         */
        String html = null;
        
        	if ("admin".equals(name) && "123".equals(password))
        		html = "<div style='color:green'>success</div>";
        	else
        		html = "<div style='color:red'>fail</div>";
        	
        	PrintWriter pw = response.getWriter();
        	pw.println(html);
        
        /*
		页面跳转是开发一个web应用经常会发生的事情。 
		比如登录成功或是失败后，分别会跳转到不同的页面。 
		跳转的方式有两种，服务端跳转和客户端跳转
         */
        
//        if ("admin".equals(name) && "123".equals(password)) {
//        	//服务端跳转，链接地址不变
//            request.getRequestDispatcher("success.html").forward(request, response);
//        }else{
//        	//客户端跳转，链接地址会变
//        	response.sendRedirect("fail.html");
//        }
 
    }
}