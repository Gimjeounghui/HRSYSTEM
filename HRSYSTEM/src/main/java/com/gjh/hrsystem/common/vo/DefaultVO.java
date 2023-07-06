package com.gjh.hrsystem.common.vo;

public class DefaultVO {

	private int no; 				// 번호
	private int start; 				// 검색할 시작 번호
	private int end; 				// 검색할 마지막 번호
	private int rnum; 				// 검색 되었을 때 몇번째 번호인지 확인하는 번호
	private int currentPageNo; 		// 현재 페이지 No
	private int totalRecordCount; 	// 전체 게시물 건 수
	private int totalPageCount; 	// 총 페이지의 갯수
	private int recordCountPerPage; // 페이지당 게시되는 게시물 건 수
	private int pageSize; 			// 페이지 리스트에 게시되는 페이지 건수
	private String sortName; 		// 정렬 대상 컬럼
	private String sortType; 		// 정렬 방식
	private String regDate; 		// 등록일
	private String modDate; 		// 수정일
	private String procFlag; 		// 추가(add), 수정(mod), 삭제(del) 구분값

	
	public String getProcFlag() {
		return procFlag;
	}

	public void setProcFlag(String procFlag) {
		this.procFlag = procFlag;
	}

	public String getModDate() {
		return modDate;
	}

	public void setModDate(String modDate) {
		this.modDate = modDate;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public int getCurrentPageNo() {
		return currentPageNo;
	}

	public void setCurrentPageNo(int currentPageNo) {
		this.currentPageNo = currentPageNo;
	}

	public int getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(int totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public int getTotalPageCount() {
		return totalPageCount;
	}

	public void setTotalPageCount(int totalPageCount) {
		this.totalPageCount = totalPageCount;
	}

	public int getRecordCountPerPage() {
		return recordCountPerPage;
	}

	public void setRecordCountPerPage(int recordCountPerPage) {
		this.recordCountPerPage = recordCountPerPage;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public String getSortName() {
		return sortName;
	}

	public void setSortName(String sortName) {
		this.sortName = sortName;
	}

	public String getSortType() {
		return sortType;
	}

	public void setSortType(String sortType) {
		this.sortType = sortType;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}
}