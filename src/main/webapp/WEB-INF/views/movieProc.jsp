<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영화예매하기</title>
    <link rel="stylesheet" href="resources/css/insertM.css">
    <link rel="stylesheet" href="resources/css/listM.css">
</head>
<script>
// Get the modal
var modal = document.getElementById('addbtn');

// When the user clicks anywhere outside of the modal, close it
window.onclick = function(event) {
  if (event.target == modal) {
    modal.style.display = "none";
  }
}

function delcheck(id){
	if(confirm("삭제하시겠습니까?")){
		location.href="delMovie/"+id;
	}
	
}
</script>
<body>
<div class="MovlistCon">
<%
	String sessionid = (String)request.getAttribute("sessionid");

	if(sessionid.equals("admin")){
%>	
		<button onclick="document.getElementById('id01').style.display='block'" style="width:auto;">영화 추가하기</button>
<%	}else{
		
	}
%>

<table class="limtbl">
	<thead>
		<tr>
			<th>제목</th>
			<th>개봉일</th>
			<th colspan=2>상영종료일</th>		
		</tr>
	</thead>
	<tbody>
	<c:forEach items="${mybatisMovies }" var="mvo">
		<tr class="litr">
			<td class="litd"><img class="oldimg" src="resources/img/${mvo.grade }old.png" >${mvo.title }</td>
			<td  class="litd">${mvo.opendate }</td>
			<td  class="litd">${mvo.closedate }</td>
<% 
	if(sessionid.equals("admin")){
%>	
		<td class="litd"><button onclick="delcheck(${mvo.id })">삭제하기</button>
<%	}else{
		
	}
%>
			
		</tr>
	</c:forEach>
	</tbody>
</table>
</div>
<p>


<div id="id01" class="modal">
  <span onclick="document.getElementById('id01').style.display='none'" class="close" title="Close Modal">&times;</span>
  <form class="modal-content" action="MovInsertOk" method="post">
    <div class="container">
      <h1>영화 추가하기</h1>
      <p>영화 정보를 입력해주세요</p>
      <hr>
      <label for="title"><b>영화 제목</b></label>
      <input type="text" placeholder="영화 제목" name="title" required>

      <label for="oepndate"><b>개봉 일 (ex. yyyy/mm/dd )</b></label><p>
      <input type="date" placeholder="개봉일" name="opendate" required><p>
 
 	  <label for="closedate"><b>상영일 수 (ex. 2주 -> 14)</b></label>
      <input type="text" placeholder="상영일수" name="closedate" required>
 
      <b>상영 등급</b><br>
      <select name="grade">
      	<option value="0">GREEN(전체관람가)</option>
      	<option value="12">YELLO(12)</option>
      	<option value="15">BLUE(15)</option>
      	<option value="19">RED(19)</option>      	
      </select>
      	세 이상<br> 


      <div class="clearfix">
        <button type="button" onclick="document.getElementById('id01').style.display='none'" class="cancelbtn">Cancel</button>
        <button type="submit" class="signupbtn">추가 하기</button>
      </div>
    </div>
  </form>
</div>


</body>
</html>