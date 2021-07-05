<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<div>
 <c:if test="${!empty memberInfo }">
 <input type="button" value="로그아웃" onclick="location.href='logout.do';">	
 <input type="button" value="내정보" onclick="location.href='mypage.do';">
 </c:if>
 <c:if test="${empty memberInfo }">
 <input type="button" value="로그인" onclick="location.href='form.do';">
 </c:if>
</div>

<c:forEach var="member" items="${list}">
	${member.mno}, ${member.mname}, ${member.email}<br>
</c:forEach>
</body>
</html>