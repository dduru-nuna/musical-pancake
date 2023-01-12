<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>방명록</title>
</head>
<body>
	<h2>방명록</h2>
	<form action="./visit" method="post"> <!-- 주소를 입력한것은 GET요청이고 사용자가 방명록에 데이터를 입력하는 것은 post방식 -->
		<div>
			<input type="text" name="nickname">
		</div>
		<div>
			<textarea rows="3" cols="25" name="context"></textarea>
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
</body>
</html>