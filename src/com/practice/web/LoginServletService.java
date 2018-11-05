package com.practice.web;
		/*
			 实际上，在执行doGet()或者doPost()之前，都会先执行service()
			由service()方法进行判断，到底该调用doGet()还是doPost()
			可以发现，service(), doGet(), doPost() 三种方式的参数列表都是一样的。
			所以，有时候也会直接重写service()方法，在其中提供相应的服务，就不用区分到底是get还是post了。
			比如把前面的登录的LoginServlet，改为提供service方法，也可以达到相同的效果
		 */
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServletService extends HttpServlet {
	
    public LoginServletService() {
        System.out.println("LoginServlet 构造方法 被调用");
    }
 
    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        //获取中文的参数
        request.setCharacterEncoding("UTF-8"); 
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//返回中文的响应
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().println("<h1>"+name+"</h1>");
		response.getWriter().println("<h1>"+password+"</h1>");
		
		System.out.println("name:" + name);
        System.out.println("password:" + password);
        
        /*
		 判断账号密码是否为 admin 123，如果是就打印
		success 否则就打印 fail
		
		根据账号密码，创建对应的html字符串。	
		然后通过response.getWriter().println() 发送到浏览器。
         */
        
//        String html = null;
//        
//        if ("admin".equals(name) && "123".equals(password))
//            html = "<div style='color:green'>success</div>";
//        else
//            html = "<div style='color:red'>fail</div>";
//
//        PrintWriter pw = response.getWriter();
//        pw.println(html);    
        
        if ("admin".equals(name) && "123".equals(password)) {
        	//服务端跳转，链接地址不变
        	
            request.getRequestDispatcher("success.html").forward(request, response);
        }else{
        	//客户端跳转，链接地址会变
        	response.sendRedirect("fail.html");
        }
	}
}
