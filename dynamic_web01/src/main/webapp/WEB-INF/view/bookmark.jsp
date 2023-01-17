<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>즐겨찾기</title>
</head>
<body>
	<div>
		<c:url var="mainUrl" value="/" />
		<a href="${mainUrl }">메인으로</a>
	</div>
	<h2>즐겨찾기</h2>
	<c:url var="bookmarkUrl" value="/bookmark" />
	<form action="${bookmarkUrl }" method="post"> <!-- 주소를 입력한것은 GET요청이고 사용자가 방명록에 데이터를 입력하는 것은 post방식 -->
		<div>
			<input type="text" name="url">
		</div>
		<div>
			<input type="text" name="name">
		</div>
		<div>
			<button type="submit">저장</button>
		</div>
	</form>
<%--<ul>
		<% for(BookmarkDTO d: (List<BookmarkDTO>)request.getAttribute("data")) { %> <!-- setAttribute는 object로 받으니 getAttribute 쓸 때는 다시 (List<BookmarkDTO>)로 다운캐스팅 --> 
			<li>
				<a href="<%= d.getUrl() %>"><%=d.getName() %></a>
				<button type="button" onclick="location.href='./bookmark/update?id=<%=d.getId() %>'">수정</button> <!-- onclick 했을 때 해당 위치로 이동해라. id로 식별가능하게 함 -->
				<button type="submit" form="deleteForm<%=d.getId() %>">삭제</button> <!-- 동일한 id를 가지는 form을 찾아서 submit 버튼으로 사용 -->
				<form id="deleteForm<%=d.getId() %>" action="./bookmark/delete" method="post">  <!-- id="deleteForm뒤에 d.getId()로 id를 구분할 수 있게 한다. -->
					<input type="hidden" name="id" value="<%=d.getId() %>">
				</form>
			</li>
		<% } %>
	</ul>
 --%>	
	<ul>
		<c:forEach var="d" items="${requestScope.data }">
			<c:url var="bookmarkUpdateUrl" value="/bookmark/update">
				<c:param name="id" value="${d.id }" />
			</c:url>
			<c:set var="formId" value="deleteForm${d.id }" />
			<li>
				<a href="${d.url }">${d.name }</a>
				<button type="button" onclick="location.href='${bookmarkUpdateUrl}'">수정</button> 
				<button type="submit" form="${formId }">삭제</button> 
				<form id="${formId }" action="${bookmarkUrl }/delete" method="post"> 
					<input type="hidden" name="id" value="${d.id }">
				</form>
			</li>
		</c:forEach>
	</ul>
</body>
</html>
