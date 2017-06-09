<%@page contentType="text/html; charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no">
<title>JSP Page</title>
<link
	href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<script
	src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js"
	type="text/javascript"></script>
<script
	src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js"
	type="text/javascript">
	</script>
	<script type="text/javascript">
		function fileChange(){
			if($("#battach")[0].files.length !=0){
				var originalfilename = $("#battach")[0].files[0].name;
				$("#spanFileName").text(originalfilename);
			}
		}
	</script>
</head>
<body>
<div style="padding:0px 500px">
	<h1>게시물 쓰기</h1>
	</div>
	<hr/>
	<form method="post"  style="padding: 50px 450px" enctype="multipart/form-data">
			<input type="hidden" name="bno" value="${board.bno}"/>
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-user"></span>
					</span>
					<input type="text" class="form-control" placeholder="제목" name="btitle"value="${board.btitle}" style="height: 100px"/>
				</div>
			</div>
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-tag"></span>
					</span>
					<input type="text" class="form-control" placeholder="글쓴이" name="bwriter"value="${board.bwriter}" style="height: 100px" disabled/>
				</div>
			</div>
		
			<div class="form-group" style="width:500px; height: 100px;">
				<div class="input-group">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-lock"></span>
					</span>
					<textarea class="form-control" rows="5" cols="30"placeholder="내용"name="bcontent" style="height: 100px">${board.bcontent}</textarea>
				</div>
			</div>
			
			<div class="form-group">
				<div class="input-group" style="width:500px; height:47px;">
					<span class="input-group-addon">
						<span class="glyphicon glyphicon-camera"></span>
					</span>
					<div class="form-control"style="height:47px;">
						<span id="spanFileName">${board.boriginalfilename}</span>
						<label for="battach" class="btn btn-success">변경</label>
						<input id="battach" style="visibility:hidden;" type="file"name="battach"onchange="fileChange()" style="height: 100px"/>
					</div>
				</div>
			</div>

			<input type="submit" class="btn btn-info" value="수정하기" style="font-size: 26pt"/>
		</form>
</body>
</html>