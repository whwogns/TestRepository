<%@page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<div style="padding:0px 500px">
<H1>게시물쓰기</H1>
</div>
<hr/>
	<form method="post" style="padding:50px 450px;" enctype="multipart/form-data" >
	
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="제목"name="btitle" style="height: 100px"/>
				</div>
			</div>
			
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-tag"></span>
					</span>
					<input type="text" class="form-control" placeholder="글쓴이"name="bwriter" style="height: 100px"/>
				</div>
			</div>
		
			
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<textarea class="form-control" rows="5" cols="30"placeholder="내용"name="bcontent" style="height: 100px"></textarea>
				</div>
			</div>
			
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<input type="file" class="form-control" placeholder="선택"name="battach" style="height: 100px"/>
				</div>
			</div>

			<input type="submit" class="btn btn-info" value="등록" style="font-size: 26pt"/>
			
		</form>
</body>
</html>