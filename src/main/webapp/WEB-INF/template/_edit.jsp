<%@ page  language="java" contentType="text/html; charset=UTF-8"  %>
<%@ page import="by.minsler.beans.Receiver" %>

<%
Receiver receiver = (Receiver) request.getAttribute("receiver");
receiver.
%>
<div class="info_table">
		  	<h1> Receiver: Edit</h1>
		  	<div class="info_table_body">
		  		<form action="">
		  			<input type="hidden" name="id" value ="<%= receiver.getNum()%>">
			  		<ul>
			  			<li>Name:</li>
			  			<li><input type="text" name="name"  value="<%= receiver.getName()%>"></li>
			  			<li><input type="submit" name="buttonUpdate" value="Uptade"></li>
			  		</ul>
		  		
		  		</form>
		  		
		  	</div>
		  </div>