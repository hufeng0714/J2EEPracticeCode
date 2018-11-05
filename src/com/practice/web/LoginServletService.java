package com.practice.web;
		/*
			 ʵ���ϣ���ִ��doGet()����doPost()֮ǰ��������ִ��service()
			��service()���������жϣ����׸õ���doGet()����doPost()
			���Է��֣�service(), doGet(), doPost() ���ַ�ʽ�Ĳ����б���һ���ġ�
			���ԣ���ʱ��Ҳ��ֱ����дservice()�������������ṩ��Ӧ�ķ��񣬾Ͳ������ֵ�����get����post�ˡ�
			�����ǰ��ĵ�¼��LoginServlet����Ϊ�ṩservice������Ҳ���Դﵽ��ͬ��Ч��
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
        System.out.println("LoginServlet ���췽�� ������");
    }
 
    public void init(ServletConfig config) {
        System.out.println("init(ServletConfig)");
    }

	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
        //��ȡ���ĵĲ���
        request.setCharacterEncoding("UTF-8"); 
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		
		//�������ĵ���Ӧ
		response.setContentType("text/html; charset=UTF-8");
		
		response.getWriter().println("<h1>"+name+"</h1>");
		response.getWriter().println("<h1>"+password+"</h1>");
		
		System.out.println("name:" + name);
        System.out.println("password:" + password);
        
        /*
		 �ж��˺������Ƿ�Ϊ admin 123������Ǿʹ�ӡ
		success ����ʹ�ӡ fail
		
		�����˺����룬������Ӧ��html�ַ�����	
		Ȼ��ͨ��response.getWriter().println() ���͵��������
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
        	//�������ת�����ӵ�ַ����
        	
            request.getRequestDispatcher("success.html").forward(request, response);
        }else{
        	//�ͻ�����ת�����ӵ�ַ���
        	response.sendRedirect("fail.html");
        }
	}
}
