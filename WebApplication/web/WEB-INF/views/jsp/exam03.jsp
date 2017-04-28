<%---
jsp에서의 주석임. 결과에 영향없다.

[지시자]
1. 작성: <%@...%>
2. 종류
<%@page...%>   :  JSP가 무엇을 만들어내느냐?    contentType : 텍스트 작성시 html문법으로 작성 ; charset=UTF-8  : 브라우져로 보낼때 문자셋 / pageEncoding : 문자셋을 UTF-8로 파일에 저장하겠다.
<%@include ...%> : 외부파일을 가져와서 합친다.(포함시킨다.)
<%@taglib...%>  : JSP에서 추가적으로 사용할 수 있는 커스텀 태그 로딩   // <c: foreach(=for), if(=if), choose(=switch)  / ${status.count} 얼마나 도는지 상태를 알려주는것.
3. 역할
---%>
<%@page contentType="text/html; charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>


<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="/WebApplication/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="/WebApplication/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
    </head>
    <body>
        <h4>JSTL (java standard tag library) 사용하기</h4>
		<%for (int i = 1; i <= 5; i++) {%>
		<img src="/WebApplication/resources/image/member0<%=i%>.png" width="50px" height="50px"/>
		<%}%>
		
		<br/>
		
		<c:forEach begin="1" end="5" step="1" varStatus="status">
			<img src="/WebApplication/resources/image/member0${status.count}.png" width="50px" height="50px"/>
		</c:forEach>
    </body>
</html>
