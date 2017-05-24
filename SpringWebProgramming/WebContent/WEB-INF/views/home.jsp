<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>Home</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
	</head>

	<body>
		WebApplication Home
		<hr/>
		<h4>HTML 태그</h4>
		<a href="html/exam01" class = "btn btn-warning">exam01</a>

		<h4>CSS</h4>
		<a href="css/exam01">exam01</a> <br/>
		<a href="css/exam02">exam02</a> <br/>
		<a href="css/exam03">exam03</a> <br/>

		<h4>JavaScript</h4>
		<%for (int i = 1; i <= 11; i++) {
				String exam = "exam";
				if (i < 10) {
					exam += "0" + i;
				} else {
					exam += String.valueOf(i);
				}%>
		<a href="javascript/<%=exam%>"><%=exam%></a> <br/>
		<%}%>

		<h4>Jquery</h4>
		<%for (int i = 1; i <= 4; i++) {
				String exam = "exam";
				exam += "0" + i;%>
		<a href="jquery/<%=exam%>"class = "btn-warning"><%=exam%></a><br/>
		<%}%>

		<h4>BootStrap</h4>
		<%for (int i = 1; i <= 3; i++) {
				String exam = "exam";
				exam += "0" + i;%>
		<a href="bootstrap/<%=exam%>"><%=exam%></a><br/>
		<%}%>


		<h4>JSP</h4>
		<%for (int i = 1; i <= 4; i++) {
				String exam = "exam";
				exam += "0" + i;%>
		<a href="jquery/<%=exam%>"class = "btn-warning"><%=exam%></a><br/>
		<%}%>

		<h4>BootStrap</h4>
		<%for (int i = 1; i <= 3; i++) {
				String exam = "exam";
				exam += "0" + i;%>
		<a href="jsp/<%=exam%>"><%=exam%></a><br/>
		<%}%>

		<h4>HTTP 요청방식</h4>

		1)GET방식: <a href="http/exam01">exam01</a><br/>
		2)POST방식:
		<form method="post" action="http/exam01">
			<input type="submit" value="exam01"/>
		</form>

		<h4> 요청 HTTP 정보얻기</h4>
		<a href="http/exam02?type=freeboard&bno=5&hobby=baseball&hobby=soccer" class="btn btn-primary">exam02</a>
		<a href="http/exam03?type=freeboard&bno=5&hobby=baseball&hobby=soccer" class="btn btn-primary">exam03</a>

		<h4>폼 제출</h4>
		<a href="form/exam01" class="btn btn-primary">회원가입양식요청</a>

		<h4>파일 업로드</h4>
		<a href="form/exam02" class="btn btn-primary">회원가입양식요청</a>
		
		<h4>파일 다운로드</h4>
		<a href="file/exam03" class="btn btn-primary">파일로 저장</a>
		<img src="file/exam03" width="100px" height="100px"/>
		
		<h4>의존성주입</h4>
		<a href="di/exam01" class="btn btn-primary">회원가입</a>
		<a href="di/exam02" class="btn btn-primary">로그인</a>
		
		<h4>리다이렉트(재요청)</h4>
		<a href="redirect/list" class="btn btn-primary">게시물목록</a>
		<a href="redirect/write" class="btn btn-primary">게시물쓰기</a>
	</body>
</html>