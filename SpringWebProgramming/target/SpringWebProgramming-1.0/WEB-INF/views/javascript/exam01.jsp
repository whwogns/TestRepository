<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		<script type="text/javascript">
			//변수선언
			var v1=10;
			console.log("v1: "+v1 + " "+ typeof(v1));
			
			var v2="자바스크립트";
			console.log("v2: "+v2 + " "+ typeof(v2));
			
			var v3=true;
			console.log("v3: "+v3 + " "+ typeof(v3));
			
			var v4=[10, 20, 30];
			console.log("v4: "+v4 + " "+ typeof(v4));    //자바스크립트에서는 []는 배열를 표현
			console.log(v4);  //v4 전부를 보여줌
			
			var v5={mid:"white", mname:"홍길동", mage:30};   //{속성: 속성값}객체 JSON     자바에 필드에 해당함.    //네트워크 전송한다면 속성이름도 ""로 감싸야함.
			console.log("v5: "+v5 + " "+ typeof(v5));   //v5의 toString을 보여줌
			console.log(v5);    // v5의 전부를 보여줌.
			
			var v6 = new Date();
			console.log("v6: "+v6+ " "+ typeof(v6));
			
			var v7 = null;
			console.log("v7: "+v7+ " "+ typeof(v7));
			
			var v8 = function(){console.log("function() 실행")}; //v8은 변수이름이자 함수이름임. 자바스크립트에서는 함수도 객체.
			console.log("v8: "+v8+ " "+ typeof(v8));
			v8();// 이렇게 불러올수있다. 그러면 함수가 호출됨.
		</script>
	</head>
	<body>
	</body>
</html>
