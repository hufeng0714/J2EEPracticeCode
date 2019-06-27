package com.j2se.code;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HeroAddServletMVC extends HttpServlet {

    protected void service(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("name");
        float hp  = Float.parseFloat(request.getParameter("hp"));
        int damage = Integer.parseInt(request.getParameter("damage"));
        Hero hero = new Hero();
        hero.setName(name);
        hero.setHp(hp);
        hero.setDamage(damage);

        new HeroDAO().add(hero);

        response.sendRedirect("heroListServletMVC");
    }
}
