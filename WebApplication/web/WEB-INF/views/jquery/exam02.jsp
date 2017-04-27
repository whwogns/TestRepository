<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no">
		<title>JSP Page</title>
		<link href="/WebApplication/resources/bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
		<script src="/WebApplication/resources/jquery/jquery-3.2.1.min.js" type="text/javascript"></script>
		<script src="/WebApplication/resources/bootstrap-3.3.7-dist/js/bootstrap.min.js" type="text/javascript"></script>
		<script>
			$(function(){      // 모든 것이 실행된 후 맨나중에 실행됨.   이후 $function은 순서대로 진행  //   $ = jQuery을 의미.
				
				var img = $("#img1");
				img.attr("src","/WebApplication/resources/image/photo01.jpg");
				
			});
			
			$(function(){      // 모든 것이 실행된 후 맨나중에 실행됨.
				
				console.log("log1");
				
			});
			
			$(function(){      // 모든 것이 실행된 후 맨나중에 실행됨.
				
				console.log("log2");
				
				
			});
		
		</script>
    </head>
    <body>
        <h1>로드 완료 함수</h1>
		<img id="img1" width="100px" height="100px"/>
    </body>
</html>
