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
	href="resources/css/studyRegister.css">
<script type="text/javascript" src="resources/js/studyRegister.js"></script>	
<div class="content">


	<div class="content-text"><p>リーダーになってみませんか?</p></div>
	
		<form method="post" action="/portpolio/studyregister" enctype="multipart/form-data">
			<div class="table">
			<table>
				<tr>
					<td>スタティー名</td>
					<td><input type="text" id="studyname" name="studyname"  required></td>
				</tr>
				<tr>
					<td>人員</td>
					<td><label class="people"><input type="radio" id="quota" name="quota"
							value="3">3人<input type="radio" name="quota" value="4">4人<input
						type="radio" name="quota" value="5">5人<input type="radio"
						name="quota" value="6">6人 <input type="radio" name="quota"
						value="7">7人 <input type="radio" name="quota" value="8">8人
						<input type="radio" name="quota" value="9">9人 <input
						type="radio" name="quota" value="10">10人</label></td>
				</tr>
				<tr>
					<td>科目</td>
					<td><input type="radio" name="subject" value="英語">英語<input
						type="radio" name="subject" value="中国語">中国語 <input
						type="radio" name="subject" value="プログラミング">プログラミング <input
						type="radio" name="subject" value="日本語">日本語</td>
				</tr>
				<tr>
					<td>参加費</td>
					<td><input type="radio" name="cost" value="0">無料 <input
						type=radio name="cost" value="3">3千円 <input type="radio"
						name="cost" value="5">5千円  <input type="radio" name="cost"
						value="7">7千円 </td>
				</tr>
				<tr>
					<td>レベル</td>
					<td><input type="radio" name="level" value="beginner">初心者
						<input type="radio" name="level" value="midder">中級者 <input
						type="radio" name="level" value="runner">高級者</td>
				</tr>
				<tr>
					<td>地域</td>
					<td><input type="radio" name="local" value="newyork">ニューヨーク
						<input type="radio" name="local" value="seoul">ソウル <input
						type="radio" name="local" value="busan">プサン
						<input type="hidden" name="email" value="${sessionScope.userInpo.email}">
						<input type="hidden" name="leader" value="${sessionScope.userInpo.name}">
						
						 </td>
				</tr>
				<tr>
					<td>スタティー詳細</td>
					<td><textarea cols="100px" rows="20px" name="content"></textarea></td>

				</tr>
				
				<tr>
					<td>写真添付</td>
					<td>	<input type="file" name="uploadFile" id="uploadBtn" ></td>

				</tr>
				<tr>
					<td colspan="2"><input type="submit" name="submitBtn"  class="submitBtn"></td>
				</tr>
				<tr><td colspan="2"><p>スタティーは最大3個です。. 現在 ${leaderlimit} 個です。.</p></td></tr>
			






			</table>

           </div>
		  </form>
		  
	
	</div>





<%@ include file="includes/footer.jsp"%>

