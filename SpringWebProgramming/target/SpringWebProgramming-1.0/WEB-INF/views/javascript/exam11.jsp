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
			function handleBtn1() {    //DOM은 모든 태그를 객체로 만든다.
				//var img = window.document.querySelector("img");   // 실행 내용에서 제일 첫 이미지 객체의 경로를 리턴시킴
				//img.src="/WebApplication/resources/image/photo02.jpg";
				var imgArray = document.querySelectorAll("img");
				for (var i = 0; i < imgArray.length; i++) {
					imgArray[i].src = "/WebApplication/resources/image/photo02.jpg";    //태그로 찾는방법
				}
			}
			function handleBtn2() {
				var img1 = window.document.querySelector("#img1");   //id니까 #붙는다.   //아이디로 찾는방법
				img1.src= "/WebApplication/resources/image/photo03.jpg";
			}
			function handleBtn3() {
				var class1 = window.document.querySelectorAll(".class1");   //class니까 . 이 붙는다   //클래스로 찾는방법
				for (var i = 0; i < class1.length; i++) {
					class1[i].src = "/WebApplication/resources/image/photo04.jpg";
				}
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
