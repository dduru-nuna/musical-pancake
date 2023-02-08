<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<c:url var="userIdCheck" value="/ajax/userIdCheck" />
	<script type="text/javascript">
		//유효 아이디인지 확인 안하고 가입 버튼 누르는 경우 방지
		valid = false;
		//element(input태그) 옆이 비어있으면 span 을 추가하고 있으면 그대로 사용
		function usernameCheck(element) {
			if(element.nextElementSibling === null) {
				var s = document.createElement("span");
				element.after(s);
			} else {
				var s = element.nextElementSibling;
			}
			//Ajax 사용
			$.ajax({
				type: "get",  //get 또는 post 로 서버에 요청을 구분하여 보내기 위해 사용
				url: "${userIdCheck }",   //서버 url 주소. controller에 맵핑된 주소
				data: {   //서버에 전송할 데이터
					userId: element.value  //사용자가 입력한 아이디값
				},  
				dataType: "json",  //서버에서 응답하는 데이터 종류(json, xml, html, text) (예상되는 형식)
				success: function(data) {  //성공적으로 응답이 왔을 때 동작하는 함수
					console.log("응답이 성공적으로 왔습니다.");
					if(data.msg === "OK") {  //응답되는 data 객체에 json으로 설정한 키msg
						s.style = "color: green;";
						s.innerText = "사용 가능한 아이디 입니다."
						valid = true;
					} else if(data.msg === "Fail") {
						s.style = "color: red;";
						s.innerText = "사용할 수 없는 아이디 입니다."
						valid = false;
					} else {
						console.log("알 수 없는 값 입니다.");
						valid = false;
					}
				},
				error: function(data) {  //응답이 왔지만 데이터 처리에 대한 문제가 발생했을 때 동작하는 함수
					console.log("응답이 왔지만 문제가 발생함");
					console.log(data);
				},
				complete: function(data) {  //응답이 success,error 상관없이 동작이 필요할 때 사용하는 함수
					console.log("서버로부터 응답이 왔습니다. 성공/실패를 구분하지 않음");
				}
				//success는 거의 필수적으로 사용되나 error,complete는 반드시 필요한 것은 아님
			});
		}
		
		function validCheck() {
			if(valid) {
				return true;
			} else {
				alert("아이디를 확인하세요");
				return false;
			}
		}
		
	</script>
	<h1>회원가입</h1>
	<c:url var="joinUrl" value="/join" />
	<form action="${joinUrl }" method="post" onsubmit="return validCheck();">
		<div>
			<label>아이디</label>
			<input type="text" name="userId" onchange="usernameCheck(this);">
		</div>
		<div>
			<label>패스워드</label>
			<input type="password" name="password">
		</div>
		<div>
			<label>이메일</label>
			<input type="email" name="email" value="${param.email }">
		</div>
		<button type="submit">가입</button>
	</form>
</body>
</html>