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
	<h4>회원 가입</h4>
	<hr />
	<form method="post" enctype="multipart/form-data">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> 
				<input type="text" class="form-control" style="width:800px;"placeholder="아이디" name="mid" />
			</div>
		</div>
		
			<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> 
				<input type="password" class="form-control" style="width:800px;"placeholder="비밀번호" name="mpassword" />
			</div>
		</div>
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> 
				<input type="text" class="form-control" style="width:800px;"placeholder="이름" name="mname" />
			</div>
		</div>
		
	
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-earphone"></span>
				</span> 
				<input type="number" class="form-control" style="width:800px;"placeholder="전화번호" name="mtel" />
			</div>
		</div>
		
			<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-asterisk"></span>
				</span> 
				<input type="number" class="form-control" style="width:800px;"placeholder="주민번호 앞자리" name="mssn" />
			</div>
		</div>
			
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-envelope"></span>
				</span> 
				<input type="text" class="form-control" style="width:800px;"placeholder="이메일" name="memail" />
			</div>
		</div>
	
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-home"></span>
				</span> 
				<input type="text" class="form-control" style="width:800px;" placeholder="주소" name="maddress" />
			</div>
		</div>
		
	
		
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> 
				<input type="file" class="form-control" style="width:800px;"placeholder="선택" name="mattach" />
			</div>
		</div>
		
		<input type="submit" class="btn btn-info" value="회원 가입" />
	</form>
</body>
</html>