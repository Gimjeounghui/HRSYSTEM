package com.gjh.hrsystem.employee.controller;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.gjh.hrsystem.common.util.BoardUtil;
import com.gjh.hrsystem.employee.service.EmployeeService;
import com.gjh.hrsystem.employee.vo.EmployeeVO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	// LoggerFactory는 Logger 객체를 생성하기 위해 사용되는 팩토리 클래스
	// getLogger 메서드는 로깅을 위한 Logger 객체를 가져옴
	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value="/employeeList")
	public String employeeList(@ModelAttribute("searchVO") EmployeeVO vo, Model model, HttpSession session) {

		// 게시판 UTIL
		BoardUtil boardUtil = new BoardUtil();
		List<EmployeeVO> employeeList = null;

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

			// 전체 검색 결과
			employeeList = employeeService.selectEmployeeList(vo);

			if(employeeList.size() > 0) {
				
				totalRecordCount = employeeList.get(0).getTotalRecordCount();
			}
			
			// pager기능 모든 계산식 결과 정보 map에 담기
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount, recordCountPerPage, pageSize);

			/* 게시판 END */

			model.addAttribute("employeeList", employeeList);
			model.addAttribute("pagerMap", pagerMap); // 게시판 계산식 Map
			
		} catch (Exception e) {

			// logger.info(e.getMessage());
			e.printStackTrace();
		}

		return "/employee/employeeList.tiles";
	}
}