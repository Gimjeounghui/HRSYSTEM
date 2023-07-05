<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<script type="text/javascript">
	
		$(function() {
	
		});
		
	</script>

	<body>
		<div id="board-list">
			<div class="container">
				<table class="board-table">
					<thead>
						<tr>
							<th scope="col" class="th-num">번호</th>
							<th scope="col" class="th-title">성명</th>
							<th scope="col" class="th-name">성별</th>
							<th scope="col" class="th-id">소속부서</th>
							<th scope="col" class="th-date">급여</th>
						</tr>
					</thead>
					<tbody>
						<!-- fn:legth(item) = item이 배열이나 컬렉션이면 요소의 개수, 문자열이면 문자의 갯수 반환 -->
						<c:if test="${fn:length(employeeList) == 0}">
							<td align="center" colspan="5">조회된 항목이없습니다.</td>
						</c:if>
	
						<c:forEach var="list" items="${employeeList}">
							<td>${list.no}</td>
							<td>${list.name}</td>
							<td>${list.gender}</td>
							<td>${list.department}</td>
							<td>${list.salart}</td>
							<td>${list.hireDate}</td>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</body>