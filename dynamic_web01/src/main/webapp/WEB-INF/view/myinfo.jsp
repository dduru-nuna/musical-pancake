<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>개인 정보 수정</title>
<c:url var="staticUrl" value="/static" />
<link type="text/css" rel="stylesheet" href="${staticUrl }/bs5/css/bootstrap.min.css">
<script type="text/javascript" src="${staticUrl }/bs5/js/bootstrap.bundle.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function previewImage(element) {
			console.log(element);
			console.log(element.files);
			var preview = document.getElementById("preview");
			preview.src = URL.createObjectURL(element.files[0]);
		<!--사용자 컴퓨터에 있는 이미지 경로를 url 형식으로 만들어주기 위해 URL.createObjectURL 이 사용됨(브라우저가 생성하는 임시주소)-->
		}
	</script>
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<h1>개인 정보 수정</h1>
	<c:url var="myinfoUrl" value="/myinfo" />             <!-- 파일 업로드를 위해선 반드시 작성. type=file 인 경우도 무조건 작성 -->
	<form action="${myinfoUrl }/uploadImage" method="post" enctype="multipart/form-data">
		<div style="border-style: solid; board-color: black; width: 150px; height: 150px;">
			<img id="preview" alt="여기에 이미지가 표시됩니다." width="150px" height="150px">
		</div>
		<label>이미지 선택</label>             <!-- accept 에 파일종류.확장자 설정하여 파일선택 제한 걸 수 있음 (절대적인 제한은 아님) -->
		<input type="file" name="imageFile" onchange="previewImage(this);" accept="image/*"> 
		<div>
			<button type="submit">전송</button>
		</div>
	</form>
	<form action="${myinfoUrl }" method="post">
		<div>
			<label>아이디</label>
			<input type="text" value="${sessionScope.user.userId }" disabled>
		</div>
		<div>
			<label>현재 패스워드</label>
			<input type="password" name="password">
		</div>
		<div>
			<label>변경할 패스워드</label>
			<input type="password" name="changePass">
		</div>
		<div>
			<label>이메일 주소</label>
			<input type="email" name="email" value="${sessionScope.user.email }">
		</div>
		<div>
			<button type="submit">변경하기</button>
		</div>
	</form>
</body>
</html>