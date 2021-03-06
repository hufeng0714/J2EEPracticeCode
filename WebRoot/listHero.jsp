<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<table align='center' border='1' cellspacing='0'>
    <tr>
        <td>id</td>
        <td>name</td>
        <td>hp</td>
        <td>damage</td>
        <td>edit</td>
        <td>delete</td>
    </tr>
    <c:forEach items="${heros}" var="hero" varStatus="st">
        <tr>
            <td>${hero.id}</td>
            <td>${hero.name}</td>
            <td>${hero.hp}</td>
            <td>${hero.damage}</td>
            <td><a href="heroEditServletMVC?id=${hero.id}">编辑</a></td>
            <td><a href="heroDeleteServletMVC?id=${hero.id}">删除</a></td>
        </tr>
    </c:forEach>
    
    <tr>
        <td colspan="6" align="center">
        	<a href="addHero.jsp">[新增]</a>
        	<a href="?start=0">[首  页]</a>
         	<a href="?start=${pre}">[上一页]</a>
            <a href="?start=${next}">[下一页]</a>
            <a href="?start=${last}">[末  页]</a>
        </td>
    </tr>
</table>