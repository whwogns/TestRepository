<%---
jsp에서의 주석임. 결과에 영향없다.

[지시자]
1. 작성: <%@...%>
2. 종류
<%@page...%>   :  JSP가 무엇을 만들어내느냐?    contentType : 텍스트 작성시 html문법으로 작성 ; charset=UTF-8  : 브라우져로 보낼때 문자셋 / pageEncoding : 문자셋을 UTF-8로 파일에 저장하겠다.
<%@include ...%> : 외부파일을 가져와서 합친다.(포함시킨다.)
<%@taglib...%>
3. 역할
---%>
<%@page contentType="text/html; charset=UTF-8" %>


<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h1>다른패키지 클래스 사용</h1>
		<%@include file="exam02_include.jsp"%>   
    </body>
</html>
