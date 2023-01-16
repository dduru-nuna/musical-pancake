<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Random" %>  <!-- 지시자 -->
<!-- 태그라이브러리를 import 했다고 생각하기(라이브러리가 우선 등록되야함). 사용할 이름을 지정하는게 prefix -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> <!-- prefix 명은 변경해도 되나 보통 다들 이렇게 쓴다 -->
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
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
	<%="값" %> -> ${"값" }<br>
	
	<h3>EL - Expression Language</h3> <!-- 가급적이면 연산기호 말고 키워드 사용하기 -->
	${10 + 20 }<br>
	${10 - 5 }<br>
	${10 div 3 }<br> <!-- jsp는 오류 못잡으니 무시하면 됨 -->
	${10 mod 3 }<br>
	${10 eq 10 }<br>
	${10 gt 10 }<br> <!-- ne, ge, lt, le 비교연산-->
	${true and true }<br>
	${true or ture }<br>
	${not true }<br>
	${empty x }<br> <!-- x 라는 변수에 저장되어 있는 값이 null 또는 빈문자열 이면 true 반환 -->
	${empty x ? "없음" : "있음" }<br>
	
	${"문자열"}${"문자열"}<br> <!-- 문자열 결합은 + 으로 안되고 붙여 써야한다. -->
	${10}${"문자열"}<br> <!-- 숫자와 문자열의 결합도 마찬가지 -->
	
	<h4>EL 로 request.getAttribute() 사용</h4>
	${requestScope.number }<br> <!-- 캐스팅 필요없음. 알아서 변환해줌 -->
	
	<h4>EL 로 request.getParameter() 사용</h4>
	${param.num }<br>
	
	<h3>JSTL - Core</h3>
	
	<h3>JSTL - Formatting</h3>
	
	<h3>JSTL - Function</h3>
</body>
</html>