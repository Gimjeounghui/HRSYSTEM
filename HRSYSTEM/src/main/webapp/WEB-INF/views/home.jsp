<%@ page language="java" contentType="text/html; charset=UTF-8"  %> 
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="tt" value="<%=System.currentTimeMillis() %>"/>
	<script src="<c:url value="/js/test/test.js?v=${tt}"/>"></script>
	
	<head>
		<title>Home</title>
	</head>
	<body>
		<h1>test 화면</h1>
		<form name="searchForm" id="searchForm" method="get">
			<div style="padding-left: 13px; padding-right: 13px;">
				<div class="" style="border: 1px solid #ccc; padding-left: 0 !important;">
					<div class="">
						<table class="" style="margin-bottom: 0 !important;">
							<tr class="">
								<td class="">
									<p class="">이름</p>
								</td>
								<td class="">
									<div class="" style="width: 100%;">
										<input type="text" class="" name ="nm" id="nm" placeholder="이름" value="${searchVO.nm}">
									</div>
								</td>
								
								<td class="">
									<p class="">성별</p>
								</td>
								<td class="">
									<div class="" style="width: 100%;">
										<input type="text" class="" name ="gender" id="gender" placeholder="성별" value="${searchVO.gender}">
									</div>
								</td>
								
								<td class="">
									<p class="">집주소</p>
								</td>
								<td class="">
									<div class="" style="width: 100%;">
										<input type="text" class="" name ="homeAddr" id="homeAddr" placeholder="집주소" value="${searchVO.homeAddr}">
									</div>
								</td>
								
								<td class="">
									<button class="" onclick="searchItem()">검색</button>
								</td>
							</tr>
						</table>
					</div>
				</div>
			</div>
		</form>
		
		<table class="">
			<thead>
				<tr class="">
					<th><input type="checkbox" name="" id="checkAll"></th> 
					<th class="" >번호</th>
					<th class="" >이름</th>
					<th class="" >성별</th>
					<th class="" >집주소</th>
					<th class="" >PWCODE(AJAX TEST)</th>
				</tr>
			</thead>
			<tbody>
				<c:if test="${fn:length(testList) == 0}">
					<td align="center" colspan="11">조회된 항목이없습니다.</td>
				</c:if>
				
				<c:forEach var="list" items="${testList}">
					<tr>
						<td align="center"><input type="checkbox" name="checkbox" value="${list.idx}" ></td>
				 		<td>${list.idx}</td>	<!-- 번호 -->
				 		<td style="cursor:pointer" onclick="testDetail(${list.idx})">${list.nm}</td>
				 		<td style="cursor:pointer" onclick="testDetail(${list.idx})">${list.gender}</td>	
				 		<td style="cursor:pointer" onclick="testDetail(${list.idx})">${list.homeAddr}</td>
				 		<td style="cursor:pointer" onclick="ajax_testAjax(${list.idx}, this)">-</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</body>