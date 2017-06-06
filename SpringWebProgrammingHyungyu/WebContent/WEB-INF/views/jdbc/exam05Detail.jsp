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
		<script type="text/javascript">
			function handleBtnUpdate(){
				var bpassword = $("#bpassword").val();
				//console.log(bpassword);
				if(bpassword == ""){
					$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
					$("#bpassword").css("border-color","blue");
					return;
				}
				$.ajax({
					url: "exam05CheckBpassword",
					method: "post",
					//data: "bno=${board.bno}&bpassword=" + bpassword,
					data: {"bno":"${board.bno}", "bpassword":bpassword},
					success:function(data){
						if(data.result == "success"){
							//console.log(data.result);
							location.href="exam05Update?bno=${board.bno}";
						}else{
							//console.log(data.result);
							$("#bpassword").val("");
							$("#bpassword").attr("placeholder", "비밀번호가 다릅니다.");
							$("#bpassword").css("border-color","red");
						}
					}
				});
			}
			function handleBtnDelete(){
				var bpassword = $("#bpassword").val();
				//console.log(bpassword);
				if(bpassword == ""){
					$("#bpassword").attr("placeholder", "비밀번호를 입력하셔야 합니다.");
					$("#bpassword").css("border-color","blue");
					return;
				}
				$.ajax({
					url: "exam05CheckBpassword",
					method: "post",
					//data: "bno=${board.bno}&bpassword=" + bpassword,
					data: {"bno":"${board.bno}", "bpassword":bpassword},
					success:function(data){
						if(data.result == "success"){
							//console.log(data.result);
							location.href="exam05Delete?bno=${board.bno}";
						}else{
							//console.log(data.result);
							$("#bpassword").val("");
							$("#bpassword").attr("placeholder", "비밀번호가 다릅니다.");
							$("#bpassword").css("border-color","red");
						}
					}
				});
			}
		</script>
	</head>
<body>
	<h4>게시물 상세</h4>
	<hr />
	<form method="post"  enctype="multipart/form-data">
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> 
				<input type="text" class="form-control" placeholder="글번호" name="bno" value="${ board.bno }" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-user"></span>
				</span> 
				<input type="text" class="form-control" placeholder="제목" name="btitle" value="${ board.btitle }" disabled/>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-tag"></span>
				</span> 
				<input type="text" class="form-control" placeholder="글쓴이" name="bwriter" value="${ board.bwriter }" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> 
				<input type="text" class="form-control" placeholder="작성일" name="bdate" value="${ board.bdate }" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> 
				<input type="number" class="form-control" placeholder="조회수" name="bhitcount" value="${ board.bhitcount }" disabled />
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> 
				<textarea rows="5" cols="30" class="form-control" placeholder="내용" name="bcontent" disabled>${ board.bcontent }</textarea>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-camera"></span>
				</span> 
				<!-- <input type="file" class="form-control" placeholder="선택" name="battach" /> -->
				<a href="#" class="form-control" >${board.boriginalfilename}</a>
			</div>
		</div>
		<div class="form-group">
			<div class="input-group">
				<span class="input-group-addon"> <span
					class="glyphicon glyphicon-lock"></span>
				</span> 
				<input id="bpassword" type="password" class="form-control" placeholder="비밀번호" name="bpassword" />
			</div>
		</div>
		<!-- <input type="submit" class="btn btn-info" value="게시물작성" /> -->
		<a href="exam05" class="btn btn-success">목록</a>
		<input onclick="handleBtnUpdate()" type="button" href="exam05" class="btn btn-warning" value="수정"/>
		<input onclick="handleBtnDelete()" type="button" href="exam05" class="btn btn-danger" value="삭제"/>
		<!-- 
		<button>버튼</button>					// submit
		<input type="button" value="버튼"/>
		<input type="submit" value="버튼"/>  // submit
		<input type="cancel" value="버튼"/>
		
		<input type="image" src="button.png"/> // submit
		<img src="button.png"/> // submit기능이 없는 사진을 넣을때는 반드시 이 태그를 사용
		 -->
	</form>
</body>
</html>