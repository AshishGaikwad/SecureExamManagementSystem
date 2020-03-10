$(document).ready(function() {
	
	$("#SubmitUser").click(function() {
		 var validationResult = validateUser();
		 
		 if(validationResult == true)
		 {
			 $.post(BASEURL+"Login", {
				 lFormId:"LoginRequest",
				 lEmail:$("#username").val(),
				 lPassword:$("#password").val()
			}, function(result) {
				if(result === "ACTIVATED")
				{
					$("#err_msg").html("");
					window.location = "Home"
				}else
				{
					$("#err_msg").html(result);
				}
			})
		 }else{
			 
		 }
		 
		 
		 
	});

});

function validateUser() {
	if ($("#username").val() == "") {
		$("#err_msg").html("Please Enter Username");
		return false;
	}else if ($("#password").val() == "") {
		$("#err_msg").html("Please Enter Password")
		return false;
	}  else {
		$("#err_msg").html("")
		return true;
	}
	
	/*
	if ($("#password").val() == "") {
		$("#err_msg").html("Please Enter Password")
		return false;
	} else {
		$("#err_msg").html("")
	}*/
}