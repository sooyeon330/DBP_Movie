<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<link rel="stylesheet" href="resources/css/inputform.css">
<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
</head>
<script>
	$(function(){
		var pw1;
		var pw2;
		
		$('.pwinput').change(function(){
			console.log("alskdf");
			 pw1 = $('#pw').val();
			 pw2 = $('#pw2').val();
			
			 if(pw1 != pw2) { $('#pwconfirm').text("비밀번호가 일치하지 않습니다.").css("color","red")}
			 else { $('#pwconfirm').text("비밀번호가 일치합니다.").css("color","green") };
			/* pwconfirm(pw1,pw2); */
		});
		
		
	});
	
</script>
<body>

<div class='form'>
<form action="JoinOK" method="post">
  <h2>Register</h2>
   <input name='name' placeholder='Name' type='text'>
  <input name='id' id="id" placeholder='id' type='text'>
 <!--  <div id="checkid">중복확인</div> -->
  <input name='pw' id='pw' class="pwinput"  placeholder='Password' type='password'>
  <input id='pw2' class="pwinput" name='pw2' placeholder='Password confirm' type='password'>
  <div id="pwconfirm"></div>
  <input name='tel' placeholder='tel    ex)01012345678' type='text'>
  <input name='email' placeholder='E-Mail Address' type='text'>
  <input class='animated' type='submit' value='Register'>
  <a class='forgot' href='login'>Already have an account?</a>
</form>
</div>



</body>
</html>