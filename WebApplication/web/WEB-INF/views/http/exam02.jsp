<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <h1>요청 HTTP 정보 얻기</h1>
		1.요청방식(method):${method}<br/>
		2.요청URI:${uri}<br/>
		3.queryString:${queryString}<br/>
		4.요청파라미터(타입):${type}<br/>
		5.요청파라미터(bno):${bno}<br/>
		6.요청 헤더값 (hobby):
		<c:forEach var="h" items="${hobby}" varStatus="status">
			${h}<c:if test="${!status.last}">,</c:if>
		</c:forEach>
		<br/>
		6.요청 헤더값 (user-Agent):${userAgent}<br/>
		
    </body>
</html>
