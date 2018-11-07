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
		CRUD是常见的页面功能，即我们常说的增删改查 
		C - Creation 增加 
		R - Retrieve 查询 
		U - Update 修改 
		D - DELETE 删除 
		
		本章节将介绍如何与JDBC结合，通过servlet查询数据库，根据查询结果，得到一个html页面，显示数据库中的内容。 
	*/
	
	/**
		做一个Hero的维护页面需要一些通用的操作，比如增加，删除，编辑，修改，查询等。
		每个不同的操作，都需要一个对应的Servlet，除了做Hero之外，还会做到其他的一些表的相关操作，所以好的规范会对将来的维护更有好处。
		一般会这样命名,以查询为例 HeroListServlet ： [表][行为]Servlet 这样一种命名规则。
		所以对于Hero而言就会如此命名：
			增加 HeroAddServlet
			删除 HeroDeleteServlet
			编辑 HeroEditServlet
			修改 HeroUpdateServlet
			查询 HeroListServlet
			
		在HeroListServlet中，会使用HeroDAO把数据查询出来，然后拼接成一个table用于显示其内容
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
