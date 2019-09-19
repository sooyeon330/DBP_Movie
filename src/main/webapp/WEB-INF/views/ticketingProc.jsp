<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영화예매하기</title>
    <link rel="stylesheet" href="resources/css/ticket.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
	<style>
		#cinemList{
			width:400px;
		}
		#movieList{
			width:450px;
			height:300px;
			overflow: auto;
		}
		.off{}.clear{clear:both;}
		.on{color:red;}
		#Ticketing{margin:20px; cursor: pointer;}
	</style>
	<%
	String sessionid = (String)request.getAttribute("sessionid");
	%>
	<script>
		$(function(){
			var ticketid;
			var customer = '<%= sessionid %>';
			var viewdate;
			var time;
			var cinema=0, cineval;
			var movie, movieval;
			var adcnt,stcnt;
			var price;
			
			
			 $('.off').click(function(){
				$('.off').removeClass('off');
				$(this).addClass('on');
			}); 
			/* result Set */
			$('#date').attr('min',date_to_str(new Date()));
			
			$('#date').change(function(){
				$('#sdate').val
				$('#redate').text($(this).val());
				
				viewdate = $(this).val();
			})
			
			$('.chButton').click(function(){
				console.log($(this).attr("param1"))
				cinema = parseInt($(this).attr("param1"));
				console.log(cinema)
				cineval =$(this).val();				
				$('#recine').text(cineval);
			})
			
			$('.movButton').click(function(){
				movie = parseInt($(this).attr("param1"));
				movieval = $(this).val();
				$('#removie').text(movieval);
			})
			
			$('#adcont, #stcont').change(function(){
				adcnt = $('#adcont option:selected').val();
				stcnt = $('#stcont option:selected').val();
				
				var pamout = parseInt(adcnt)+parseInt(stcnt);
				price = adcnt*10000 + stcnt*8000;
				$('#reprice').html("성인 : "+adcnt+"명&nbsp;&nbsp;청소년 : "
									+stcnt+"명&nbsp;&nbsp;<br>"+price+" 원");
			})
			
			$("#ticbtn").click(function(){
				if(customer == ""){
					alert("로그인이 필요합니다.");
					location.href="login";
				}else{
					$("#sbform").submit();
				}
			})
			
			$("#sbform").submit(function(event) {
				if (confirm("예매하시겠습니까?")) {
					$('#ticketid').val(makeTid());
					$('#customer').val(customer);
					$('#viewdate').val(viewdate);
					$('#cinema').val(cinema);
					$('#movie').val(movie);
					$('#adcnt').val(adcnt);
					$('#stcnt').val(stcnt);
					$('#price').val(price);
				}else{
					return false;
				}
					return true;
			});

		});
		function makeTid() {
			var ticketid = Math.floor(Math.random() * 10000000) + 1;
			return ticketid.toString();
		} 
		function date_to_str(format)
		{
		    var year = format.getFullYear();
		    var month = format.getMonth() + 1;
		    if(month<10) month = '0' + month;
		    var date = format.getDate();
		    if(date<10) date = '0' + date;

		    return year + "-" + month + "-" + date;
		}

	</script>
</head>
<body>
<div class="mcon">
	<div class="section">
 		<form action="goticket" method="post" >
		
			<h3 class="Tlabel">날짜</h3>
	  			<input type="date" id="date" name="date">
	  		<h3 class="Tlabel">인원</h3>
				성인 <select id="adcont">
						<option>0</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
				 청소년 <select id="stcont">
			 			<option>0</option>
						<option>1</option>
						<option>2</option>
						<option>3</option>
						<option>4</option>
					</select>
	
			<h3 class="Tlabel">영화관</h3>
			<div id="cineList" >
				<c:forEach items="${mybatisCinemas }" var="cinemalist">
						<input class="off chButton"  type="button" id="cine${cinemalist.id }" name="cinema" 
						param1="${cinemalist.id }" value=${cinemalist.cinema }>
				</c:forEach>
			</div>
			<h3 class="Tlabel">영화</h3>		
			<div id="movieList">
				<ul class="movie_ul">
				<c:forEach items="${mybatisMovies }" var="movielist">
					<li>
						<img class="oldimg" src="resources/img/${movielist.grade }old.png" >
						<input class="off movButton" type="button" id="movie${movielist.id }" name="movie" 
						param1="${movielist.id }" value="${movielist.title }">
					</li>
				</c:forEach>
				</ul>
			</div>		
	</div>
		<h3 class="relabel">예매 정보</h3>
			<table id="resultDiv">
				<tr>
					<th>날짜</th>
					<th>상영관</th>
					<th>영화</th>
					<th width="200">결제 금액</th>
				</tr>
				<tr>
					<td class="result" id="redate"></td>
					<td class="result" id="recine"></td>
					<td class="result" id="removie"></td>
					<td class="result" id="reprice"></td>
				</tr>
			</table>
 	</form>

 	<p>
	<form:form commandName="TicketingVO" method="post" action="tInsertOk" id="sbform">
		<form:hidden path="ticketid" value=""/>
		<form:hidden path="customer" value=""/>
		<form:hidden path="viewdate" />
		<form:hidden path="time" value=""/>
		<form:hidden path="cinema"/>
		<form:hidden path="movie" />
		<form:hidden path="adcnt" value=""/>
		<form:hidden path="stcnt" value=""/>
		<form:hidden path="price" value=""/>
		<div id="goTicket">
			 <input type='button' class='chButton' id="ticbtn" value='예매하기'>
		</div>
	</form:form>
</div>
		


</body>
</html>





