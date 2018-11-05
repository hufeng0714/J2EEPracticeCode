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
		request.getParameter(): �ǳ����ķ��������ڻ�ȡ��ֵ�Ĳ���
		request.getParameterValues(): ���ڻ�ȡ���ж�ֵ�Ĳ���������ע��ʱ���ύ�� "hobits"�������Ƕ�ѡ�ġ�
		request.getParameterMap(): ���ڱ������еĲ�����������Map���͡�
	 */
	public void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {

        System.out.println("��ȡ��ֵ����name:" + request.getParameter("name"));
        
        String[] hobits = request.getParameterValues("hobits");
        System.out.println("��ȡ���ж�ֵ�Ĳ���hobits: " + Arrays.asList(hobits));
 
        System.out.println("ͨ�� getParameterMap �������еĲ����� ");
        Map<String, String[]> parameters = request.getParameterMap();
 
        Set<String> paramNames = parameters.keySet();
        for (String param : paramNames) {
            String[] value = parameters.get(param);
            System.out.println(param + ":" + Arrays.asList(value));
        }
	}
}
