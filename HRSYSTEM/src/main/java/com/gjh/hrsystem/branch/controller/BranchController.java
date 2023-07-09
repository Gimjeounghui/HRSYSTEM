package com.gjh.hrsystem.branch.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.gjh.hrsystem.branch.service.BranchService;
import com.gjh.hrsystem.branch.vo.BranchVO;
import com.gjh.hrsystem.common.util.BoardUtil;

@Controller
@RequestMapping("/branch")
public class BranchController {
	
	@Autowired
	private BranchService branchService;
	
	@RequestMapping("/branchList")
	public String branchList(@ModelAttribute("searchVO") BranchVO vo, Model model, HttpSession session) {
		
		BoardUtil boardUtil = new BoardUtil();
		List<BranchVO> branchList = null;
		
		try {
			/* 게시판 기능 */
			int totalRecordCount = 0; 					// 총 게시물 건수
			int recordCountPerPage = 10; 				// 한 페이지당 게시되는 게시물 건 수
			int currentPageNo = vo.getCurrentPageNo(); 	// 현재 클릭한 page 번호
			// 내 생각 틀릴 수도 있음 정확한거 아님: pageSize도 현재페이지처럼 유동적인 데이터처리를 위해 vo의 값을 get 해오는데 데이터를 어디서 받아오는지 확인불가
			int pageSize = vo.getPageSize(); 			// 페이지 리스트에 게시되는 페이지 건수

			// 게시물 조회 범위 연산
			// 현재페이지 페이지에서 보여주는 게시물 수
			//                                                           현재 페이지 번호    , 한 페이지당 게시되는 게시물 건 수
			HashMap<String, Integer> rangeMap = boardUtil.calcDataRange(currentPageNo, recordCountPerPage);
			vo.setStart(rangeMap.get("firstRecordIndex"));
			vo.setEnd(rangeMap.get("lastRecordIndex"));
			
			branchList = branchService.selectBranchList(vo);
			
			if(branchList.size() > 0) {
				
				totalRecordCount = branchList.get(0).getTotalRecordCount();
			}
			
			// pager기능 모든 계산식 결과 정보 map에 담기
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount, recordCountPerPage, pageSize);

			model.addAttribute("pagerMap", pagerMap);
			model.addAttribute("branchList", branchList);

		} catch(Exception e) {
	
			e.printStackTrace();
		}
				
		return "/branch/branchList.tiles";
	}
}