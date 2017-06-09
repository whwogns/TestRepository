<%@page contentType="text/html; charset=UTF-8"%>
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
	<h1>게시물 상세보기</h1>
	</div>
	<hr />
	<form method="post" style="padding: 50px 450px"
		enctype="multipart/form-data">
		<div class="form-group" style="width:500px; height: 100px;">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> <input type="text" class="form-control" name="bno"
					value="${board.bno}" style="height: 100px" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-picture"></span>
				</span> <input type="text" class="form-control"
					name="btitle" value="${board.btitle}" style="height: 100px" disabled />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> <input type="text" class="form-control"
					name="bwriter" value="${board.bwriter}" style="height: 100px" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-calendar"></span>
				</span> <input type="date" class="form-control"
					name="bdate" value="${board.bdate}" style="height: 100px" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-thumbs-up"></span>
				</span> <input type="number" class="form-control"
					name="bhitcount" value="${board.bhitcount}" style="height: 100px" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-edit"></span>
				</span>
				<textarea class="form-control" rows="5" cols="30"
					name="bcontent" style="height: 100px" disabled>${board.bcontent}</textarea>
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group" style="height: 37px">
				<span class="input-group-addon"> <span class="glyphicon glyphicon-camera"></span>
				</span> <a href="#" class="form-control" >${board.boriginalfilename}</a>
			</div>
		</div>

		<a href="pBoard" class="btn btn-success" style="font-size: 26pt">목록</a>
		<a href="pBoardUpdate?bno=${board.bno}" class="btn btn-warning" style="font-size: 26pt">수정</a>
		<a href="pBoardDelete?bno=${board.bno}" class="btn btn-danger" style="font-size: 26pt">삭제</a>  
	</form>
</body>
</html>