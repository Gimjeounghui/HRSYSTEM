package com.gjh.hrsystem.common.util;
 
import java.util.HashMap;
 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
 
public class BoardUtil {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardUtil.class);
	
	private final int defaultRecordCountPerPage = 10; // 한 페이지당 게시되는 게시물 건 수
	private final int defaultPageSize = 5; 		      // 한 페이지당 게시되는 페이지 버튼 갯수 
	
	/*
	 * 게시판 페이징 구성에 필요한 수치들을 연산
	 * curPageNo = 현재 페이지 번호
	 * recordCountPerPage = 한 페이지당 게시되는 게시물 건 수
	 * pageSize = 페이지 리스트에 게시되는 페이지 건수
	 * totalRecordCount = 총 게시물 건 수
	 */
	public HashMap<String, Integer> calcBoardPagerElement(int curPageNo, int totalRecordCount, int recordCountPerPage, int pageSize) {

		// curPageNo가 1이거나 보다 작으면 1
		int currentPageNo = curPageNo <= 1 ? 1 : curPageNo;
		recordCountPerPage = recordCountPerPage < 1 ? defaultRecordCountPerPage : recordCountPerPage;
		pageSize = pageSize < 1 ? defaultPageSize : pageSize;
		
		logger.debug("- - - in calcBoardPagerElement - - -");
		logger.debug("- - - INPUT - - - ");
		logger.debug("현재 페이지 currentPageNo = " + currentPageNo);
		logger.debug("한 페이지당 게시되는 게시물 건 수 recordCountPerPage = " + recordCountPerPage);
		logger.debug("페이지 리스트에 게시되는  페이지 버튼 건수 pageSize = " + pageSize);
		logger.debug("전체 게시물 건 수 totalRecordCount = " + totalRecordCount);
		
		// 페이지 갯수
		int totalPageCount = ((totalRecordCount-1) / recordCountPerPage) + 1;
		
		// 페이지 리스트의 첫 페이지 번호
		int firstPageNoOnPageList = ((currentPageNo-1) / pageSize) * pageSize + 1;
                                   
		// 페이지 리스트의 마지막 페이지 번호
		int lastPageNoOnPageList = firstPageNoOnPageList + pageSize -1;
		                         
		// 이전 페이지
		int prevPageNoOnPageList = firstPageNoOnPageList-1 < 1 ? 1 : firstPageNoOnPageList - 1;
                                        	
		// 다음 페이지
		int nextPageNoOnPageList = lastPageNoOnPageList + 1;
		                             
		// 페이지 리스트의 마지막 페이지 번호가 전체 페이지 수보다 큰지 체크
		logger.debug("");
		logger.debug("페이지 리스트의 마지막 페이지 번호가 전체 페이지 수보다 큰지 체크");
		logger.debug(lastPageNoOnPageList + " > " + totalPageCount);
		logger.debug("");
		
		if(lastPageNoOnPageList > totalPageCount) {
		
			lastPageNoOnPageList = totalPageCount;
			nextPageNoOnPageList = totalPageCount;
		}
		
		logger.debug("  ");
		logger.debug("- - -  OUTPUT - - - ");
		logger.debug("총 페이지 개수 totalPageCount = " + totalPageCount);
		logger.debug("페이지 리스트의 첫 페이지 번호 firstPageNoOnPageList = " + firstPageNoOnPageList);
		logger.debug("페이지 리스트의 마지막 페이지 번호 lastPageNoOnPageList = " + lastPageNoOnPageList);
		logger.debug("이전 페이지 번호 prevPageNoOnPageList = " + prevPageNoOnPageList);
		logger.debug("다음 페이지 번호 nextPageNoOnPageList = " + nextPageNoOnPageList);
		
		HashMap<String, Integer> returnMap = new HashMap<String, Integer>();
		
		returnMap.put("currentPageNo", currentPageNo);
		returnMap.put("recordCountPerPage", recordCountPerPage);
		returnMap.put("pageSize", pageSize);
		returnMap.put("totalRecordCount", totalRecordCount);
		returnMap.put("totalPageCount", totalPageCount);
		returnMap.put("firstPageNoOnPageList", firstPageNoOnPageList);
		returnMap.put("lastPageNoOnPageList", lastPageNoOnPageList);
		returnMap.put("prevPageNoOnPageList", prevPageNoOnPageList);
		returnMap.put("nextPageNoOnPageList", nextPageNoOnPageList);
		returnMap.put("startPageNoOnPageList", 1); //처음 페이지
		returnMap.put("endPageNoOnPageList", totalPageCount); //끝 페이지
				
		return returnMap;
	}
	
	/*
	 * 게시물 조회 범위 연산
	 * curPageNo = 현재 페이지 번호
	 * recordCountPerPage = 한 페이지당 게시되는 게시물 건 수
	 * pageSize = 페이지 리스트에 게시되는 페이지 건수
	 * totalRecordCount = 전체 게시물 건 수
	 */
	public HashMap<String, Integer> calcDataRange(int curPageNo, int recordCountPerPage) {
		logger.debug("- - PARAM - -");
		logger.debug("현재 페이지 번호 : " + curPageNo);
		logger.debug("한 페이지당 게시되는 게시물 건 수 : " + recordCountPerPage);
		
		// 폐이지 처음 진입 시 curPageNo가 0이이면 (폐이지 버튼을 클릭하지 않았기 때문에) 1 폐이지로 처리하는 코드
		int currentPageNo = curPageNo <= 1 ? 1 : curPageNo;
		       
		// 혹시라도 defaultRecordCountPerPage (한 페이지당 게시되는 게시물 건 수)가 1미만(=0) 일 때와 1초과(=2)일 때 세팅하는 부분
		recordCountPerPage = recordCountPerPage < 1 ? defaultRecordCountPerPage : recordCountPerPage;
		
		logger.debug("");
		logger.debug("- - AFTER INIT - -");
		logger.debug("현재 페이지 번호  : " + curPageNo);
		logger.debug("한 페이지당 게시되는 게시물 건 수 : " + recordCountPerPage);
		logger.debug("");
		
		// 페이징 SQL 조건절에 사용되는 시작 rnum (start)
		int firstRecordIndex = ((currentPageNo - 1) * recordCountPerPage) + 1;
		// 페이징 SQL 조건절에 사용되는 마지막 rnum (end)
		int lastRecordIndex = currentPageNo * recordCountPerPage;

		// key:curPageNo(현재 페이지 번호), value:recordCountPerPage(한 페이지당 게시되는 게시물 건 수)
		HashMap<String, Integer> returnMap = new HashMap<String, Integer>();
		
		logger.debug("DB START(시작 값) firstRecordIndex = " + firstRecordIndex);
		logger.debug("DB END(끝 값) lastRecordIndex = " + lastRecordIndex);
		
		returnMap.put("firstRecordIndex", firstRecordIndex);
		returnMap.put("lastRecordIndex", lastRecordIndex);
				
		return returnMap;
	}
}