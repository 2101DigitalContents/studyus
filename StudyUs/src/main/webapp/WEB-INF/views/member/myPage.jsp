<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="/resources/css/member/myPage.css">
<title>마이페이지</title>
<link href="/resources/css/studyus/fullcalendar.min.css" rel="stylesheet" />
<link href="/resources/css/study/dist/css/style.min.css" rel="stylesheet">
<link href="/resources/css/study/adminmart.css" rel="stylesheet">
<link href="/resources/css/studyus/assignmentColor.css" rel="stylesheet">
<link href="/resources/css/studyus/calendar.css" rel="stylesheet">
<link href="/resources/css/studyus/reply.css" rel="stylesheet">
<script type="text/javascript" src="http://code.jquery.com/jquery-3.4.1.min.js"></script>
<script type="text/javascript" src="/resources/js/myPageCalendar.js"></script>
<script type="text/javascript" src="/resources/js/myPageReview.js"></script>
</head>
<body>
	<!-- menubar -->
	<jsp:include page="/WEB-INF/views/common/menubar.jsp" />
	<div class="grey-zone"></div>
	<div class="myPage-box">
		<div class="info-zone">
			<img src="/resources/images/${loginUser.mbPhoto}.png" class="rounded-circle" width="100" style="margin-top: -65px; margin-left: 15px;">
			<div class="mem-info">
				<a style="font-weight: bold; font-size: 20px;">${loginUser.mbNickname}</a>님<br>
				스터디 포인트 ${loginUser.mbReputation}
				<input type="hidden" id="mbNo" value="${loginUser.mbNo}">
			</div>
			<div class="btn-zone">
				<input type="button" value="내 정보 수정" class="myPage-btn" onclick="location.href='/member/myInfo'"> &nbsp;&nbsp;
				<input type="button" value="결제 관리" class="myPage-btn" onclick="location.href='/member/purchaseView'">
			</div>
		</div>
		<div class="box-zone">
			<div class="my-study">
				<div class="menu-mark">
					<span>나의 스터디</span>
				</div>
				<div class="study-zone">
					<c:if test="${!empty myStudyList}">
						<c:forEach var="study" items="${myStudyList}" varStatus="i">
								<div class="study-box" onclick="location.href='/study/${study.url}'">
									<div class='txt-box'> 
										<div class='study-name'><a>${study.studyName}</a></div>
										<div class='study-info'>
											<c:if test="${study.attRate >= 0 && study.attRate <= 29}">
												<span class='label'>출석률</span>
												<a class="value" style="color: red;">${study.attRate}%</a>
											</c:if>
											<c:if test="${study.attRate >= 30 && study.attRate <= 59}">
												<span class='label'>출석률</span>
												<a class="value" style="color: yellow;">${study.attRate}%</a>
											</c:if>
											<c:if test="${study.attRate >= 60}">
												<span class='label'>출석률</span>
												<a class="value" style="color: green;">${study.attRate}%</a>
											</c:if>
											<c:if test="${study.taskRate >= 0 && study.taskRate <= 29}">
												<span class='label'>과제완료율</span>
												<a class="value" style="color: red;">${study.taskRate}%</a>
											</c:if>
											<c:if test="${study.taskRate >= 30 && study.taskRate <= 59}">
												<span class='label'>과제완료율</span>
												<a class="value" style="color: yellow;">${study.taskRate}%</a>
											</c:if>
											<c:if test="${study.taskRate >= 60}">
												<span class='label'>과제완료율</span>
												<a class="value" style="color: green;">${study.taskRate}%</a>
											</c:if>
											<span class='label'>남은 과제</span><a class='value'>${study.remTask}개</a>
										</div>
									</div>
								</div>
						</c:forEach>
					</c:if>
					<c:if test="${empty myStudyList}">
						<div class='study-box'>
							<div class="txt-box" style="text-align: center;">
								<a style="font-weight: bold; font-size: 15px;">가입한 스터디가 없습니다.</a>
							</div>
						</div>
					</c:if>
				</div>
			</div>

			<div class="my-calender">
				<div class="menu-mark">
					<span>나의 일정</span>
				</div>
				<!-- ============================================================== -->
				<!-- Container fluid  -->
				<!-- ============================================================== -->
				<div class="scroll-zone">
					<div class="container-fluid">
						<div class="row">
							<div class="col-md-12">
								<div class="card">
									<div class="row">
										<div class="col-lg-12">
												<div id="calendar"></div>
											</div>
										</div>
									</div>
								</div>
	
								<div class="modal fade" id="info" tabindex="-1"
									aria-labelledby="infoLabel" aria-hidden="true"
									data-backdrop="static">
									<div
										class="modal-dialog modal-dialog-centered modal-dialog-scrollable">
										<div class="modal-content">
											<div id="modal-header" class="modal-header">
												<h5 class="modal-title text-white" id="infoLabel">일정</h5>
												<button type="button" class="close" data-dismiss="modal"
													aria-label="Close">
													<span aria-hidden="true" class="text-white">&times;</span>
												</button>
											</div>
											<div class="modal-body">
												<div class="form-group">
													<label for="name">일정명</label> <input id="name"
														class="form-control" type="text" readonly>
												</div>
												<div class="form-group">
													<label for="inDate">시작일시</label>
													<div class="clearfix">
														<input id="inDate" class="form-control float-left"
															type="date" readonly> <input id="inTime"
															class="form-control float-right" type="time" readonly>
													</div>
												</div>
												<div class="form-group">
													<label for="deDate">종료일시</label>
													<div class="clearfix">
														<input id="deDate" class="form-control float-left"
															type="date" readonly> <input id="deTime"
															class="form-control float-right" type="time" readonly>
													</div>
												</div>
											</div>
											<div class="modal-footer">
												<button id="info-btn" type="button" class="btn btn-primary">더보기</button>
											</div>
										</div>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			

				<div class="my-review">
					<div class="menu-mark">
						<span>나의 후기</span>
					</div>
					<div class="review-box">
						<div id="rList"></div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	<!--This page JavaScript -->
	<script src="/resources/css/study/assets/libs/jquery/dist/jquery.min.js"></script>
	<script src="/resources/css/study/assets/extra-libs/taskboard/js/jquery-ui.min.js"></script>
	<script src="/resources/css/study/assets/libs/bootstrap/dist/js/bootstrap.min.js"></script>
	<script src="/resources/css/study/dist/js/app-style-switcher.js"></script>
	<script src="/resources/css/study/dist/js/custom.min.js"></script>
	<script src="/resources/css/study/assets/libs/moment/min/moment.min.js"></script>
	<script src="/resources/css/study/assets/libs/fullcalendar/dist/fullcalendar.min.js"></script>
	<script	src="/resources/css/study/assets/extra-libs/taskboard/js/jquery-ui.min.js"></script>
	<script	src="/resources/css/study/assets/libs/fullcalendar/fullcalendar.js"></script>
	<script type="text/javascript" src="/resources/js/myPageCalendar.js"></script>
	<script type="text/javascript" src="/resources/js/myPageReview.js"></script>
</body>
</html>