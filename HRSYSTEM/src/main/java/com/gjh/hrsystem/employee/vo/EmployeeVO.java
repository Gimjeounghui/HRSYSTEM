package com.gjh.hrsystem.employee.vo;

import com.gjh.hrsystem.common.vo.DefaultVO;

public class EmployeeVO extends DefaultVO {
	
	private int empNo; 			// 번호
	
	private String empNm; 		// 이름
	
	private char empGender; 	// 성별
	
	private String depCode; 	// 부서코드

	private String depNm; 		// 부서명
	
	private int empSalary; 		// 급여
	
	private String empHireDate;	// 입사일

	
	public int getEmpNo() {
		return empNo;
	}

	public void setEmpNo(int empNo) {
		this.empNo = empNo;
	}

	public String getEmpNm() {
		return empNm;
	}

	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	public char getEmpGender() {
		return empGender;
	}

	public void setEmpGender(char empGender) {
		this.empGender = empGender;
	}

	public String getDepCode() {
		return depCode;
	}

	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	
	public String getDepNm() {
		return depNm;
	}

	public void setDepNm(String depNm) {
		this.depNm = depNm;
	}

	public int getEmpSalary() {
		return empSalary;
	}

	public void setEmpSalary(int empSalary) {
		this.empSalary = empSalary;
	}

	public String getEmpHireDate() {
		return empHireDate;
	}

	public void setEmpHireDate(String empHireDate) {
		this.empHireDate = empHireDate;
	}
}