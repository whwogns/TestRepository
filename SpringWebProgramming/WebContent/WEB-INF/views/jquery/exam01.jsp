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
			function handleBtn1() {   
				var imgArray = $("img");    //넘어가는건 jquery객체임.   //jquery객체 내부의 메소드를 이용하면 그  jquery배열을 컨트롤 할 수 있는것.
				imgArray.attr("src","/WebApplication/resources/image/photo02.jpg");    // attr(속성이름, 바꿀값) 는 배열w3c dom 모든 객체 속성을 찾아가서 바꿔준다.
				
			}
			function handleBtn2() {
				var img1 = $("#img1");   
				img1.attr("src","/WebApplication/resources/image/photo03.jpg");
			}
			function handleBtn3() {
				var class1 = $(".class1");  
				class2.attr("src","/WebApplication/resources/image/photo04.jpg");
			}
		</script>
	</head>
    <body>
        <h1>DOM 사용하기</h1>
		<div>
			<button onclick="handleBtn1()">이미지변경</button> <br/>
			<img src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px"/>
			<img src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px"/>
		</div>
		<div>
			<button onclick="handleBtn2()" class="btn-success">img1이미지변경</button> <br/>
			<button onclick="handleBtn3()" class="btn-success">class1이미지변경</button> <br/>
			<img id="img1" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px"/>
			<img class="class1" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px"/>
			<img class="class1" src="/WebApplication/resources/image/photo01.jpg" width="100px" height="100px"/>
		</div>
    </body>
</html>
