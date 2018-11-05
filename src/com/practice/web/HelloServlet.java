package com.practice.web;
import java.io.IOException;
import java.util.Date;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
public class HelloServlet extends HttpServlet{
 
	/*
		有的时候会有这样的业务需求： 
		tomcat一启动，就需要执行一些初始化的代码，比如校验数据库的完整性等。 
		但是Servlet的生命周期是在用户访问浏览器对应的路径开始的。如果没有用户的第一次访问，就无法执行相关代码。 
		这个时候，就需要Servlet实现自启动 即，伴随着tomcat的启动，自动启动初始化，在初始化方法init()中，就可以进行一些业务代码的工作了。
	 */
	/*
		在web.xml中，配置Hello Servlet的地方，增加一句 
		<load-on-startup>10</load-on-startup>
		取值范围是1-99
		
		即表明该Servlet会随着Tomcat的启动而初始化。
		同时，为HelloServlet提供一个init(ServletConfig) 方法，验证自启动
		如图所示，在tomcat完全启动之前，就打印了init of HelloServlet
		<load-on-startup>10</load-on-startup> 中的10表示启动顺序
		如果有多个Servlet都配置了自动启动，数字越小，启动的优先级越高
	 */
	public void init(ServletConfig config){
		System.out.println("init of hello Servlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response){
         /*
			request.getHeader() 获取浏览器传递过来的头信息。 
			比如getHeader("user-agent") 可以获取浏览器的基本资料，这样就能判断是firefox、IE、chrome、或者是safari浏览器
			request.getHeaderNames() 获取浏览器所有的头信息名称，根据头信息名称就能遍历出所有的头信息
			
			在本例，修改HelloServlet,使其获取头信息
			访问HelloServlet获取如下头信息:
			host: 主机地址
			user-agent: 浏览器基本资料
			accept: 表示浏览器接受的数据类型
			accept-language: 表示浏览器接受的语言
			accept-encoding: 表示浏览器接受的压缩方式，是压缩方式，并非编码
			connection: 是否保持连接
			cache-control: 缓存时限
          */
        Enumeration<String> headerNames= request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.printf("%s\t%s%n",header,value);
        }
    	/*
    	 访问路径
    	 http://localhost:8080/j2ee/hello
    	 */
        try {
            response.getWriter().println("<h1>Hello Servlet!</h1>");
            response.getWriter().println(new Date());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
     
}