<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="/WebApplication/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="/WebApplication/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			var v1="100.5";
			var v2=v1+200;
			console.log(v2);
			var v2=parseInt(v1)+200;  //문자를 int값으로 변환  100.5를 그대로 출력하고 싶으면 parsefloat
			console.log(v3);
			
			
			var v4 =String(10)+"점";
			var v4 =10+"점";
			
		</script>
    </head>
    <body>
        <h1>글로벌 함수</h1>
    </body>
</html>
