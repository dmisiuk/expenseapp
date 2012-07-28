<%@ page contentType="text/html; charset=UTF-8"  %>

<!DOCTYPE html>

<html>
<head>
	<title>ExpenseApp: main page</title>
	<meta charset="utf-8" >
	<link rel="stylesheet" href="css/default.css">
</head>
<body>
	<jsp:include page="/WEB-INF/template/_header.jsp"></jsp:include>
	
	<div id="container">
		<div id="content">
		  <div class="info_table">
		  	<h1> Expenses: <span>show, add, search, delete, etc</span></h1>
		  	<div class="info_table_body">
		  		<ul>
		  			<li class="name"><h2>Expenses</h2></li>
		  			<li class="number"> 
		  				<a href="expense?buttonShowAll=yes">
		  					<h2>15</h2>
		  				</a>
		  			</li>
		  			<li class="manage">
		  			<a href="expense">
		  				<h2>Manage</h2>
		  			</a>
		  			 </li>
		  		</ul>
		  	</div>
		  </div>
		  <div class="info_table">
		  	<h1> Receivers: <span>show, add, search, delete, etc</span></h1>
		  	<div class="info_table_body">
		  		<ul>
		  			<li class="name"><h2>Receivers</h2></li>
		  			<li class="number"> 
		  				<a href="receiver?buttonShowAll=yes">
		  					<h2>15</h2>
		  				</a>
		  			</li>
		  			<li class="manage">
		  			<a href="receiver">
		  				<h2>Manage</h2>
		  			</a>
		  			 </li>
		  		</ul>
		  	</div>
		  </div>
		</div>
	</div>
	<jsp:include page="/WEB-INF/template/_footer.jsp"></jsp:include>
</body>
</html>
