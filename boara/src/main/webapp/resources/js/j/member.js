/*정준영*/
$(document).ready(function(){
   $('.pbtn').click(function(){
		// 데이터 읽어오고
		var page = $(this).attr('id');
		
		// 데이터 셋팅하고
		$('#nowPage').val(page);
		$('#frm').submit();
	});
   
	$('dd').click(function(){
		var msg = $(this).html();
		
		if(msg == '회원정보 수정'){
			$(location).attr('href', '/boara/member/editInfo.boa');	// 05.29 최이지 수정
		} else if(msg == '회원 탈퇴'){
			$(location).attr('href', '/boara/member/delMember.boa');	// 05.29 최이지 수정
		} else if(msg == '로그'){
			$(location).attr('href', '/boara/member/mylog.boa');
		} else if(msg == '구매글 리스트'){
			$('#frame').css('display', 'block');
		} else if(msg == '포인트 충전'){
			alert('준비중입니다.');		// 05.29 최이지 수정
		} else if(msg == '포인트 이용내역'){
			$(location).attr('href', '/boara/member/mypointhistory.boa');
		} else if(msg == '출석 이벤트'){
			alert('준비중입니다.');		// 05.29 최이지 수정
		} else {
			alert('js 확인해주세요!!');
		}
	});
	
	$('.btnbox').click(function(){
		var division = $(this).attr('id');
		$('#division').val(division);
		$('#frm1').submit();
	});
	
	
});