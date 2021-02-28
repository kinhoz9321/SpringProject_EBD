<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>my_report/private/insertform.do</title>
</head>
<body>
<div class="container">
	<h1>마이 독후감 작성 폼</h1>
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<!-- 구매처 링크 기능까지는 아직 완성 안됨. -->
		<div>
			<label for="search">책검색</label>
			<button><a href="${pageContext.request.contextPath }/bookList.do">검색</a></button>
		</div>
		<div>
			<label for="title">책제목</label>
			<input type="text" name="title" id="title"/>
		</div>
		<div>
			<label for="author">작가</label>
			<input type="text" name="author" id="author"/>
		</div>
		<div>
			<label for="link">구매처 링크</label>
			<input type="text" name="link" id="link"/>
		</div>
		<div>
			<label for="genre">장르</label>
			<select name="genre" id="genre">
				<option value="">선택안함</option>
				<option value="novel">소설</option>
				<option value="poem">시</option>
				<option value="assey">수필</option>
				<option value="history">역사</option>
				<option value="art">예술</option>
				<option value="religion">종교</option>
				<option value="humanities">인문</option>
				<option value="philosophy">철학</option>
				<option value="self-improvement">자기계발</option>
				<option value="1">★</option>
			</select>
		</div>
		<div>
			<label for="stars">평점</label>
			<select name="stars" id="stars">
				<option value="★">★</option>
				<option value="★★">★★</option>
				<option value="★★★">★★★</option>
				<option value="★★★★">★★★★</option>
				<option value="★★★★★">★★★★★</option>
			</select>
		</div>
		<div>
			<label for="image">이미지 첨부</label>
			<input type="file" name="image" id="image"
				accept=".jpg, .jpeg, .png, .JPG, .JPEG"/>
		</div>
		<div>
			<label for="content">내용</label>
			<textarea name="content" id="content"></textarea>
		</div>
		<button type="submit" onclick="submitContents(this);">저장</button>
		<button type="reset">취소</button><!-- 스마트 에디터 글은 삭제 안됨. -->
	</form>
</div>	
<script src="${pageContext.request.contextPath }/SmartEditor/js/HuskyEZCreator.js"></script>
<script>
	var oEditors = [];
	
	//추가 글꼴 목록
	//var aAdditionalFontSet = [["MS UI Gothic", "MS UI Gothic"], ["Comic Sans MS", "Comic Sans MS"],["TEST","TEST"]];
	
	nhn.husky.EZCreator.createInIFrame({
		oAppRef: oEditors,
		elPlaceHolder: "content",
		sSkinURI: "${pageContext.request.contextPath}/SmartEditor/SmartEditor2Skin.html",	
		htParams : {
			bUseToolbar : true,				// 툴바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseVerticalResizer : true,		// 입력창 크기 조절바 사용 여부 (true:사용/ false:사용하지 않음)
			bUseModeChanger : true,			// 모드 탭(Editor | HTML | TEXT) 사용 여부 (true:사용/ false:사용하지 않음)
			//aAdditionalFontList : aAdditionalFontSet,		// 추가 글꼴 목록
			fOnBeforeUnload : function(){
				//alert("완료!");
			}
		}, //boolean
		fOnAppLoad : function(){
			//예제 코드
			//oEditors.getById["ir1"].exec("PASTE_HTML", ["로딩이 완료된 후에 본문에 삽입되는 text입니다."]);
		},
		fCreator: "createSEditor2"
	});
	
	function pasteHTML() {
		var sHTML = "<span style='color:#FF0000;'>이미지도 같은 방식으로 삽입합니다.<\/span>";
		oEditors.getById["content"].exec("PASTE_HTML", [sHTML]);
	}
	
	function showHTML() {
		var sHTML = oEditors.getById["content"].getIR();
		alert(sHTML);
	}
		
	function submitContents(elClickedObj) {
		oEditors.getById["content"].exec("UPDATE_CONTENTS_FIELD", []);	// 에디터의 내용이 textarea에 적용됩니다.
		
		// 에디터의 내용에 대한 값 검증은 이곳에서 document.getElementById("content").value를 이용해서 처리하면 됩니다.
		
		try {
			elClickedObj.form.submit();
		} catch(e) {}
	}
	
	function setDefaultFont() {
		var sDefaultFont = '궁서';
		var nFontSize = 24;
		oEditors.getById["content"].setDefaultFont(sDefaultFont, nFontSize);
	}
</script>
</body>
</html>