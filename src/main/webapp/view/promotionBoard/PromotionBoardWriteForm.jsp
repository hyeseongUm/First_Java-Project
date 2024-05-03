<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>


<div class="promotionBoard">
<div class="board__nav">
	<a href="/freeboard/FreeBoardList">자유게시판</a> <a class="board__selected"
		href="PromotionBoardList">홍보게시판</a>
</div>
</div>

<form action="PromotionBoardWriteReg" method="post">

	<div class="board__write--title">
		<div>작품명</div>
		<div >
			<textarea name="nTitle" cols="168" rows="2" readonly="readonly"
				value="${param.title }">${param.title } </textarea>
		</div>
	</div>

	<div class="board__write--artist">
		<div>작가명</div>
		<div>
			<textarea name="mNickname" cols="168" rows="2" readonly="readonly"
				value="${param.artist }">${param.artist }</textarea>
		</div>
	</div>
	
		<div class="board__write--artist">
			<div>제목</div>
			<div><input class="board__modify--input" type="text" name="title" value="${dto.title }" /></div>
		</div>
		
		<div class="board__write--artist">
			<div>내용</div>
			<div class="board__textarea"><textarea  name="content" cols="168" rows="10">"${dto.content }"</textarea></div>
		</div>

		<div>
			<div colspan="2" align="center"><input type="submit" value="작성" class="board__status"/>
				<a href="PromotionBoardList" class="board__status">취소</a></div>
		</div>
</form>








