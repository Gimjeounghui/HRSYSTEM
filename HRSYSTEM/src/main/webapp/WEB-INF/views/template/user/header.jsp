<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page trimDirectiveWhitespaces="true"%>

<nav class="navbar navbar-default">
	<div class="container">
    	<div class="navbar-header">
      		<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse">
		        <span class="sr-only">Toggle navigation</span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
		        <span class="icon-bar"></span>
      		</button>
      		<a class="navbar-brand" href="#">김정희 HR SYSTEM</a>
    	</div>
    	<div class="collapse navbar-collapse" id="navbar-collapse">
      		<ul class="nav navbar-nav">
		        <li class="active"><a href="/employee/employeeList">회사정보</a></li>
		        <li><a href="#">근무일정</a></li>
		        <li><a href="#">출퇴근기록</a></li>
		        <li><a href="#">휴가관리</a></li>
      		</ul>
    	</div>
	</div>
</nav>