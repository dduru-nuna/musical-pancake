<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>  <!-- 지시자 -->
<!-- 선언부 -->
<%! 
	public Random rand = new Random();

	public int getNumber() {           
		return rand.nextInt(10);
	}
%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>JSP 파일이 실행되었습니다.</h2>
	<form action="./main"> <!-- ./main 으로 다시 또 main 호출하게 함 -->
		<input type="number" name="num"> <!-- method 안쓰면 기본이 get 이다 -->
	</form>
	<h2><%= request.getParameter("num") %></h2> <!-- 서블릿에서 request 넘겨 줬으니 jsp 에서도 request 사용 가능 -->
	<h2><%=(Integer)request.getAttribute("number") %></h2> <!-- 다시 Interger 로 다운캐스팅 -->
	<ul>
	<!-- 스크립트릿 -->
	<% for(int i=getNumber(); i >= 0; i--) { %>
		<li><%= i %></li> <!-- 표현식 -->
	<% } %>
	</ul>
</body>
</html>