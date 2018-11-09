<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
  
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 
<%
request.setAttribute("killNumber", "10");
%>
 
c:if 的用法，运行结果：
<c:if test="${killNumber>=10}">
超神
</c:if>
<c:if test="${killNumber<10}">
还没超神
</c:if>
<br>
c:choose 的用法，运行结果：
 
<c:choose>
    <c:when test="${killNumber>=10}">
        超神
    </c:when>
    <c:otherwise>
        还没超神
    </c:otherwise>
</c:choose>
<br>
EL表达式eq的用法，运行结果：
${killNumber ge 10? "超神":"还没超神" }