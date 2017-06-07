<%-- 
    Document   : exam04
    Created on : 2017. 4. 28, 오후 2:07:51
    Author     : ijeongsu
--%>

<%@page contentType="text/html; charset=UTF-8" %>
<%@page import="com.mycompany.myapp.dto.Member" %>
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
    <div>
	<%String name ="홍길동";%>
	이름:<%=name%>
    </div>
    
    <div>
	<%Member member = new Member("홍길동", 30);%> 
	이름:<%=member.getName()%>
	나이:<%=member.getAge()%>
    </div>
    
    <br/>
    
    <div>
	<%request.setAttribute("name", "홍길동");%>
	이름:<%=request.getAttribute("name")%>
	이름:${name}
    </div>
    
    <div>
	<%request.setAttribute("member", new Member("홍길동", 30));%>
	이름:${member.name}
	이름:<%=((Member)request.getAttribute("member")).getName()%>
	나이:${member.age}
    </div>
    
    <div>
	이름:${name2}
	
	이름:${member2.name}
	나이:${member2.age}
    </div>
    
  </body>
</html>
