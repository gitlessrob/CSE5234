<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import ="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
<style><%@include file="/WEB-INF/css/mystyle.css"%></style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<center>
<h3>Delectable Delights</h3>
<h5>Find candies from all over the world</h5>
</center>
<ul>
<%
ArrayList<String> list=new ArrayList<String>();
list=(ArrayList<String>)request.getAttribute("menu");

%>
<li><a href=""><%=list.get(0) %></a></li>
<li><a href="purchase"><%=list.get(1) %></a></li>
<li><a href="AboutUs"><%=list.get(2) %></a></li>
<li><a href="ContactUs"><%=list.get(3) %></a></li>


</ul>
</body>
</html>