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

import com.gjh.hrsystem.common.util.BoardUtil;
import com.gjh.hrsystem.employee.service.EmployeeService;
import com.gjh.hrsystem.employee.vo.EmployeeVO;

@Controller
@RequestMapping("/employee")
public class EmployeeController {

	private static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

	@Autowired
	private EmployeeService employeeService;

	@RequestMapping(value = "/employeeList")
	public String employeeList(@ModelAttribute("searchVO") EmployeeVO vo, Model model, HttpSession session) {

		// 게시판 UTIL
		BoardUtil boardUtil = new BoardUtil();
		List<EmployeeVO> employeeList = null;

		try {
			/* 게시판 기능 */
			int totalRecordCount = 0; 					// 총 게시물 건수
			int recordCountPerPage = 10; 				// 한 페이지당 게시되는 게시물 건 수
			int currentPageNo = vo.getCurrentPageNo(); 	// 현재 클릭한 page 번호
			int pageSize = vo.getPageSize(); 			// 페이지 리스트에 게시되는 페이지 건수

			// 게시물 조회 범위 연산
			// HashMap : 중복과 순서가 허용되지 않고, null 허용
			// 현재페이지 페이지에서 보여주는 게시물 수
			HashMap<String, Integer> rangeMap = boardUtil.calcDataRange(currentPageNo, recordCountPerPage); // returnMap
			vo.setStart(rangeMap.get("firstRecordIndex"));
			vo.setEnd(rangeMap.get("lastRecordIndex"));

			// 전체 검색 결과
			employeeList = employeeService.selectEmployeeList(vo);

			// 검색된 결과가 있는지 체크
			if (employeeList.size() > 0) {
				// 전체 검색 결과 게시물 건 수
				totalRecordCount = employeeList.get(0).getTotalRecordCount();
			}

			// pager기능 모든 계산식 결과 정보 map에 담기
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount, recordCountPerPage, pageSize); // returnMap

			/* 게시판 END */

			// model 세팅
			model.addAttribute("employeeList", employeeList);
			model.addAttribute("pagerMap", pagerMap); // 게시판 계산식 map

		} catch (Exception e) {

			logger.info(e.getMessage());
			e.printStackTrace();
		}

		return "/employee/employeeList.tiles";
	}
}