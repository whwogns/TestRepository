<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
<title>JSP Page</title>
<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
</head>
<body>
		<h1>게시물 목록</h1>
	<hr/>
	<table class="table table-bordered" >
	<tbody>
		<tr class="success" >
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">번호</td>
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">제목</td>
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">글쓴이</td>
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">날짜</td>
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">조회수</td>
			<td align="center" style="font-size: 14pt;font-weight: bold;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">사진</td>
		</tr>
		<c:forEach var="b" items="${list}">
			<tr>
				<td align="center" height="120px" style="font-size: 10pt; box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">${b.bno}</td>
				<td align="center" height="120px" style="font-size: 30pt;font-weight: bold; box-sizing: border-box; margin: 0px; padding: 0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;"><a href="pBoardDetail?bno=${b.bno}">${b.btitle}</a></td>
				<td align="center" height="120px" style="font-size: 16pt;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">${b.bwriter}</td>
				<td align="center" height="120px" style="font-size: 16pt;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">${b.bdate}</td>
				<td align="center" height="120px" style="font-size: 16pt;box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;">${b.bhitcount}</td>
				<td align="center" height="120px" style="box-sizing:border-box; margin:0px; padding:0px; border: 1px solid blue; line-height: 2;font-family: Arial, 돋움, Dotum, AppleGothic, sans-serif !important;"><img src="picture?bno=${b.bno}" width="300px" height="250px" /></td>
			</tr>
		</c:forEach>
		</tbody>
	</table>

	<div style="margin-top: 20px; width: 700px; text-align: center;">
		<a href="pBoard?pageNo=1" style="font-size: 26pt;">[처음]</a>
		<c:if test="${groupNo>1}">
			<a href="pBoard?pageNo=${startPageNo-1}" style="font-size: 26pt;">[이전]</a>
		</c:if>

		<c:forEach var="i" begin="${startPageNo}" end="${endPageNo}">
				&nbsp;
				<a href="pBoard?pageNo=${i}" style="font-size: 26pt; "
					<c:if test="${pageNo==i}">style="font-weight:bold;color:red;"
					</c:if>>${i}
				</a>
				&nbsp;
			</c:forEach>
		<c:if test="${groupNo<totalGroupNo}" >
			<a href="pBoard?pageNo=${endPageNo+1}" style="font-size: 26pt;">[다음]</a>
		</c:if>
		<a href="pBoard?pageNo=${totalPageNo}" style="font-size: 26pt;">[맨끝]</a>
	</div>
	<br/>
	<div style="margin: auto; text-align: center;">
		<a href="pBoardInsert" class="btn btn-success" style="font-size: 26pt;">글쓰기</a>
	</div>
	<br/>
	<br/>
</body>
</html>