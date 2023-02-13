<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>메인 페이지</title>
</head>
<body>
	<h1>메인 페이지입니다.</h1>
	${requestScope.test }
	
	Page 객체 : 해당 페이지에서만 유효하게 사용할 수 있다.
	지역변수 -> {pageScope }
	해당 속성명으로 저장된 객체 반환 -> ${pageScope.속성명 }
	반환 받은 객체의 멤버 변수명으로 값 반환 -> ${pageScope.속성명.멤버변수명 }
	
	Request 객체 : 요청에 대한 응답이 완전히 처리 되기 전까지 유효하게 사용할 수 있다.
	Request 객체 -> ${requestScope }
	해당 속성명으로 저장된 객체 반환 -> ${requestScope.속성명 }
	반환 받은 객체의 멤버 변수명으로 값 반환 -> ${requestScope.속성명.멤버변수명 }
	
	Session 객체 : 몇번의 요청이 발생하든 동일한 세션ID를 사용하여 요청을 할 때까지 유효하게 사용할 수 있다.
	              (세션ID는 브라우저 별로 제공)
	Session 객체 -> ${sessionScope }
	해당 속성명으로 저장된 객체 반환 -> ${sessionScope.속성명 }
	반환 받은 객체의 멤버 변수명으로 값 반환 -> ${sessionScope.속성명.멤버변수명 }
	
	쿠키 -> ${cookie }
	해당 쿠키명으로 저장된 쿠키 객체 반환 -> ${cookie.쿠키명 }
	쿠키값 반환 -> ${cookie.쿠키명.value }
	쿠키명 반환 -> ${cookie.쿠키명.name }
	
	Context 객체 : 서버 프로그램이 동작하는 동안 유효하게 사용할 수 있다. (일종의 전역 속성처럼 사용 가능)
	서블릿컨텍스트 객체 -> ${applicationScope }
	해당 속성명으로 저장된 객체 반환 -> ${applicationScope.속성명 }
	반환 받은 객체의 멤버 변수명으로 값 반환 -> ${applicationScope.속성명.멤버변수명 }
</body>
</html>