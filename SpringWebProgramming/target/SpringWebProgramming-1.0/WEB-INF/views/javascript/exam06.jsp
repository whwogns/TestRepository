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
		<script>
			var now = new Date();
			console.log(now.getFullYear());
			console.log(now.getMonth()+1); //0부터시작하므로 +1해줘야함
			console.log(now.getDate());  // 날짜
			console.log(now.getDay()); //요일  숫자로 표현
		</script>
		
    </head>
    <body>
        <h1>날짜정보얻기</h1>
    </body>
</html>
