<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="includes/header.jsp"%>
<link rel="stylesheet" type="text/css" href="resources/css/review.css">








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

			<h1 class="my-4">レビュー</h1>
			<div class="list-group">
				<a href="/portpolio/review?subject=英語" class="list-group-item">英語</a> <a
					href="/portpolio/review?subject=中国語" class="list-group-item">中国語</a> <a
					href="/portpolio/review?subject=日本語" class="list-group-item">日本語</a> <a
					href="/portpolio/review?subject=プログラミング" class="list-group-item">プログラミング</a>

			</div>


		</div>
		<!-- /.col-lg-3 -->
		<div class="col-lg-9">

			<div id="carouselExampleIndicators" class="carousel slide my-4"
				data-ride="carousel">
				
				<div class="carousel-inner" role="listbox">
					<div class="carousel-item active">
						<img class="d-block img-fluid" src="resources/img/girls-1209321_1280.jpg"
							alt="First slide">
					</div>
					
				</div>
				
			</div>
			<div class="review-wrap">
				<div class="review-list-title">
					<span class="review-text">レビュー</span>
					<hr>
				</div>
				<div class="review-list">
					<ul>
						<c:forEach items="${list}" var="board">
							<li>
							    
								<div class="review-content-wrap">
									<div class="writer-name">
										 	<span class="studyname"> <c:out value="${board.studyname}"></c:out></span>
										- (<c:out
											value="${board.leader}"></c:out>)
									
									</div>
									<ul class="score">
										<li><c:out value="${board.score}"></c:out></li>
									</ul>
								</div>
								<div class="review-content">
									<span class="level"><c:out value="${board.level}"></c:out></span>
									<span class="subject"><c:out value="${board.subject}"></c:out></span>

									<span class="content"><c:out value="${board.content}"></c:out></span>
								</div>
								<div class="review-footer">
									<div class="write-date" class="date"><c:out
											value="${board.writedate}"></c:out></div>
											 <span class="leader_review">作成者:<c:out value="${board.writer}"></c:out></span>
								</div>
								<hr>
							</li>
						</c:forEach>



					</ul>

				</div>
				<div class="pull-right">

					<ul class="pagination">
						<c:if test='${pageMaker.prev}'>
							<li class="paginate_button previous"><a
								href="${pageMaker.startPage-1}">前のページ</a></li>
						</c:if>

						<c:forEach var="num" begin="${pageMaker.startPage}"
							end="${pageMaker.endPage}">
							<li class="paginate_button"> <a href="${num}">${num}</a></li>
						</c:forEach>

						<c:if test="${pageMaker.next}">
							<li class="paginate_button next"><a
								href="${pageMaker.endPage+1 }">次のページ</a></li>
						</c:if>

					</ul>
				</div>


			</div>

		</div>

	</div>
	<!-- lg.9 -->


</div>
<!-- /.row -->


<!-- /.container -->
<form id="actionForm" action="/portpolio/review" method="get">
	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	<input type="hidden" name="subject" value="${pageMaker.subject}">

</form>


<!-- Bootstrap core JavaScript -->
<script src="resources/vendor/jquery/jquery.min.js"></script>
<script src="resources/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>






<%@ include file="includes/footer.jsp"%>



