package com.gjh.hrsystem.employee.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

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

		List<EmployeeVO> employeeList = null;

		try {
		
			employeeList = employeeService.selectEmployeeList(vo);

			model.addAttribute("employeeList", employeeList);

		} catch (Exception e) {

			logger.info(e.getMessage());
			e.printStackTrace();
		}

		return "/employee/employeeList.tiles";
	}
}