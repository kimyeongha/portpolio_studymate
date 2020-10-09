<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<link rel="stylesheet" type="text/css"
	href="resources/css/studyboard.css">
<script type="text/javascript" src="resources/js/studyboard.js"></script>
 <script>
   var massage = '${msg}'; 
        
    if(massage===""){
        	   
            	
            }else{
            	alert(massage);
            	
            }
    $(document).ready(function() {
		var actionForm = $("#actionForm");
		$(".paginate_button a").on("click", function(e) {
			e.preventDefault();
			
			actionForm.find("input[name='pageNum']").val($(this).attr("href"));
			actionForm.submit();

		});

	});
 
         

          
        
             
            </script>
 
 
 <!-- Page Content -->
  <div class="container">

    <div class="row">

      <div class="col-lg-3">

        <h1 class="my-4">どんなスタティーを探していますか。</h1>
        <div class="list-group">
          <a href="/portpolio/studyboard?subject=英語" class="list-group-item">英語</a>
          <a href="/portpolio/studyboard?subject=中国語" class="list-group-item">中国語</a>
          <a href="/portpolio/studyboard?subject=日本語" class="list-group-item">日本語</a>
          <a href="/portpolio/studyboard?subject=プログラミング" class="list-group-item">プログラミング</a>
          <span>今、参加中のスタディーは<c:out value="${studylimit}"></c:out>個です。 (最大4個)</span>
      
        </div>

      </div>
      <!-- /.col-lg-3 -->

      <div class="col-lg-9">

        <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
          <ol class="carousel-indicators">
            <li data-target="#carouselExampleIndicators" data-slide-to="0" class="active"></li>
            <li data-target="#carouselExampleIndicators" data-slide-to="1"></li>
         
          </ol>
          <div class="carousel-inner" role="listbox">
            <div class="carousel-item active">
              <img class="d-block img-fluid" src="resources/img/books-768426_1280.jpg" alt="First slide">
            </div>
            <div class="carousel-item">
              <img class="d-block img-fluid" src="resources/img/library-1400312_1280.jpg" alt="Second slide">
              
            </div>
            
          </div>
          <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="sr-only">Previous</span>
          </a>
          <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="sr-only">Next</span>
          </a>
        </div>

        <div class="row">

         

        
           
          <c:forEach items="${list}" var="board">
          <div class="col-lg-4 col-md-6 mb-4">
            <div class="card h-100">
              <img class="card-img-top" src="resources/upload/${board.uploadPath}/s_${board.uuid}_${board.fileName}" alt="등록된사진이 없습니다.">
              <div class="card-body">
                <h4 class="card-title">
                 
                 
                </h4>
                                                                                                                                                                                                                                                                                                                                                                                                                                                            
                <table class="card-text">
                   <tr><td colspan="2" id="studyname" ><c:out value="${board.studyname}" /></td></tr>
                    <tr><td colspan="2"><h5><c:out value="${board.leader}"></c:out></h5></td></tr>
                   <tr>
                      <td id="quota"><c:out value="${board.quota}"></c:out>人</td><td><c:out value="${board.cost}"></c:out>千円</td>                     
                   </tr>
                   <tr>
                      <td><c:out  value="${board.local}"></c:out></td><td><c:out value="${board.subject}"></c:out></td>                     
                   </tr>
                   <tr>
                      <td colspan="2"><c:out value="${board.content}"></c:out></td>  
                                     
                   </tr>
                  
                      <tr><td colspan="2"><a href="/portpolio/replystudy?studyno=${board.studyno}&email=${sessionScope.userInpo.email}&name=${sessionScope.userInpo.name}&studyname=${board.studyname}&level=${board.level}&quota=${board.quota}&content=${board.content}&local=${board.local}&leader=${board.leader}&subject=${board.subject}&leaderemail=${board.email}"><button class="supply_btn" >apply </button></a></td></tr> 
                        <tr><td><!-- ${board.uploadPath}\s_${board.uuid}_${board.fileName} --></td></tr>
                </table>
             
              <!--    <p class="card-text"><table><tr><td></td></tr></table></p>-->
              </div>
            
            </div>
          </div>
        </c:forEach>
           


        </div>
        <!-- /.row -->
             <div class="pull-right">                            
					<ul class="pagination">
						<c:if test='${pageMaker.prev}'>
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1}">前へ</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button"> <a href="${num}">${num}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage+1 }">次へ</a></li>
						</c:if>

					</ul>
				</div>
      </div>
      <!-- /.col-lg-9 -->

    </div>
    <!-- /.row -->

  </div>
  <!-- /.container -->
  <!--  
  <form action="/portpolio/studyboard" method="post">
     <input type="hidden">
      <input type="hidden" value="${sessionScope.userInpo}">
  </form>
 -->

<form id="actionForm" action="/portpolio/studyboard?subject= ${subject}" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	<input type="hidden" name="subject" value="${pageMaker.subject}">

</form>





  <!-- Bootstrap core JavaScript -->
  <script src="resources/vendor/jquery/jquery.min.js"></script>
  <script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>






<%@ include file="includes/footer.jsp"%>




