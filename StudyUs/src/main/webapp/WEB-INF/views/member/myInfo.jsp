<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/member/myPage.css">
<title>내 정보 수정</title>
</head>
<body>
	<!-- menubar -->
	<jsp:include page="/WEB-INF/views/common/menubar.jsp"/>
	
	<div class="myPage-box">
		<div class="info-zone">
			<img src="/resources/images/${loginUser.mbPhoto}.png" class="rounded-circle" width="100" style="margin-top: -10px; margin-left: 15px;">
			<div class="mem-info">
				<a style="font-weight: bold; font-size: 20px;">${loginUser.mbNickname}</a>님<br>
			</div>
		</div>
		<div class="info-box">
			<div class="main-text">프로필</div>
			<hr width="470" style="margin-bottom: 30px;">
			<div class="info-view">
				<form action="/member/modify" method="post">
					<div class="input-zone">
						<label for="mbId">아이디</label>
						<input type="text" name="mbId" value="${loginUser.mbId}" readonly class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbPassword">비밀번호</label>
						<input type="password" name="mbPassword" value="${loginUser.mbPassword}" class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbPwdcheck">비밀번호 확인</label>
						<input type="password" name="mbPwdcheck" value="${loginUser.mbPassword}" class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbName">이름</label>
						<input type="text" name="mbName" value="${loginUser.mbName}" class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbNickname">닉네임</label>
						<input type="text" name="mbNickname" value="${loginUser.mbNickname}" class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbEmail">이메일</label>
						<input type="text" name="mbEmail" value="${loginUser.mbEmail}" class="form-input">
					</div>
					<div class="input-zone">
						<label for="mbPhone">휴대폰 번호</label>
						<input type="text" name="mbPhone" value="${loginUser.mbPhone}" class="form-input">
					</div>
					<div class=""></div>
					<input type="submit" value="수정">
				</form>
			</div>
		</div>
	</div>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"/>
</body>
</html>