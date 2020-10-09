
$(document).ready(function() {
	
					var emailCheck = $("#email_check_button");
					var submitBtn = $("#submitBtn");
					var emailChkVal = $("#email_check_value");
					var pw = $("#pw");
					var cf_pw = $("#cf_pw");

					emailCheck.on("click", function(e) {
						e.preventDefault();
				
					
						var email =	emailChkVal.val()   
						if(isValidEmailAddress(email)){   
												
						$.ajax({
							url : '/portpolio/emailChk',
							type : 'post',
							dataType : "json",
							data : {"email" : email},
							success : function(data) {
									if (data) {
										alert("既に存在します.")
									} else {
										$("#email_check_button").attr(
												"value", "Y");
										alert("使用可能なe-mailです。")
									}
								}
							})
						
						
						}else{
					  
						  alert("正しいemailを作成してください")
					    }
                     
					
				          })
						
						
						
						
					//ajax중복 체크 

					submitBtn.on("click", function(e) {
						e.preventDefault();
                        
						if ((pw.val() == cf_pw.val())
								&& (emailCheck.val() == "Y")
								
						     ) {
							
							$("#reg_form").submit();
						} else if (pw.val() != cf_pw.val()) {

							alert("パスワードが一致しません.")

						} else if (emailCheck.val() == "N") {
							alert("重複確認ボタンを押してください");
							emailChkVal.focus();

						}

					});

					// 이메일 유효성 검사
					
					cf_pw.keyup(function(){
						if (pw.val() == cf_pw.val()){
							$("#validpw").text("パスワードが一致します。");
							$("#validpw").css({
								"color": "green" 
							});
						}else{
							 $("#validpw").text("パスワード一致しません。");
								$("#validpw").css({
									"color":"red"
								});
						}
					})
						
					

					
				
//실시간 정규화 검사 				
$("#email_check_value").keyup(function(){
	
	var email = $("#email_check_value").val();
	
	if(email != 0)
	{
		if(isValidEmailAddress(email))
		{
			
			$("#validEmail").text("正しいe-mailです。");
			$("#validEmail").css({
				"color": "green" 
			});
			
		} else {
		   $("#validEmail").text("e-mailを入力してください");
			$("#validEmail").css({
				"color":"red"
			});
			
		}
	} else {
		$("#validEmail").text(" 例)yamada@daro.com");
		$("#validEmail").css({
			"color": "black" 
		});			
	}

     });
});
//정규화 식
function isValidEmailAddress(emailAddress) {
	var pattern = new RegExp(
			/^(("[\w-\s]+")|([\w-]+(?:\.[\w-]+)*)|("[\w-\s]+")([\w-]+(?:\.[\w-]+)*))(@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$)|(@\[?((25[0-5]\.|2[0-4][0-9]\.|1[0-9]{2}\.|[0-9]{1,2}\.))((25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\.){2}(25[0-5]|2[0-4][0-9]|1[0-9]{2}|[0-9]{1,2})\]?$)/i);
	return pattern.test(emailAddress);
}


				
				
				
				
				
				
				
			
				
				