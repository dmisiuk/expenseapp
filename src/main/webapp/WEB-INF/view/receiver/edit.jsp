<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="by.minsler.beans.Receiver" %>

<!doctype html>

<html>
<head>
<link rel="stylesheet" href="css/default.css">
<meta charset="utf-8">
	<title>Receiver: new</title>
</head>

 <jsp:include page="/WEB-INF/template/_header.jsp"></jsp:include>
 
 <div id="container">
		<div id="content">
		<jsp:include page="/WEB-INF/template/_manager.jsp"></jsp:include>
		
		
<%
Receiver receiver = (Receiver) request.getAttribute("receiver");
%>

		<div class="info_table">
		  	<h1> Receiver: Edit</h1>
		  	<div class="info_table_body">
		  		<form action="">
		  			<input type="hidden" name="id" value ="<%= receiver.getNum()%>">
			  		<ul>
			  			<li>ID: <%= receiver.getNum()%></li>
			  			<li> Name <textarea name="name" cols="15" rows="1"><%= receiver.getName()%></textarea>
			  			<li><input type="submit" name="buttonUpdate" value="Uptade"></li>
			  		</ul>
		  		
		  		</form>
		  		
		  	</div>
		  </div>
		
		</div>
 </div>
 
  <jsp:include page="/WEB-INF/template/_footer.jsp"></jsp:include>

</html>