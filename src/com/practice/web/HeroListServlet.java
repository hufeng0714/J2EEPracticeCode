package com.practice.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.j2se.code.Hero;
import com.j2se.code.HeroDAO;

public class HeroListServlet extends HttpServlet {

	/**
		CRUD�ǳ�����ҳ�湦�ܣ������ǳ�˵����ɾ�Ĳ� 
		C - Creation ���� 
		R - Retrieve ��ѯ 
		U - Update �޸� 
		D - DELETE ɾ�� 
		
		���½ڽ����������JDBC��ϣ�ͨ��servlet��ѯ���ݿ⣬���ݲ�ѯ������õ�һ��htmlҳ�棬��ʾ���ݿ��е����ݡ� 
	*/
	
	/**
		��һ��Hero��ά��ҳ����ҪһЩͨ�õĲ������������ӣ�ɾ�����༭���޸ģ���ѯ�ȡ�
		ÿ����ͬ�Ĳ���������Ҫһ����Ӧ��Servlet��������Hero֮�⣬��������������һЩ�����ز��������ԺõĹ淶��Խ�����ά�����кô���
		һ�����������,�Բ�ѯΪ�� HeroListServlet �� [��][��Ϊ]Servlet ����һ����������
		���Զ���Hero���Ծͻ����������
			���� HeroAddServlet
			ɾ�� HeroDeleteServlet
			�༭ HeroEditServlet
			�޸� HeroUpdateServlet
			��ѯ HeroListServlet
			
		��HeroListServlet�У���ʹ��HeroDAO�����ݲ�ѯ������Ȼ��ƴ�ӳ�һ��table������ʾ������
	 */
	public void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html; charset=UTF-8");

		List<Hero> heros = new HeroDAO().list();
        StringBuffer sb = new StringBuffer();
        sb.append("<table align='center' border='1' cellspacing='0'>\r\n");
        sb.append("<tr><td>id</td>"
        		+ "<td>name</td>"
        		+ "<td>hp</td>"
        		+ "<td>damage</td>"
        		+ "<td>edit</td>"
        		+ "<td>delete</td>"
        		+ "</tr>\r\n");
 
        String trFormat = "<tr><td>%d</td>"
        		+ "<td>%s</td>"
        		+ "<td>%f</td>"
        		+ "<td>%d</td>"
        		+ "<td><a href='editHero?id=%d'>edit</a></td>"
        		+ "<td><a href='deleteHero?id=%d'>delete</a></td>"
        		+ "</tr>\r\n";
 
        for (Hero hero : heros) {
            String tr = String.format(trFormat, hero.getId(), hero.getName(), 
            		hero.getHp(), hero.getDamage(),hero.getId(),hero.getId());
            sb.append(tr);
        }
 
        sb.append("</table>");
 
        response.getWriter().write(sb.toString());
	}

}
