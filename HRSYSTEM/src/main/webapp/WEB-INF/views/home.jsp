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
		메인화면
	</body>