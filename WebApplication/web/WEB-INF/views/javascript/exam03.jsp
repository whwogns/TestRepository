<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		<script>
			//전역변수    //  이후 script태그에서는 모두 사용가능한 변수
			var v1 = "A";
			
			function fun1(){
				//로컬변수     // 함수내에서만 사용가능한 변수    // 자바스크립트는 블록단위 변수가 아니라 함수단위로 로컬변수가 사용가능하다.
				var v2 = "B";
				if(true){
					var v3 = "C";
				}
			}
		</script>
		
	</head>
	<body>
		<h1>Hello World!</h1>
	</body>
</html>
