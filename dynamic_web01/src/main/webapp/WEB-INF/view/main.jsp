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
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
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
	${true or true }<br>
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
	<h4>변수 설정</h4>
	          <!--변수명       값 -->
	<c:set var="name" value="10" />
	${name }<br>
	
	<h4>변수 삭제</h4>
	<c:remove var="name" />
	${empty name ? "없음" : "있음" }<br>
	
	<h4>조건문</h4>
	<c:set var="num" value="10" />
	     <!-- 조건식. EL 형식으로 작성 -->
	<c:if test="${num eq 10 }">
		 <!-- 조건식이 참일 때 출력할 내용 -->
		num에 저장된 값은 10 입니다.
	</c:if>
	<br>
	<c:choose>
		<c:when test="${num lt 5 }">
			<!-- 조건식이 참일 때 출력 -->
			num에 저장된 값은 5보다 작습니다.
		</c:when>
		<c:when test="${num lt 10 }">
			<!-- 첫번째 조건식이 거짓이고 두번째 조건식이 참일 때 출력 -->
			num에 저장된 값은 5이상이고 10미만입니다.
		</c:when>
		<c:otherwise>
		<!-- 모든 조건식이 거짓일 때 출력. otherwise -> else 에 해당하는 부분. 생략 가능 -->
			num에 저장된 값은 10 이상입니다.
		</c:otherwise>
	</c:choose>
	<br>
	
	<h4>반복문</h4>                       <!-- 2씩 증가하게 -->
	<c:forEach var="i" begin="0" end="5" step="2">
		${i } ,
	</c:forEach>
	<br>
	
	<c:set var="arr">
		a, b, c, d, e, f
	</c:set>
	               <!-- items 에는 배열 또는 리스트컬렉션 담기, varStatus 로 상태정보 확인 "loop"=이름. 0부터 시작->index, 1부터 시작->count, 첫번째반복/마지막반복 확인가능 -->
	<c:forEach var="i" items="${arr }" varStatus="loop">
		값: ${i } | index: ${loop.index } | count: ${loop.count } | first: ${loop.first } | last: ${loop.last } <br>
	</c:forEach>
	<br>
	            <!-- 변수명          문자열             구분문자 -->
	<c:forTokens var="s" items="010-1234-5678" delims="-">
		${s }<br>
	</c:forTokens>
	<br>
	
	<h4>URL 주소 생성</h4>
	<c:url var="myUrl" value="/home" /> <!-- context root 자동 생성. 때문에 나중에 context root 가 변경되어도 c:url 이 자동으로 가져온다. -->
	${myUrl }<br>
	
	<c:url var="myUrl" value="/home">
		<c:param name="name" value="value" />
		<c:param name="key" value="context" />
	</c:url>
	${myUrl }<br>
	
	<h3>JSTL - Function</h3>
	<h4>contains(전체문자열, 일부문자열)</h4>
	${fn:contains("Hello JSTL Tag Library", "JSTL") }
	
	<h4>containsIgnoreCase(전체문자열, 일부문자열)</h4> <!-- 대소문자 구분 안함 -->
	${fn:containsIgnoreCase("Hello JSTL Tag Library", "jstL") } 
	
	<h4>replace(전체문자열, 변경전문자열, 변경후문자열)</h4>
	${fn:replace("Hello JSTL Tag Library", "Tag", "태그") }
	
	<h4>split(전체문자열, 분리구분문자)</h4>
	<c:forEach var="s" items="${fn:split('Hello JSTL Tag Library', ' ') }">
		${s }<br>
	</c:forEach>
	
	<h4>toUpperCase(전체문자열)</h4>
	${fn:toUpperCase("Hello JSTL Tag Library") }
	
	<h4>toLowerCase(전체문자열)</h4>
	${fn:toLowerCase("Hello JSTL Tag Library") }
	
	<h4>trim(전체문자열)</h4>
	${fn:trim("      Hello JSTL Tag Library      ") }
	
	<h4>length(전체문자열)</h4>
	${fn:length("Hello JSTL Tag Library") }
	
	<h4>substring(전체문자열, 시작위치, 끝위치)</h4>
	${fn:substring("Hello JSTL Tag Library", 6, 10) }
	
	<h3>JSTL - Formatting</h3>
	<h4>숫자 포멧</h4>
	<c:set var="num1" value="123456789" />
	<c:set var="num2" value="12345.6789" />
	<c:set var="num3" value="0.1234" />
	<!-- 천단위 구분 -->
	<fmt:formatNumber value="${num1 }" type="number" /><br>
	<fmt:formatNumber value="${num2 }" type="number" /><br>
	<!-- 천단위 구분 삭제 -->
	<fmt:formatNumber value="${num1 }" type="number" groupingUsed="false" /><br>
	<fmt:formatNumber value="${num2 }" type="number" groupingUsed="false" /><br>
	
	<fmt:setLocale value="ko_KR" /> <!-- 통화 표기 지역 변경도 가능 -->
	<fmt:formatNumber value="${num1 }" type="currency" pattern="###,###,###원" /><br>
	<fmt:setLocale value="en_US" />
	<fmt:formatNumber value="${num2 }" type="currency" currencySymbol="달러" /><br>
	
	<fmt:formatNumber value="${num3 }" type="percent" /><br>
	<fmt:formatNumber value="${num3 }" type="percent" maxFractionDigits="2" /><br> <!-- 소수점자리수 포함 -->
	
	<h4>날짜 포맷</h4>
	<c:set var="now" value="<%=new java.util.Date() %>" />
	<fmt:setLocale value="ko_KR" />
	<fmt:formatDate value="${now }" type="date" /><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="short" /><br>
	<fmt:formatDate value="${now }" type="date" dateStyle="long" /><br>
	
	<fmt:setLocale value="en_US" />
	<fmt:formatDate value="${now }" type="time" /><br>
	<fmt:formatDate value="${now }" type="time" timeStyle="short" /><br>
	<fmt:formatDate value="${now }" type="time" timeStyle="long" /><br>
	
	<fmt:formatDate value="${now }" type="both" /><br>
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="short" /><br>
	<fmt:formatDate value="${now }" type="both" dateStyle="short" timeStyle="long" /><br>
	
	<fmt:setLocale value="ko_KR" />
	<fmt:formatDate value="${now }" type="both" pattern="yyyy-MM-dd a hh:mm:ss E요일" /><br>
	                       <!-- 문자열 형식 값을 date 형식으로 변경. 패턴으로 원하는 형태 만들기 -->
	<fmt:parseDate var="pDate" value="2023-01-17" pattern="yyyy-MM-dd" /><br>
	<fmt:formatDate value="${pDate }" type="date" /> <!-- 변환된 데이터를 출력할 때 원하는 형태로 출력 가능 -->
	
	<hr>
	<fmt:setTimeZone value="GMT-1" />
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="medium" /><br>
	
	<fmt:setTimeZone value="GMT+1" />
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="medium" /><br>
	
	<fmt:setTimeZone value="GMT" />
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="medium" /><br>
	
	<fmt:setTimeZone value="GMT+9" />
	<fmt:formatDate value="${now }" type="both" dateStyle="long" timeStyle="medium" /><br>
</body>
</html>