<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath() %>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath() %>/resources/bootstrap-3.3.7/js/bootstrap.min.js" type="text/javascript"></script>
	</head>
	<body>
		<h4> Member List~~</h4>
		
		<hr/>
	    <div class="container">
		<h3>게시물 목록</h3>
		<table class="table table-bordered">
		  <tr class="success">
		    <td>아이디</td>
		    <td>이름</td>
		    <td>비밀번호(보안필요!!)</td>
		    <td>전화번호</td>
		    <td>등록날짜</td>
		    <td>이메일</td>
		    <td>나이</td>
		    <td>주소</td>
		  </tr>
		  <c:forEach var="m" items="${list}">
		    <tr>
			<td>${m.mid}</td>
			<td><a href="exam06Detail?mid=${m.mid}">${m.mname} </a></td>
			<td>${m.mpassword}</td>
			<td>${m.mtel}</td>
			<td>${m.mdate}</td>
			<td>${m.memail}</td>
			<td>${m.mage}</td>
			<td>${m.maddress}</td>
		    </tr>
		  </c:forEach>
		</table>
	    </div>
		<div class="container" style="margin-top: 20px; width: 700px; text-align: center;">
			<a href="exam06?pageNo=1">[처음]</a>
			<c:if test="${groupNo>1}">
				<a href="exam06?pageNo=${startPageNo - 1}">[이전]</a>
			</c:if>
			<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp;<!-- 문자참조 -->
				<a href="exam06?pageNo=${i}" 
					<c:if test="${pageNo == i}">
						style="font-weight: bold; color: red;"
					</c:if>>
				${i}</a>
				&nbsp;
			</c:forEach>
			<c:if test="${groupNo<totalGroupNo}">
			 	<a href="exam06?pageNo=${endPageNo + 1}">[다음]</a>
			</c:if>
			<a href="exam06?pageNo=${totalPageNo}">[맨끝]</a>
		</div>
		<div class="container" style="margin-top: 20px; width: 700px; text-align: right;">
			<a href="exam03" class="btn btn-warning">회원가입</a>
		</div>
	</body>
</html>