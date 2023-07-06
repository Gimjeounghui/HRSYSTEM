<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<meta http-equiv="X-UA-Compatible" content="IE=edge, chrome=1" />
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title><tiles:getAsString name="title" /></title>
        
        <!-- 해당 템플릿을 사용하는 페이지는 jquery를 사용해야되기 때문에 선언 지우지 말것 -->
        <script type="text/javascript" src="/resources/js/common/jquery-3.6.2.min.js" ></script>
        <script src="/webjars/jquery-form/4.2.1/jquery.form.min.js"></script>
        
        <!-- 해당 템플릿을 사용하는 페이지는 bootstrap을 사용해야 되기 때문에 해당공통페이지에서 선언 지우지 말것 -->
        <!-- 부트스트렙은 jquery 기반으로 만들어져서 jquery 먼저 선언후 그 후에 선언 -->
		<script src="/resources/bootstrap/dist/js/bootstrap.min.js"></script>
        <link rel="stylesheet" href="/resources/bootstrap/dist/css/bootstrap.min.css" >
        
        <!-- hr프로젝트의 전반적인 CSS 레이아웃 -->
        <link rel="stylesheet" href="/resources/css/hrLayout.css">
        
        <!-- hr프로젝트의 전반적인 공통 js -->
        <script type="text/javascript" src="/resources/js/common/commonUtil.js" ></script>
    </head>
    
    <style>

	   .nav-sidebar li {
            background-color: #d1e0f5;
        }
        
        .nav-sidebar li a {
            color: #000000;
        }
        
        .content-container {
	        border: 1px solid #ccc;
	        padding: 10px;
	        margin-top: 20px;
    	}	
	
	</style>
    
	<body>
		<!-- header -->
        <div class="container">
	    	<div class="row">
		      	<!-- 헤더 네비게이션 바 -->
		      	<nav class="navbar navbar-default">
		        	<!-- 네비게이션 바 콘텐츠 -->
			        <tiles:insertAttribute name="header" />
		      	</nav>
		    </div>
		
		    <div class="row">
		    	
		    	<!-- 왼쪽 사이드바 메뉴 -->
		    	<tiles:insertAttribute name="leftSide" />
		    	
			    <div class="col-md-10 content-container">
				    <div class="col-md-10">
				        <!-- 컨텐츠 영역 -->
			            <div class="container ">
			                <tiles:insertAttribute name="body" />
			            </div>
				    </div>
			    </div>
			</div>
		
			<div class="row">
	      		<div class="col-md-12">
	        		<tiles:insertAttribute name="footer" />
		      	</div>
			</div>
		</div>
	</body>
</html>