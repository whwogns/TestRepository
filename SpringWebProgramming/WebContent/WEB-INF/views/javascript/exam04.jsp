<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		
		<script src="<%=application.getContextPath()%>on/resources/js/exam04.js" type="text/javascript"></script>
		<script>
			var result = totalSum(1,100);
			console.log("result"+result);
		</script>
		
	</head>
	<body>
		<button onclick="handleBtnOk()">ok</button>  
		<a href="javascript:handleBtnOk()">ok</a>
	</body>
</html>
