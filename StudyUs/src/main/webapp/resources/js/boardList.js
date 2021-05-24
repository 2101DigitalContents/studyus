var page = 1;
var isEnd = false;

$(function() {
    getList();
    
    $(window).on("scroll", function() {
    	var scrollHeight = $(document).height();
    	var scrollPosition = $(window).height() + $(window).scrollTop();		

    	$("#scrollHeight").text(scrollHeight);
    	$("#scrollPosition").text(scrollPosition);
    	$("#bottom").text(scrollHeight - scrollPosition);

    	if (scrollPosition > scrollHeight - 500) {			
    		page++;
        	getList();
    	}
    });
})

function getList() {
	if(isEnd == true){
        return;
    }
	
	$.ajax({
		url : "/study/boardScroll",
		type : "get",
		dataType : "json",
		data : {"page": page},
		success : function(data) {
			bList = data.boardList;
			max = data.maxPage
			if(page == max) {
				isEnd = true;
			}
			
			var html = "";
			for(var i in bList) {
				// card
				var cardOpen = "<div id='div" + bList[i].boNo + "' class='card' onclick=\"location.href='/study/board/detail?boNo=" + bList[i].boNo + "'\" style='cursor:pointer;'>";
				
				// body
				var bodyOpen = "<div class='card-body'>";
					var category = "";
					switch(bList[i].boCategory) {
					case 1: category = "<span class='tags tag-free'>자유</span>";
						break;
					case 2: category = "<span class='tags tag-share'>공유</span>";
						break;
					case 3: category = "<span class='tags tag-qna'>질문</span>";
						break;
					}
				var title = 
					"<h4 class='card-title'>" +
					category +
					bList[i].boTitle +
					"</h4>";
				var subtitle = 
					"<div class='row'>" +
					"<h6 class='card-subtitle col-6'>" +
					"<img src='/resources/images/" + bList[i].member.mbPhoto + ".png' class='rounded-circle'>&nbsp;&nbsp;" + bList[i].member.mbNickname + "</h6>" +
					"<h6 class='card-subtitle col-6' style='text-align:right'>" + bList[i].boInsertDate +"</h6>" +
					"</div>";
				var bodyEnd = "</div>";
				
				var file = "";
				if(bList[i].boFileName != null) {
					file = "<div class='card-body file-box'>" + bList[i].boFileName + "</div>";
				}
				
				var content = "<div class='card-body' id='list-content'><p>" + bList[i].boContents + "</p></div>"
				
				var cardEnd = "</div>";
				
				html = cardOpen + bodyOpen + title + subtitle + bodyEnd + file + content + cardEnd;
				$("#container").append(html);
				
				// reply
				getReplyOne(bList[i].boNo);
			}
		},
		error : function() {
			alert("전송 실패!");
		}
	});
}

function getReplyOne(boMotherNo) {
	$.ajax({
		url : "/study/board/replyOne",
		type : "get",
		dataType : "json",
		data : {"boMotherNo": boMotherNo},
		success : function(data) {
			var board = data.bOne;
			var cnt = data.count;
			console.log(board);//////////////////
			
			var reply = "";
			if(board != null) {
				var replyOpen = 
					"<div class='card-body'>" +
					"<h6 class='card-subtitle' style='float:right;'>댓글 " + cnt + "</h6>" +
					"<hr>";
				var replyContent =
					"<div class='reply-box list-reply'>" +
					"<div><img src='/resources/images/" + board.member.mbPhoto + ".png' class='rounded-circle'>&nbsp;" +
					"<span>" + board.member.mbNickname + "</span>&nbsp;" +
					"<span>" + board.boInsertDate + "</span></div>" +
					"<div>" + board.boContents + "</div></div>";
				var replyEnd = "</div>";
				
				reply = replyOpen + replyContent + replyEnd;
			}
			
			$("#div" + boMotherNo).append(reply);
		},
		error : function() {
			alert("전송 실패!");
		}
	});
}