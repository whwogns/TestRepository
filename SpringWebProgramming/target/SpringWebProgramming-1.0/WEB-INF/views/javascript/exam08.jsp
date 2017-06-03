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
			//객체생성
			var car = {            //{}는 객체의 표기(=JSON)
				//FIELD(속성)
				"model":"승용차" ,    //구분자로   ,를 넣어야함.
				"company":"현대",
				"speed":0,
				"start":function(){          //메소드 선언
					console.log("시동을 겁니다.")
				},    
				"setSpeed":function(speed){
					this.speed = speed;
				},
				"getSpeed":function(){
					return this.speed;
				}
			};
			
			//객체 필드(속성)값 읽기 및 수정
			console.log(car.model);
			car.company="기아";
			console.log(car.company);
			car.speed=60;     //값 수정가능
			console.log(car.speed);
			
			//메소드 호출
			car.start();
			car.setSpeed(100);
			console.log(car.getSpeed());
		</script>
    </head>
    <body>
        <h1>자바스크립트 객체</h1>
    </body>
</html>
