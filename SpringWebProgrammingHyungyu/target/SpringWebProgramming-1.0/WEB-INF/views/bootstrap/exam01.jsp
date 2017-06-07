<%-- 
    Document   : exam01
    Created on : 2017. 4. 26, 오후 12:37:38
    Author     : ijeongsu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
    <h3>Button</h3>
    <button>Default</button>
    <button type="button" class="btn btn-default">Default</button>
    <button type="button" class="btn btn-primary">Default</button>
    <button type="button" class="btn btn-success">Default</button>
    <button type="button" class="btn btn-info">Default</button>
    <a class="btn btn-info" href="/WebApplication">a 태그</a>
    <input type="button" class="btn btn-primary" value="input 태그"/>

    <h3>table</h3>
    <table class="table table-hover table-bordered">
	<tr class="success">
	  <td>번호</td>
	  <td>제목</td>
	  <td>글쓴이</td>
	</tr>
	<tr>
	  <td>1</td>
	  <td>오늘은 축구하는 날</td>
	  <td>성근</td>
	</tr>
	<tr>
	  <td>2</td>
	  <td>오늘은 축구하는 날</td>
	  <td>현규</td>
	</tr>		
    </table>

    <h3>table</h3>
    <img class="img-rounded" src="/WebApplication/resources/images/photo1.jpg" width="100px" height="100px"/>
    <img class="img-circle" src="/WebApplication/resources/images/photo1.jpg" width="100px" height="100px"/>
    <img class="img-thumbnail" src="/WebApplication/resources/images/photo1.jpg" width="100px" height="100px"/>

    <form>
	<div class="form-group">
	  <label for="exampleInputEmail1">Email address</label>
	  <input type="email" class="form-control" id="exampleInputEmail1" placeholder="Email">
	</div>
    </form>
    
  </body>
</html>
