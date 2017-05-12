<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset=UTF-8">
		<title>JSP Page</title>
		<script>
			function totalSum(from, to){
				if(to == undefined){
					to = from;
					from=0;
				}
				var sum = 0;
				for(var i=from; i<=to; i++){
					sum+=i;
				}
				return sum;
			}
			
			var return = totalSum(1,100);    // 자바스크립트는 매개변수 수만큼 꼭 대입할 필요없다. 두개라도 하나만 넣어도 됨.
			console.log("result: "+result);
			
			var result2 = totalSum(100);
		</script>
	</head>
	<body>
		<h1>Hello World!</h1>
	</body>
</html>
