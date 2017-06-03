<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="<%=application.getContextPath()%>/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="<%=application.getContextPath()%>/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			//자바스크립트는 대문자로 객체표현해도 되고 소문자로 해도됨.   봄에서도 마찬가지
			//window navigator 내장 변수의 이름이므로 그냥 갖다쓰면된다.
			console.log(window.outerWidth);
			console.log(window.outerHeight);
			console.log(window.innerWidth);
			console.log(window.innerHeight);
			var pop1;
			 function handleBtn1(){
			 pop1=  window.open("/WebApplication/javascript/exam09","pop1","width=300,height=200");
		 }
			 function handleBtn2(){          //닫기는 pop1으로 열기 객체를 받고 이를 받은 것을 닫기하는것으로 접근해야함.
			pop1.close();
		 }
		 function handleBtn3(){         
			work1 = window.setInterval(function() {            //javascript에서는 이것이 스래드 개념임.
				console.log(new Date());
			},1000);     //var선언안하면 전역변수.
			work2 = window.setInterval(function() {            //javascript에서는 이것이 스래드 개념임.
				console.log("hello");
			},1000);  
		 }
		 
		 function handleBtn4(){     
			window.clearInterval(work1);
			window.clearInterval(work2);
		 }
		 
		 function handleBtn5(){
			work3 =  window.setTimeout(function(){
				 console.log("Yahoo~");
			 },3000);  //3초후에 함수를 실행하라
		 }
		 
		 function handleBtn6(){
			 window.clearTimeout(work3);
		 }
		 
		  function handleBtn7(){
			 location.href="/WebApplication/javascript/exam09"
		 }
		
		 
		</script>
    </head>
    <body>
        <h1>BOM사용하기</h1>    
		
		<h3>팝업</h3>
		<button onclick="handleBtn1()" class="btn btn-warning">팝업 열기</button>   /*팝업띄울때만 의미있음*/
		<button onclick="handleBtn2()" class="btn btn-warning">팝업 닫기</button>
		
		<h3>주기적 실행</h3>
		<button onclick="handleBtn3()" class="btn btn-warning">시작</button>
		<button onclick="handleBtn4()" class="btn btn-warning">중지</button>
		
		<h3>지연 실행</h3>
		<button onclick="handleBtn5()" class="btn btn-warning">시작</button>
		<button onclick="handleBtn6()" class="btn btn-warning">중지</button>
		
		<h3>요청 경로 변경</h3>
		<button onclick="handleBtn7()" class="btn-warning">요청경로변경</button>
    </body>
</html>
