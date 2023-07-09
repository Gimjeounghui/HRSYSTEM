package com.gjh.hrsystem.department.controller;

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
import com.gjh.hrsystem.department.service.DepartmentService;
import com.gjh.hrsystem.department.vo.DepartmentVO;

@Controller
@RequestMapping("/department")
public class DepartmentController {
	
	private static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);
	
	@Autowired
	private DepartmentService departmentService;
	
	@RequestMapping("/departmentList")
	public String departmentList(@ModelAttribute("searchVO") DepartmentVO vo, Model model, HttpSession session) {
		
		BoardUtil boardUtil = new BoardUtil();
		List<DepartmentVO> departmentList = null;
		
		try {
			
			int totalRecordCount = 0;
			int recordCountPerPage = 10;
			int currentPageNo = vo.getCurrentPageNo();
			int pageSize = vo.getPageSize();

			/* 게시판 조회범위 설정을 위한 코드 */
			HashMap<String, Integer> returnMap = boardUtil.calcDataRange(currentPageNo, recordCountPerPage);
				
				vo.setStart(returnMap.get("firstRecordIndex"));
				vo.setEnd(returnMap.get("lastRecordIndex"));
			
			departmentList = departmentService.selectDepartmentList(vo);
			
			if(departmentList.size() > 0) {
				
				totalRecordCount = departmentList.get(0).getTotalRecordCount();
			}
			
			/* 게시판 페이지 처리에 필요한 연산결과를 담아오는 pagerMap */
			HashMap<String, Integer> pagerMap = boardUtil.calcBoardPagerElement(currentPageNo, totalRecordCount, recordCountPerPage, pageSize);
			
			model.addAttribute("pagerMap", pagerMap);
			model.addAttribute("departmentList", departmentList);
		
		} catch(Exception e) {
			
			logger.info(e.getMessage());
			e.printStackTrace();
		}
		
		return "/department/departmentList.tiles";
	}
}

