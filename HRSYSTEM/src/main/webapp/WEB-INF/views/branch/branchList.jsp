<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

	<script type="text/javascript">
	
		$(function() {
			
		});

	</script>
	
<body>
	<div class="wrapper">
	    <!-- Begin page content -->
	    <section class="contentWrapper">
			<div class="content_wrap">
	        <br><br>
	        	<a href="#">
	            <!-- <img src="/img/user/banner.jpg" alt=""> -->
	            </a>
	            <br><br>
	        	<div class="main_content">
	            	<p>지점검색</p>
	                <div class="container">
	                
	                	<!-- 검색박스 부분 -->
		  				<div class="row">
		    				<div class="col-md-6">
					      		<div class="form-inline">
									<form name="searchForm" id="searchForm" method="get">
										<!-- 현재 클릭한 페이지 넘버 -->
										<input type="hidden" name="currentPageNo" id="currentPageNo" value="${pagerMap['currentPageNo']}">
								        
								        <div class="form-group">
							          		<label for="search1"></label>
								          	<select class="form-control" id="searchSelect1" name="searchSelect1">
									            <option value="A" ${searchVO.searchSelect1 eq 'A' ? 'selected' : ''}>지점위치</option>
									            <option value="B" ${searchVO.searchSelect1 eq 'B' ? 'selected' : ''}>부서명</option>
								          	</select>
								        </div>
								        <div class="form-group">
									        <label for="search2"></label>
									        <input type="text" class="form-control" id="searchInput1" name="searchInput1" value="${searchVO.searchInput1}">
								        </div>
								        
								        <button type="button" class="btn btn-primary" onclick="searchBtn('/branch/branchList')">검색</button>
							        </form>
						      	</div>
						    </div>
					  	</div>
						
						<!-- 게시판 컬럼과 데이터 부분  --> 
					  	<div class="row">
					    	<div class="col-md-8">
					      		<div class="table-responsive">
							        <table class="table table-striped">
							        	<!-- 게시판 컬럼 -->
							        	<thead>
								            <tr>
							            		<th scope="col" class="th-bnhNo">번호</th>
												<th scope="col" class="th-bnhLocation">위치</th>
												<th scope="col" class="th-depNm">담당부서</th>
												<th scope="col" class="th-bnhLandline">전화번호</th>
												<th scope="col" class="th-bnhBusinessHours">영업시간</th>
								            </tr>
							          	</thead>
							          	<!-- 게시판 데이터 부분 -->
							          	<tbody>
								          	<!-- fn:legth(item) = item이 배열이나 컬렉션이면 요소의 개수, 문자열이면 문자의 갯수 반환 -->
											<c:if test="${fn:length(branchList) == 0}">
												<td align="center" colspan="5">조회된 항목이없습니다.</td>
											</c:if>
				
											<c:forEach var="list" items="${branchList}">
												<tr>
													<td>${list.bnhNo}</td>
													<td>${list.bnhLocation}</td>
													<td>${list.depNm}</td>
													<td>${list.bnhLandline}</td>
													<td>${list.bnhBusinessHours}</td>
												</tr>
											</c:forEach>
							          	</tbody>
							        </table>
						      	</div>
						    </div>
					    </div>
						
						<br/>
						<br/>
						
						<!-- 페이징 처리부분 -->
					  	<div class="row">
					    	<div class="col-md-8 text-center">
						    	<ul class="pagination ">
						    		<!-- 페이지 리스트의 첫 페이지 번호가 1이 아닐때만 처음 버튼을 생성한다. -->
               						<c:if test="${pagerMap['firstPageNoOnPageList'] ne 1}">
							        	<li class="">
							        		<a href="javascript:movePage('searchForm', 1)">맨앞</a>
							        	</li>
							        </c:if>
							        
							        <!-- 페이지 리스트의 첫 페이지 번호가 1이 아닐때만 이전 버튼을 생성한다. -->
               						<c:if test="${pagerMap['firstPageNoOnPageList'] ne 1}">
							        	<li class="">
							        		<a href="javascript:movePage('searchForm', ${pagerMap['prevPageNoOnPageList']})">이전</a>
							        	</li>
							        </c:if>
							        
							        <!-- 페이지 리스트의 첫페이지 번호 begin, 페이지 리스트의 마지막 페이지 번호 end -->
					                <c:forEach var="i" begin="${pagerMap['firstPageNoOnPageList']}" end="${pagerMap['lastPageNoOnPageList']}" step="1">
								        <li class="<c:if test="${i == pagerMap['currentPageNo']}"> active </c:if>">
								        	<a href="javascript:movePage('searchForm', ${i})">${i}</a>
								        </li>
							        </c:forEach>
							        
							        <!-- 마지막 페이지 번호가 총 페이지 개수 보다 작을 경우만 다음 버튼을 생성 한다. -->
               						<c:if test="${pagerMap['lastPageNoOnPageList'] < pagerMap['totalPageCount']}">
			        					<li>
							        		<a href="javascript:movePage('searchForm', ${pagerMap['nextPageNoOnPageList']})">다음</a>
						        		</li>
							        </c:if>
							        
							        <!-- 마지막 페이지 번호가 총 페이지 개수 보다 작을 경우만 맨끝 버튼을 생성 한다. -->
               						<c:if test="${pagerMap['lastPageNoOnPageList'] < pagerMap['totalPageCount']}">
							        	<li>
							        		<a href="javascript:movePage('searchForm',  ${pagerMap['totalPageCount']})">맨끝</a>
						        		</li>
							        </c:if>
						      	</ul>
						    </div>
					  	</div>
					</div>
	        	</div>
	       	</div>
	   	</section>
	   	
	    <div id="contentWrap">
	        <a href="" style="display:block; text-align:center; margin:40px 0;">&nbsp;</a>
	    </div>
	    
    </div>
</body>	