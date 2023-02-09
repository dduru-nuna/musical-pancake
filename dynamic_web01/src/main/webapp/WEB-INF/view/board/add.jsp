<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 추가 페이지</title>
<%@ include file="/WEB-INF/view/module/bootstrap.jsp" %>
<script src="https://code.jquery.com/jquery-3.6.3.js" integrity="sha256-nQLuAZGRRcILA+6dMBOvcRh5Pe310sBpanc6+QBmyVM=" crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://uicdn.toast.com/editor/latest/toastui-editor.min.css" />
<script src="https://uicdn.toast.com/editor/latest/toastui-editor-all.min.js"></script>
</head>
<body>
	<script type="text/javascript">
		function imageValid(element) {
			if(element.files.length > 3) {
				alert('이미지는 3개 까지만 선택할 수 있습니다.');
				element.value = "";
			}
		}
		function sendForm(form) {
			//Toast UI Editor 에 작성된 글 가져와서 전송할 폼에 넣기
			form.context.innerText = editor.getHTML(); //textarea에 담기
			form.submit(); //submit으로 보내기
			return false; //위에서 이미 submit 했으니 false 처리
		}
	</script>
	<div>
		<%@ include file="/WEB-INF/view/module/topnav.jsp" %>
	</div>
	<div>
		<h1>글 작성</h1>
	</div>
	<div>
		<c:url var="boardAddUrl" value="/board/add" />
		<form action="${boardAddUrl }" method="post" onsubmit="return sendForm(this);"> <!--enctype="multipart/form-data"-->
			<div>
				<label>제목</label>
				<input type="text" name="title">
			</div>
			<div>
				<label>내용</label>
				<div id="editor"></div> <!-- div에 작성한 내용을 textarea 로 넣어줘야함. (div 내용은 submit 안되서) -->
				<textarea style="display: none;" name="context"></textarea>
			</div>
			<!--div>
				<label>이미지 업로드</label>
				<input type="file" onchange="imageValid(this);" name="imageUpload" accept="image/*" multiple>
			</div-->
			<c:if test="${sessionScope.role.type eq 'ADMIN' }">
				<div>
					<label>공지사항</label>
					<input type="checkbox" name="notice" value="yes">
				</div>
			</c:if>
			<div>
				<button type="submit">저장</button>
				<button type="button" onclick="history.back();">취소</button> <%--history.back() : 뒤로가기 (자바스크립트기능) --%>
			</div>
		</form>
	</div>
<!--  비동기 이용하여 이미지 업로드 먼저 요청하고 서버에서는 받은 이미지를 저장처리하고 저장된 경로를 알려줌(응답, json형식)
	toastUI 에 콜백함수로 경로를 알려주면 에디터가 알아서 에디터 ui에 작성해줌 -->	
	<script type="text/javascript">
		const editor = new toastui.Editor({
			el: document.querySelector('#editor'), //위의 내용에 id='editor'
			height: "250px",
			hooks: {
				"addImageBlobHook": function(blob, callback) {
					//blob : 사용자가 선택한 이미지 파일
					//callback : 파일이 업로드 된 후 에디터에 표시할 이미지 주소를 전달하기 위한 콜백함수
					let formData = new FormData();
					formData.append("imageUpload", blob); //formData 객체의 append. 키: 값
					formData.append("location", "board");
					
					<c:url var="imageUploadUrl" value="/ajax/imageUpload" />
					$.ajax({
						url: "${imageUploadUrl }",
						type: "post",
						data: formData,
						dataType: "json",
						enctype: "multipart/form-data",
						processData: false,
						contentType: false,
						success: function(data) {
							callback(data.imageUrl);
						}
					})
				}
			}
		})
	</script>
</body>
</html>