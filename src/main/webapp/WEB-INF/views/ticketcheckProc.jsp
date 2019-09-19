<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>영화예매하기</title>
      <link rel="stylesheet" href="resources/css/ticket.css">
	<script src="https://code.jquery.com/jquery-3.4.1.min.js"
		integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
		crossorigin="anonymous"></script>
</head>
<script type="text/javascript">
$(function(){
	$("#delbtn").click(function(){
		if(confirm("예매 취소 하시겠습니까?")){
			location.href="delTicket/"+${Ticket.ticketid};
		}
	});
});

</script>
<style>
	#rstbl{
		text-align: left;
		width:600px;
		color:#231f20;
		padding:10px;
		border-radius: 15px;
		margin-bottom: 30px;
	}
	#rstbl td{
		height:30px;
		padding:5px;
		vertical-align:top;
	}
	.oldimg{
		width: 27px;
		height: 27px;
		vertical-align: middle;
	}
	
</style>
<body>
 <center>
 	<hr color="red" width="700">
 		<h4>예매 내역</h4> 	
 	<hr color="red" width="700">
 	<table id="rstbl" bgcolor="white" >
		<tr>
 			<td colspan="2">
 				<img class="oldimg" src="resources/img/${Ticket.grade }old.png"> ${Ticket.movie }
 			</td>
 			<td colspan="2" style="text-align:right;">	
		 		<b>예매번호 : ${Ticket.ticketid}</b>		 			
 			</td>
 		</tr>
 		<tr> 			
 			<td>			 			
	 			<strong>관람 일시</strong>
 			</td>
 			<td>
 				${Ticket.viewdate} ${Ticket.time} 
 			</td>
 			<td >
 				<strong> 매수 </strong>
			</td>
 			<td rowspan="2" style="text-align: left; vertical-align:top;">
 				 성인 ${Ticket.adcnt }명 <br> 청소년  ${Ticket.stcnt }명
 			</td>
 		</tr>
 		<tr> 			
	 		<td>
	 			<strong>관람 극장 </strong>
	 		</td>
	 		<td>
	 			${Ticket.cinema }
	 		</td>
	 		<td>
	 		</td>
	 		
 		</tr>
 		<tr> 			
	 		<td>
	 			<strong>결제 금액</strong>
	 		</td>
	 		<td>
	 			${Ticket.price }
	 		</td>
	 		<td>
	 			<strong>예매 일시</strong>
	 		</td>
	 		<td>
	 			${Ticket.tickettime }
	 		</td>
 		</tr>
 	</table>
 	
 	<input type="button" class="chButton" id="delbtn" onclick="delcheck(${Ticekt.ticketid })" value="예매취소" >
 			

 </center>
</body>
</html>





