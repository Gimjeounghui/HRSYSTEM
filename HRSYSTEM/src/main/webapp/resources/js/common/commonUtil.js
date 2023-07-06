/**
 * 공통함수
 */
$(document).ready(function(){

});

//게시판 페이지 이동
function movePage(frmId, pageNo){

	console.log("공통 movePage");
	var $frm = $('form[name='+frmId+']');
	$frm.find('#currentPageNo').val(pageNo);
	$frm.target = frmId;
	$frm.submit();
}


//게시판 상세조회 이동
function moveDtlPage(frmId, actionUrl, contentId){
	var $frm = $('#'+frmId);

	$frm.attr('action', actionUrl);
	$frm.find("#contentId").val(contentId);
	//console.log($frm);
	$frm.submit();
}

//게시판 페이지 이동 (ajax 방식으로 할때)
function movePageForAjax(frmId, pageNo, ajaxfn){
	var $frm = $('form[name='+frmId+']');

	$frm.find('input[name=currentPageNo]').val(pageNo);
	eval(ajaxfn+'()');

}

//게시판 검색버튼 
function searchBtn(url) {
	
	var $form = $('#searchForm');
	$form.attr('action', url);
	$form.submit();
	
}
