<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/detail.css">
<link rel="stylesheet" type="text/css" href="resources/css/detailboard_util.css">
<link rel="stylesheet" type="text/css" href="resources/css/detailboard_main.css">
 <script>
   var massage = '${msg}'; 
        
    if(massage===""){
        	   
            	
            }else{
            	alert(massage);
            	
            }
         

          
        
             
            </script>



<!-- Page Content -->
 <div>
    	<div class="jumbotron">
          <div class="jumbotron_text">      
          <p class="detail_text">My page</p>
        
          </div>
         </div>
   </div>
   <div class="container-table100">
			<div class="wrap-table100">
			<span class="detail_text">参加中のスタディー</span>
				<div class="table100 ver1 m-b-110">					
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">スタディー名 </th>
									<th class="cell100 column2">リーダー</th>
									<th class="cell100 column3">地域</th>
									<th class="cell100 column4">科目</th>
									<th class="cell100 column5">レベル</th>
								  
									
									
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							<c:choose>
                                                              
   		                           <c:when test="${student !=''}">
                                     <c:forEach items="${student}" var="boardstudent">  
								<tr class="row100 body">
									<td class="cell100 column1" >${boardstudent.studyname}<a id="linktext" href="/portpolio/studentdelete?studyno=${boardstudent.studyno}">辞める</a>　<a id="linktext" href="/portpolio/reviewWrite?studyno=${boardstudent.studyno}">レビュー作成</a></td>
									<td class="cell100 column2">${boardstudent.leader}</td>
									<td class="cell100 column3">${boardstudent.local}</td>
									<td class="cell100 column4">${boardstudent.subject}</td>
									<td class="cell100 column5">${boardstudent.level}</td>
					
									
								</tr>
                                    </c:forEach>                                    
                                      </c:when>
                                            <c:otherwise>
                      
                                          <tr><td>参加中のスタディーがありません。</td></tr>
                               </c:otherwise>             
                           
                             </c:choose>
                                
								
							</tbody>
							   
						</table>
						
					</div>
					
				</div>
				
		    </div>		
    </div>
 
     
     
     
     
     
     
     
     <div class="container-table100">
			<div class="wrap-table100">
				<span class="detail_text">スタディー参加者管理</span>
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">スタディー名</th>
									<th class="cell100 column2">科目</th>
									<th class="cell100 column3">スタディー参加者</th>
									<th class="cell100 column4">e-mail</th>
									<th class="cell100 column5">脱退</th>
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							<c:choose>
                                                              
   		                           <c:when test="${leader != ''}">
                                     <c:forEach items="${leader}" var="boardleader">  
								<tr class="row100 body">
									<td class="cell100 column1">${boardleader.studyname}</td>
									<td class="cell100 column2">${boardleader.subject}</td>
									<td class="cell100 column3">${boardleader.name}</td>
									<td class="cell100 column4">${boardleader.email}</td>
									<td class="cell100 column5"><a  id="linktext" href="/portpolio/leaderdelete?email=${boardleader.email}&studyno=${boardleader.studyno}">脱退させる</a></td>
									
								</tr>
                                    </c:forEach>                                    
                                      </c:when>
                                            <c:otherwise>
                      
                                      <tr><td>参加中のスタディーがありません。</td></tr>
                               </c:otherwise>             
                           
                             </c:choose>
                                
								
							</tbody>
						</table>
						
					</div>
				</div>
		    </div>		
    </div>
     
     
     
     
     
     
     
     <div class="container-table100">
			<div class="wrap-table100">
			<span class="detail_text">スタディー管理</span>
				<div class="table100 ver1 m-b-110">
					<div class="table100-head">
						<table>
							<thead>
								<tr class="row100 head">
									<th class="cell100 column1">スタディー名</th>
									<th class="cell100 column2">定員</th>
									<th class="cell100 column3">費用</th>
									<th class="cell100 column4">地域</th>
									<th class="cell100 column5">科目</th>
									
								</tr>
							</thead>
						</table>
					</div>

					<div class="table100-body js-pscroll">
						<table>
							<tbody>
							<c:choose>
                                                              
   		                           <c:when test="${studyinpo != ''}">
                                     <c:forEach items="${studyinpo}" var="studyinpo">  
								<tr class="row100 body">
									<td class="cell100 column1">${studyinpo.studyname}<a  id="linktext" href="/portpolio/studymodify?studyno=${studyinpo.studyno}"><span>　修正　</span></a><a  id="linktext" href="/portpolio/studydelete?studyno=${studyinpo.studyno}&email=${studyinpo.email}"><span>辞める</span></a></td>
									<td class="cell100 column2">${studyinpo.quota}</td>
									<td class="cell100 column3">${studyinpo.cost}</td>
									<td class="cell100 column4">${studyinpo.local}</td>
									<td class="cell100 column5">${studyinpo.subject}</td>
									
									
								</tr>
                                    </c:forEach>                                    
                                      </c:when>
                                            <c:otherwise>
                      
                                          <tr><td>スタディーがありません.</td></tr>
                               </c:otherwise>             
                           
                             </c:choose>
                                
								
							</tbody>
						</table>
					</div>
					
				</div>
		
		    </div>		
    </div>


<!-- /.container -->



<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>






<%@ include file="includes/footer.jsp"%>

