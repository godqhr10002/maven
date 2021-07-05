<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>HttpServletRequest</h3>
이름 : ${name1 }<br>
이메일 : ${email1 }<br>
<h3>@RequestParam</h3>

이름2 : ${name2 }<br>
이메일2 : ${email2 }<br>
번호2 : ${no }<br>
<h3>커맨드객체 request set</h3>

이름3 : ${vo.name}<br>
이메일3 : ${vo.email }<br>
번호3 : ${vo.no }<br>

<h3>커맨드객체 request set없이</h3>
이름4 : ${memberVo.name }<br>
이메일4 : ${memberVo.email }<br>
번호4: ${memberVo.no } <br>



</body>
</html>