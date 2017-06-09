<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		 <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
<body>

	<img src="<%application.getContextPath();%>resources/images/marathon00.png" 
	style="margin-left: auto; margin-right: auto; display: block;" width="500px" height="400px"><br/>
	<div style="margin: auto; width: 10%; border: 0px solid #73AD21" style="font-size: 30;">
		<a href="board/pBoard" class="btn btn-primary btn-lg" >사진 게시판</a>
	</div>
</body> 
</html>