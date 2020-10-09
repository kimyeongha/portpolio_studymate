<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ include file="includes/header.jsp" %>
    <script type="text/javascript"> 
    

    var massage = '${msg}'; 
        
    if(massage===""){
        	   
            	
            }else{
            	alert(massage);
            	
            }
    
    
    
    
    </script>
    
    
    
      
     <div class="slider">
       <div>
    	<div class="jumbotron">
          <h1 class="text-center">Study Mate</h1>
          <p class="text-center">welcome StudyMate</p>
          <p class="text-center">いつでも近いスタディーを探せます。.</p>
          
         </div>
       </div>
    <div>
    	<div class="jumbotron">
          <h1 class="text-center">一緒に成長したい方は?</h1>
          <p class="text-center">StudyMate</p>
          <p class="text-center">リーダーになってみませんか?</p>
     
         </div>
       </div>
  </div>







   <div class="content">
     
      <div class="serchcrew">
           <div class="serchcrewboard">
                
                <div class="serchcrewboard-text">現在　募集中！</div>
                <div class="board-box">
                  <div><a href="/portpolio/studyboard?subject=main"><button class="btn-serchcrewboard">全てを見る</button></a></div>
                </div>
           </div>
           <div class="crewslotbox">
           	<div class="c"> 
            <c:forEach items="${list}" var="board">
           <div class="crewslot" ><div class="photo"><img src="resources/upload/${board.uploadPath}/Index_${board.uuid}_${board.fileName}"  alt="登録されたしゃしんがございません"></div> 
           <div class="studyimpo">
                 
                      <ul>
                        <li>${board.studyname} </li>
                        <li>${board.subject}</li>
                        <li>${board.leader}</li>
                        <li>${board.local} </li>
                        
                      </ul>
                    
                   
                                     
                      
              </div>
              </div>
           	</c:forEach>  
         
          </div>
          </div>
 
        
      </div>
      <div class="review">
            <div class="review-text">
            <p>まよっていますか?  色んなレビューを確認できます。!</p>
            <hr>
            </div> 
           <div class=reviewbutton>
           <a href="/portpolio/review?subject=main"> <button class="btn-serchcrewboard">レビュー</button></a>
           </div> 
             <div class="table">
           <table>
           	   <c:forEach items="${reviewlist}" var="rev">
           	  <tr>
           	  	<td>${rev.writer}</td><td>${rev.subject}</td><td>${rev.content}</td><td>${rev.level}</td><td>${rev.leader}</td>

           	  </tr>
           	 
           	 </c:forEach> 	   

           </table>
            </div>

      </div>

      <div class="leader">
      	<div class="leader-text">
      	<p>リーダーになってみませんか</p>
      </div>
        <div class="leader-box">
        	 <div class="leader-content">
        	     <div class="leader-content-picture"></div>
                <div class="leader-content-text"><p>リーダーになって、あなたの都合いい時間にスタディーを作れます</p></div>
            </div>
             <div class="leader-button-box">
             <a href="/portpolio/studyregister"> <button class="leader-button">リーダー</button></a>
            </div>
      </div>
      </div>
   </div>  <!-- container end-->
   
   <%@ include file="includes/footer.jsp" %>
