<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page trimDirectiveWhitespaces="true" %>

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
	            	<p>HRSYSTEM 메인페이지</p>
	                <div class="container">
		  				<div class="row">
		    				<div class="col-md-6">
					      		<div class="form-inline">
							        <div class="form-group">
						          		<label for="search1">검색조건1:</label>
							          	<select class="form-control" id="search1">
								            <option>옵션 1</option>
								            <option>옵션 2</option>
								            <option>옵션 3</option>
							          	</select>
							        </div>
							        <div class="form-group">
								        <label for="search2">검색조건2:</label>
								        <input type="text" class="form-control" id="search2">
							        </div>
							        <button type="button" class="btn btn-primary">검색</button>
						      	</div>
						    </div>
					  	</div>
						  
					  	<div class="row">
					    	<div class="col-md-8">
					      		<div class="table-responsive">
							        <table class="table table-striped">
							        	<thead>
								            <tr>
								            	<th>제목</th>
									            <th>작성자</th>
									            <th>날짜</th>
								            </tr>
							          	</thead>
							          	<tbody>
								            <tr>
							                	<td>게시물 1</td>
								              	<td>작성자 1</td>
								              	<td>2023-07-05</td>
								            </tr>
								            <tr>
							                	<td>게시물 2</td>
									            <td>작성자 2</td>
									            <td>2023-07-06</td>
								            </tr>
								            <!-- 게시판 내용을 추가로 작성해주세요 -->
							          	</tbody>
							        </table>
						      	</div>
						    </div>
					    </div>
						
						<!-- 패이징 처리부분 -->
					  	<div class="row">
					    	<div class="col-md-8 text-center">
						    	<ul class="pagination ">
							        <li class="disabled"><a href="#">이전</a></li>
							        <li class="active"><a href="#">1</a></li>
							        <li><a href="#">2</a></li>
							        <li><a href="#">3</a></li>
							        <li><a href="#">다음</a></li>
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
