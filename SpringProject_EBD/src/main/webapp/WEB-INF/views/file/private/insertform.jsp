<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>북클라우드 글 작성</title>
<jsp:include page="../../include/resource.jsp"></jsp:include>
<style>
	/*전체 페이지 폰트 적용*/
	*{
		font-family: 'Gothic A1', sans-serif;
	}
	.head{
		text-align: center;
	}
	
	.row{
		margin-bottom: 10px;
	}
	
	.btn-file{
        position: relative;
        overflow: hidden;
        /* 내용이 넘치면 자른다 */
    }
    .btn-file input[type=file] {
    	/* 부모 기준으로 움직인다? */
        position: absolute;
        top: 0;
        right: 0;
        
        min-width: 100%;
        min-height: 100%;
        font-size: 100px;
        text-align: right;
        
         /* 투명도 */
        filter: alpha(opacity=0);
        opacity: 0;
        outline: none;
        background: white;
        cursor: inherit;
        display: block;
    }
    
    /*버튼 기본 노랑*/
    .btn {
    	background-color:#F7DC6F ;
    }
    /*버튼 호버시 연한 노랑*/
    .btn:hover{
    	background-color:#FBEEE6;
    }
    /*버튼안에 링크 걸려있을시 적용할 css*/
    .btn>a{
    	color:#212529;
    	text-decoration: none;
    }
    
    /* 스마트 에디터 전체 화면 보이게 하는 css */
    #content{
		width: 99.5%;
		height: 400px;
	}
</style>
</head>
<body>
<jsp:include page="../../include/navbar.jsp">
	<jsp:param value="file" name="thisPage"/>
</jsp:include>
<%-- jumborton --%>
<jsp:include page="../../include/file_insertform_jumbotron.jsp"></jsp:include>
<div class="container">
	<!-- 독후감 양식 파일 업로드(게시글) 추가 폼-->
	<form action="insert.do" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-2">
				<label for="title">제목</label>
			</div>
			<div class="col">
				<input class="form-control" type="text" id="title" name="title" placeholder="제목을 입력해 주세요." />
			</div>
		</div>
	 	<!-- 파일 업로드  -->
	 	<div class="row">
	 		<div class="col-2">
	 			첨부 파일
	 		</div>
	 		<div class="col-8" style="padding-right:0px;">
	 			<input class="form-control" type="text" id="fileName2" placeholder="파일을 첨부해주세요" disabled/>
	 			<small class="text-muted">공유할 독후감 양식파일을 넣어주세요.</small>
	 		</div>
	 		<div class="col" style="padding-left:5px;">
	 			<label for="myFile" class="btn btn-file">파일 선택
		 			<input type="file" name="myFile" id="myFile" onchange="reviewUploadImg2(this);" />
		 		</label>
	 		</div>
	 	</div>
	 	<!-- 이미지 업로드 -->
	 	<div class="row">
	 		<div class="col-2">
	 			이미지
	 		</div>
	 		<div class="col-8" style="padding-right:0px;">
	 			<input class="form-control" type="text" id="fileName" placeholder="이미지를 첨부해주세요" disabled/>
	 			<small class="text-muted">예시 사진을 넣어주세요.</small>
	 		</div>
	 		<div class="col" style="padding-left:5px;">
	 			<label for="myImg" class="btn btn-file" >이미지 선택
		 			<input type="file" name="myImg" id="myImg" onchange="reviewUploadImg(this);"
		 			accept=".jpg, .jpeg, .png, .JPG, .JPEG"/>
		 		</label>
	 		</div>
	 	</div>
	 	<div class="form-group">
		    <textarea class="form-control" type="text"  name="content" id="content"></textarea>
		</div>
	 	<div class="text-center" style="margin-top:30px; margin-bottom:30px;">
	 		<button class="btn" type="submit" onclick="submitContents(this);" >등록</button>
	 	</div>
	 </form>
	
</div>
<script>
   //이미지를 등록할 때마다 호출되는 함수 등록
   function reviewUploadImg(fileObj){
         var filePath = fileObj.value; //파일경로
         var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);//파일이름
         var fileKind = fileName.split(".")[1];//파일유형
         document.getElementById('fileName').value=fileName; //input text에 파일의 이름 들어감 
      }
   
   //파일을 등록할 때마다 호출되는 함수 등록
   function reviewUploadImg2(fileObj){
         var filePath = fileObj.value; //파일경로
         var fileName = filePath.substring(filePath.lastIndexOf("\\")+1);//파일이름
         var fileKind = fileName.split(".")[1];//파일유형
         document.getElementById('fileName2').value=fileName; //input text에 파일의 이름 들어감 
      }
</script>

<!-- SmartEditor 에서 필요한 javascript 로딩  -->
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