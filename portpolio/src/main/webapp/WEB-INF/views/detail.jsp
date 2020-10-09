<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/detail.css">

<!-- Page Content -->
 <div>
    	<div class="jumbotron">
          <div class="jumbotron_text">      
          <p class="detail_text">My page</p>
        
          </div>
         </div>
       </div>


<div class="container">
        
	<div class="row">
         
         
       <!-- 내가 참가중인 스터디 -->  
         
         <div class="studentbox">
                     <div class="student_text">
                         <div class="student_box">내가 참가중인 스터디</div>    
                    </div>
            <div class="student_content">
                  <table class="student_tables">
                                <tr> 
                                             <th class="student_leader">리더</th>             
                                             <th class="student_name">스터디이름</th>
                                             <th class="student_local">지역</th>
                                             
                                             <th class="student_subject">과목</th>
                                             <th class="student_content">내용</th>
                                              <th class="student_level">레벨</th>
                                              <th class="student_quit">그만두기</th>  
                                        
                                </tr> 
                          
                            
                           
                             <c:choose>
                             
   		                          <c:when test="${student != null}">
                                           <c:forEach items="${student}" var="boardstudent">   
                                         <tr>  
                                             <td class="student_leader"><c:out value="${boardstudent.leader}"></c:out></td>             
                                             <td class="student_name"><c:out value="${boardstudent.studyname}"></c:out></td>
                                             <td class="student_local"><c:out value="${boardstudent.local}"></c:out></td>
                                            
                                             <td class="student_subject"><c:out value="${boardstudent.subject}"></c:out></td>
                                             <td class="student_content"><c:out value="${boardstudent.content}"></c:out></td>
                                              <td class="student_level"><c:out value="${boardstudent.level}"></c:out></td>
                                              <td class="student_quit"><a href="#">그만두기</a></td>  
                                        
                                         </tr> 
                                          </c:forEach> 
                                 </c:when>
                                 
                          
                           <c:otherwise>                 
                                          <tr><td>조회 된 정보가 없습니다.</td></tr>    
                    </c:otherwise>
                    
                      </c:choose>
                  </table>   <!--참가중 스터디 테이블  -->
                       
              </div>
         
         
         </div>
        
        
        <!-- 스터디원 관리하기 -->
        <div class=leaderbox>
              <div class="leader_text">
                        <div class="leader_box">스터디원 관리 하기</div>
        
             </div>
              <div class="leader_content">
                        <table border="1">
                                     <tr>         
                                             <th>스터디 이름</th>
                                             <th>과목</th>
                                             <th>스터디원이름</th>
                                             <th>이메일</th>
                                             <th><a href="#">탈퇴시키기</a></th>  
                      
                                      </tr>                        
                        
                                 
                                <c:choose>
   		                          <c:when test="${leader != null}">
                                       <c:forEach items="${leader}" var="boardleader">  
                                       <tr>         
                                             <td><c:out value="${boardleader.studyname}"></c:out></td>
                                             <td><c:out value="${boardleader.subject}"></c:out></td>
                                             <td><c:out value="${boardleader.name}"></c:out></td>
                                             <td><c:out value="${boardleader.email}"></c:out></td>
                                             <td><a href="#">탈퇴시키기</a></td>  
                      
                                      </tr>
                                      </c:forEach> 
                                 </c:when>
                              
                            
                             <c:otherwise>
                     
                                            <tr><td>조회 된 정보가 없습니다.</td></tr>
                           </c:otherwise>
                           </c:choose>
                           
                       </table>
                
                        
                        
                        
                            
              </div>
        
        </div>
        <!-- 스터디 정보변경 -->
         <div class="studyinpobox">
                      <div class="studyinpo_text">
                               <div class="studyinpo_box">스터디 정보변경</div>
              
                      </div>
              
              
                   <div class="studyinpo_content">
                 
                             <table border="1">  
                                               <tr>                         
                                                 <th class="red">스터디 이름</th>
                                                   <th>리더 이름</th>
                                              <th>정원</th>
                                               <th>비용</th>
                                                 <th>지역</th>
                                                <th>과목</th>
                                             <th>내용</th>
                                                 <th>수정/그만두기</th>                                                       
                                              </tr>   
                                               
                                      
                                 <c:choose>
                                                              
   		                                <c:when test="${studyinpo != null}">
                                            <c:forEach items="${studyinpo}" var="studyinpo">  
                                              <tr>                         
                                                 <td><c:out value="${studyinpo.studyname}"></c:out></td>
                                                 <td><c:out value="${studyinpo.leader}"></c:out></td>
                                                 <td><c:out value="${studyinpo.quota}"></c:out></td>
                                                 <td><c:out value="${studyinpo.cost}"></c:out></td>
                                                 <td><c:out value="${studyinpo.local}"></c:out></td>
                                                 <td><c:out value="${studyinpo.subject}"></c:out></td>
                                                 <td><c:out value="${studyinpo.content}"></c:out></td>
                                                 <td><a href="#">수정하기</a><a href="#">그만두기</a></td>                                                       
                                              </tr>   
                                               </c:forEach>                                    
                                      </c:when>
                                
                         
                                  
                                    
                                   <c:otherwise>
                      
                                          <tr><td>조회 된 정보가 없습니다.</td></tr>
                               </c:otherwise>             
                           
                             </c:choose>
                                          
                         
                         
                         </table>
                     
              </div>
         
         
         </div>        	
  </div>
  <!-- /.row -->
</div>



<!-- /.container -->



<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>






<%@ include file="includes/footer.jsp"%>



