<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<c:url var="mainUrl" value="/" />
<a href="${mainUrl }visit">방명록</a>
<c:if test="${sessionScope.login }">  <%--로그인 상태에서만 즐겨찾기 링크 모음 메뉴가 나타나게 설정 --%>
	<a href="${mainUrl }bookmark">즐겨찾기 링크 모음</a>
</c:if>
<a href="${mainUrl }board">게시판</a>
<c:choose>
	<c:when test="${sessionScope.login }">
		<a href="${mainUrl }logout">로그아웃</a>
		<a href="${mainUrl }myinfo">개인정보</a>
	</c:when>
	<c:otherwise>
		<a href="${mainUrl }login">로그인</a>
		<a href="${mainUrl }join">회원가입</a>
	</c:otherwise>
</c:choose>