<%@page contentType="text/html;charset=EUC-KR"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>JSP Page</title>
		<script>
			function handleBtnNaver(){
				
				console.log("handleBtnNaver()...");
				location.href="http://www.naver.com";
			}
			function handleBtnGoogle(){
				
				console.log("handleBtnGoogle()...");
				location.href="http://google.com";
			}
		</script>
	</head>
	<body>
		<h1>�±�����</h1>
		
		
		<h3>��ũ�±�</h3>
		<a href="http://www.naver.com">���̹�</a> <br/>
		
		<h3>��ư�±�</h3>
		<button  onClick="handleBtnNaver()">���̹�</button>
		<button  onClick="handleBtnGoogle()">����</button>
		<input type="button" onclick="handleBtnNaver()" value="���̹�"/>
		
		<h3>�̹����±�</h3>
		<img src="/WebApplication/resources/image/Hydrangeas.jpg" alt="Smiley face" width="300" height="300" />
		<input type="image" src="/WebApplication/resources/image/Hydrangeas.jpg"/>
		
		<h3>�����̳� �±�</h3>
		<div>
			<img src="/WebApplication/resources/image/Hydrangeas.jpg" alt="Smiley face" width="300" height="300" />
			<button id="btnNaver" onClick="handleBtnNaver()">���̹�</button>
		</div>
		
		<div>
			<img src="/WebApplication/resources/image/Hydrangeas.jpg" alt="Smiley face" width="300" height="300" />
			<button id="btnNaver" onClick="handleBtnNaver()">���̹�</button>
		</div>
		<h3>���±�</h3>
		<form>
			�̸�:<input type ="text"/><br/>
			����:<input type ="number"/><br/>
			�������:<input type="date"/><br/>
			����:<input type ="radio" name="sex"/>��<input type ="radio" name="sex"/>��<br/>
			���ɺо�: 
			<input type="checkbox"/>�ڹ�
			<input type="checkbox"/>�ڹ�FX
			<input type="checkbox"/>������ <br/>
			<input type="button" value="�Ϲݹ�ư"/>
			<input type="reset" value="���¹�ư"/>
			<input type="submit" value="�����ư"/>
		</form>
	</body>
</html>
