<%-- 
    Document   : exam01
    Created on : 2017. 4. 28, 오전 11:15:21
    Author     : ijeongsu
--%>

<%@page import="java.util.Calendar"%>
<%@page contentType="text/html; charset=UTF-8" %>
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
    <h1>다른 패키지 클래스 사용</h1>
    <%@include file="exam02_include.jsp" %>
  </body>
</html>
