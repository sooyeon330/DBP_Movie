<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영화예매하기</title>
    <link rel="stylesheet" href="resources/css/index.css">
    <link rel="stylesheet" href="resources/css/rightnav.css">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<style>
body{
		background-repeat:no-repeat;
		background-image: url("resources/img/Artboard1.png");  
		background-position: center;
		background-size: cover;
	}
</style>

<body bgcolor="#7b3551">
<p>User : ${user_name }</p>
<%
	String sessionid = (String)request.getAttribute("sessionid");

	if(sessionid != ""){
		out.println("<p id='loginfo'><b>"+sessionid+"</b>님이 로그인 중입니다.<a href='logout'>로그아웃</a><p>");
	}else{
		
	}
%>
    <table class="main" border="0">
		<tr>
			<td id="header" class="header" colspan="2">
				<jsp:include page="top.jsp" flush="false" />
			</td>
		</tr>
		<tr>
			<td class="view">
				<div class="mcon">
					<jsp:include page="${viewpage }" flush="true"></jsp:include>
				</div>
			</td>
		</tr>
    </table>
    <div style=" position: fixed; bottom: 5px; right:100px;">
		<a href="#header">
			<img src="resources/img/back-to-top.png" title="위로 가기"></a>
	</div>
	<div id="mySidenav" class="sidenav">
	  <a href="login" id="about">Login</a>
	  <a href="joinform" id="blog">Join</a>
	  <a href="#" id="projects">...</a>
	</div>
</body>
</html>