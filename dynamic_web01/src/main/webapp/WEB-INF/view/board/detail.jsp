<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 페이지</title>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
</head>
<body>
	<c:url var="recommendUrl" value="/ajax/recommend" />
	<script type="text/javascript">
		function recommend(element, id, type) {
			$.ajax({
				type: "get",
				url: "${recommendUrl }",
				data: {
					id: id,
					type: type
				},
				dataType: "json",
				success: function(data) {
					if(data.redirect !== undefined) { //로그인체크필터에서 설정한 redirect 키
						let message = "추천/비추천은 회원만 할 수 있습니다. 로그인 페이지로 이동하시겠습니까?";
						if(confirm(message)) { //confirm : 확인 누르면 true, 취소 누르면 false 반환
							location.href = data.redirect;
						}
					} else {
						if(data.type === "success") {
							//추천,비추천을 눌렀을 때 비동기로 데이터 전송됨
							if(type === "good") {
								element.innerText = "추천 " + data.count
							} else if(type === "bad") {
								element.innerText = "비추천" + data.count
							}
						} else if(data.type === "error") {
							console.log(msg);
						}					
					}
				}
			});
		}
	</script>
	<c:url var="boardUrl" value="/board" />
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<div>
		<h1>${requestScope.data.title }</h1>
	</div>
	<div>
		<fmt:formatDate var="createDate" type="both" pattern="yyyy년 MM월 dd일 EEEE a KK시 mm분 ss초" value="${requestScope.data.createDate }" />
		<fmt:formatDate var="updateDate" type="both" pattern="yyyy년 MM월 dd일 EEEE a KK시 mm분 ss초" value="${requestScope.data.updateDate }" />
		작성자: ${requestScope.data.writer }<br>
		작성일: ${createDate } <br>
		수정일: ${updateDate } <br>
		조회수: ${requestScope.data.viewCnt }
	</div>
	<div id="viewer"></div>
	<div>
		<ul>
			<c:forEach var="image" items="${requestScope.images }">
				<c:url var="imagePath" value="${image.path }${image.uuid }" /> <!-- 실제 저장 파일은 uuid 로 저장 -->
				<li><a href="${imagePath }" download="${image.name }">${image.name }</a></li> <!-- 사용자가 다운로드 받을 때는 실제 사용자가 저장한 이름으로 다운 -->
			</c:forEach>
		</ul>
	</div>
	<div>                                           <!-- recommend(element, id, type) 함수 실행 -->
		<button class="btn btn-primary" onclick="recommend(this, ${requestScope.data.id }, 'good');">
		추천 ${requestScope.data.good }</button>		<!-- 기존 db에 기록되어 있던 추천수 보여줌 -->
		<button class="btn btn-danger" onclick="recommend(this, ${requestScope.data.id }, 'bad');">
		비추천 ${requestScope.data.bad }</button>
	</div>
	<div>
		<button onclick="location.href='${boardUrl }'">목록</button>
		<c:if test="${sessionScope.login }">
			<c:if test="${sessionScope.user.userId eq requestScope.data.writer }">
				<button onclick="location.href='${boardUrl }/update?id=${requestScope.data.id }'">수정</button>
				<button onclick="location.href='${boardUrl }/delete?id=${requestScope.data.id }'">삭제</button>
			</c:if>
		</c:if>
	</div>
	<script type="text/javascript"> 
		var viewer;
		window.onload = function() {
			<c:url var="boardDetailUrl" value="/board/detail" />
			$.ajax({
				url: "${boardDetailUrl }",
				data: {
					id: ${requestScope.data.id }					
				},
				type: "post",
				dataType: "json",
				success: function(data) {  //editor는 editor까지만, viewer는 editor.factory 까지 써줘야함
					viewer = new toastui.Editor.factory({
						el: document.querySelector("#viewer"),
						viewer: true, //뷰어로 사용
						initialValue: data.context //초기값
				    });
			    }
		   });
		}
	</script>
</body>
</html>