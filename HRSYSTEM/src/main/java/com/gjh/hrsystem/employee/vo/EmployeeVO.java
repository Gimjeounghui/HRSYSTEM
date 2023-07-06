package com.gjh.hrsystem.employee.vo;

import com.gjh.hrsystem.common.vo.DefaultVO;

public class EmployeeVO extends DefaultVO {
	
	private int no; 			// 번호
	
	private String name; 		// 이름
	
	private char gender; 		// 성별
	
	private String department; 	// 소속부서
	
	private int salary; 		// 급여
	
	private String hireDate; 	// 입사일

	
	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getHireDate() {
		return hireDate;
	}

	public void setHireDate(String hireDate) {
		this.hireDate = hireDate;
	}
}