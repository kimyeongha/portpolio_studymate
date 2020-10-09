<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
 <script>
   var massage = '${msg}'; 
        
    if(massage===""){
        	   
            	
            }else{
            	alert(massage);
            	
            }
         

          
        
             
            </script>



<link rel="stylesheet" type="text/css"
	href="resources/css/reviewWrite.css">
<script type="text/javascript" src="resources/js/studyRegister.js"></script>	
<div class="content">


	<div class="content-text"><p>review!!</p></div>
	
		<form method="post" action="/portpolio/reviewWriteEx" >
			<div class="table">
			<table>
				<tr>
					<td>スタディー名</td>
					<td>${modifyinpo.studyname} </td>
				</tr>
				<tr>
					<td>人員</td>
					<td>${modifyinpo.quota}명</td>
				</tr>
				<tr>
					<td>科目</td>
					<td><span id="subject">${modifyinpo.subject}</span></td>
				</tr>
				<tr>
					<td>費用</td>
					<td><span id="cost">${modifyinpo.cost}만원</span></td>
				</tr>
				<tr>
					<td>レベル</td>
					<td><span id="level">${modifyinpo.level}</span></td>
				</tr>
				<tr>
					<td>満足度</td>
					<td><input type="radio" name="score" value="満足">満足<input type="radio" name="score" value="普通">普通<input type="radio" name="score" value="不満">不満</td>
				</tr>
				<tr>
					<td>地域</td>
					<td>${modifyinpo.local}
						
						
						 </td>
				</tr>
				<tr>
					<td>スタディー詳細</td>
					<td>${modifyinpo.content}</td>

				</tr>
				
				<tr>
					<td>レビュー</td>
					<td>	<textarea cols='50' rows='5' name="content"></textarea></td>

				</tr>
				<tr>
				    <td></td>
					<td colspan="2"><input type="submit" name="submitBtn"  class="submitBtn"></td>
				</tr>
		
			






			</table>

           </div>
		  <input type="hidden" name="email" value="${sessionScope.userInpo.email}">
		  <input type="hidden" name="writer" value="${sessionScope.userInpo.name}">
		  <input type="hidden" name="studyno" value="${modifyinpo.studyno}">
		 <input type="hidden" name="leader" value="${modifyinpo.leader}">
		 	 <input type="hidden" name="level" value="${modifyinpo.level}">
		 	  <input type="hidden" name="studyname" value="${modifyinpo.studyname}">
		 	    <input type="hidden" name="subject" value="${modifyinpo.subject}">
								  
		  </form>
		  
	
	</div>





<%@ include file="includes/footer.jsp"%>

