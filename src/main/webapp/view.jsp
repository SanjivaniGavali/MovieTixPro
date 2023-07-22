<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%Object res=request.getAttribute("remaining"); %>
<% int data=(int)res;%>

<%if(data>=0){ %>
<h1>MOVIE NAME:<%=request.getAttribute("name") %></h1>
<h1>BOOKED TICKET:<%=request.getAttribute("ticket") %></h1>
<h1>AVAILABEL TICKET:<%=request.getAttribute("remaining") %></h1>
<h1>Total Bill:<%=request.getAttribute("bill") %></h1>
<%}else if(data<0){%>
<h1>HOUSFULL!!!</h1>
<%} %>
</body>
</html>