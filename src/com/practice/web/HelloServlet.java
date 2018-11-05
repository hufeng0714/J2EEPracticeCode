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
		�е�ʱ�����������ҵ������ 
		tomcatһ����������Ҫִ��һЩ��ʼ���Ĵ��룬����У�����ݿ�������Եȡ� 
		����Servlet���������������û������������Ӧ��·����ʼ�ġ����û���û��ĵ�һ�η��ʣ����޷�ִ����ش��롣 
		���ʱ�򣬾���ҪServletʵ�������� ����������tomcat���������Զ�������ʼ�����ڳ�ʼ������init()�У��Ϳ��Խ���һЩҵ�����Ĺ����ˡ�
	 */
	/*
		��web.xml�У�����Hello Servlet�ĵط�������һ�� 
		<load-on-startup>10</load-on-startup>
		ȡֵ��Χ��1-99
		
		��������Servlet������Tomcat����������ʼ����
		ͬʱ��ΪHelloServlet�ṩһ��init(ServletConfig) ��������֤������
		��ͼ��ʾ����tomcat��ȫ����֮ǰ���ʹ�ӡ��init of HelloServlet
		<load-on-startup>10</load-on-startup> �е�10��ʾ����˳��
		����ж��Servlet���������Զ�����������ԽС�����������ȼ�Խ��
	 */
	public void init(ServletConfig config){
		System.out.println("init of hello Servlet");
	}
	
    public void doGet(HttpServletRequest request, HttpServletResponse response){
         /*
			request.getHeader() ��ȡ��������ݹ�����ͷ��Ϣ�� 
			����getHeader("user-agent") ���Ի�ȡ������Ļ������ϣ����������ж���firefox��IE��chrome��������safari�����
			request.getHeaderNames() ��ȡ��������е�ͷ��Ϣ���ƣ�����ͷ��Ϣ���ƾ��ܱ��������е�ͷ��Ϣ
			
			�ڱ������޸�HelloServlet,ʹ���ȡͷ��Ϣ
			����HelloServlet��ȡ����ͷ��Ϣ:
			host: ������ַ
			user-agent: �������������
			accept: ��ʾ��������ܵ���������
			accept-language: ��ʾ��������ܵ�����
			accept-encoding: ��ʾ��������ܵ�ѹ����ʽ����ѹ����ʽ�����Ǳ���
			connection: �Ƿ񱣳�����
			cache-control: ����ʱ��
          */
        Enumeration<String> headerNames= request.getHeaderNames();
        while(headerNames.hasMoreElements()){
            String header = headerNames.nextElement();
            String value = request.getHeader(header);
            System.out.printf("%s\t%s%n",header,value);
        }
    	/*
    	 ����·��
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