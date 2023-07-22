<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>TicksBooker</title>
 <style>
    /* Set the height of the container to 100% to occupy the full viewport height */
    .container1 {
      display:inline;
	  width:600px;
      border: 2px solid black;
     margin:200px auto;
    padding: 20px;
    background-color:#aaf0d4;
    border-radius:10px;
    padding-bottom:70px;
      
    }
    /* Center the content horizontally and vertically */
    .d-flex {
     border: 2px solid black;
      display: flex;
      justify-content: center;
      align-items: center;
      flex-direction:column;
      
    }
     .custom-border {
      border: 2px solid black;
      padding:20px;
      font-size: 2rem;
      background-color:black;
      color:white;
    }
    h1{
    	 border: 2px solid black;
    	 padding:10px 20px;
    	background-color:#172c80;
    	color:white;
    }
    body{
    	background-color:#687373;
    }
  </style>
</head>
<body>
<%Object res=request.getAttribute("remaining"); %>
<% int data=(int)res;%>

<%if(data>=0){ %>


	<div class="container1 mt-4 d-flex">
	    <h1 class=" mb-4 text-center">Movie Ticket Details</h1>
	    <table class="table table-bordered custom-border ">
	      <tbody>
	        <tr>
	          <th>Movie Name: </th>
	          <td><%=request.getAttribute("name") %></td>
	        </tr>
	        <tr>
	          <th>Movie Theater Name: </th>
	          <td><%=request.getAttribute("theater") %></td>
	        </tr>
	        <tr>
	          <th>Booked Ticket: </th>
	          <td><%=request.getAttribute("ticket") %></td>
	        </tr>
	        <tr>
	          <th>Available Ticket: </th>
	          <td><%=request.getAttribute("remaining") %></td>
	        </tr>
	        <tr>
	          <th>Total Bill: </th>
	          <td><%=request.getAttribute("bill") %></td>
	        </tr>
	      </tbody>
	    </table>
	 </div>
  <%}else if(data<0){%>
<h1>HOUSFULL!!!</h1>
<%} %>
</body>
</html>