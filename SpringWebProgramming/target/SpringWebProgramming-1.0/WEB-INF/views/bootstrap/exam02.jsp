<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<style>
			div{border:1px solid black; }
		</style>
	</head>
	<body>
		<div class="container-fluid" style="height: 300px; border: 1px solid black">
			<div class="row">
				<div class="col-sm-1" style="border:1px solid black">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div> 
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
				<div class="col-sm-1">.col-sm-1</div>
			</div>
			<div class="row">
				<div class="col-sm-8">.col-sm-8</div>
				<div class="col-sm-4">.col-sm-4</div>
			</div>
			<div class="row">
				<div class="col-sm-4">.col-sm-4</div>
				<div class="col-sm-4">.col-sm-4</div>
				<div class="col-sm-4">.col-sm-4</div>
			</div>
			<div class="row">
				<div class="col-sm-6">.col-sm-6</div>
				<div class="col-sm-6">.col-sm-6</div>
			</div>
		</div>
	</body>
</html>
