package com.j2se.code;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroUpdateServletMVC extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        int hp  = Integer.parseInt(request.getParameter("hp"));
        int id  = Integer.parseInt(request.getParameter("id"));
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        hero.setId(id);
        new HeroDAO().update(hero);

        response.sendRedirect("heroListServletMVC");
	}

}
