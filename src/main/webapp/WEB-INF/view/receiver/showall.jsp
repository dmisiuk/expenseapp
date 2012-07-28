<%@ page language="java"  contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Iterator" %>
<%@ page import="by.minsler.beans.Receiver" %>


<!doctype html>

<html>
<head>
<link rel="stylesheet" href="css/default.css">
<meta charset="utf-8">
	<title>Receiver: show all</title>
</head>

 <jsp:include page="/WEB-INF/template/_header.jsp"></jsp:include>
 
 <div id="container">
		<div id="content">
		<jsp:include page="/WEB-INF/template/_manager.jsp"></jsp:include>
		
		
		<%

			List<Receiver> list = (ArrayList<Receiver>) request.getAttribute("listreceiver");
			Iterator it = list.iterator();
			%>
				<table border="1">
					<thead>
						<tr>
							<th>Num:</th>
							<th>Name</th>
							
						</tr>
					</thead>
					<tbody>
						<% while(it.hasNext()){ 
						Receiver receiver = (Receiver) it.next(); %>
						<tr>
							<td><%=  receiver.getNum() %></td>
							<td><%=  receiver.getName() %> </td>
							
							<td>
								<form action="receiver" method="post">
								<input type="hidden" name="id" value="<%=  receiver.getNum() %>"> 
								<input type="submit" name="buttonDelete" value="delete">
								<input type="submit" name="buttonEdit" value="edit">
								</form>
							</td>
						</tr>
						<% }%>
					</tbody>
				</table>
		
		
		</div>
 </div>
 
  <jsp:include page="/WEB-INF/template/_footer.jsp"></jsp:include>

</html>