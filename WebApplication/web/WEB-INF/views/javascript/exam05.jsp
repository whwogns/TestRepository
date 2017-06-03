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
			var v1="abc";
			console.log(v1.length);
			
			var v2 = "JavaScript is easy";
			console.log(v2.indexOf("easy"));
			
			var v3="123456-1234567";
			console.log(v3.substr(0,6));
			console.log(v3.substr(7)); //시작인덱스만 넣으면 그로부터 끝까지 출력됨
			console.log(v3.charAt(7));  // 7인덱스 글자 추출
			
			var v4="10:20:30";   // 구분자로 나뉜 각각이 토큰.
			var array = v4.split(":");  // 구분자를 기준으로 하나씩 배열에 대입
			console.log(array[0]);
			console.log(array[1]);
			console.log(array[2]);
		</script>
    </head>
    <body>
        <h1>Hello World!</h1>
    </body>
</html>
