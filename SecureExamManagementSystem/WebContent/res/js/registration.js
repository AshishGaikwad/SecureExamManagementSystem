var currIndex = 0;
var MobileVerified = false;
var EmailVerified = false;

var stack_bottomright = {"dir1": "up", "dir2": "left", "firstpos1": 15, "firstpos2": 15};

var FullName = $("#FullName");
var DateOfBirth = $("#DateOfBirth");
var Password = $("#Password");
var ConfirmPassword = $("#ConfirmPassword");

var FullNameErr = $("#FullNameErr");
var DateOfBirthErr = $("#DateOfBirthErr");
var PasswordErr = $("#PasswordErr");
var ConfirmPasswordErr = $("#ConfirmPasswordErr");



$(document).ready(function() {
	

	
	
	
	
	$("#UploadPhoto").on('change',function(){
		
		var file = this.files[0];
		var fileType = file["type"];
		var validImageTypes = ["image/gif", "image/jpeg", "image/png"];
		if ($.inArray(fileType, validImageTypes) < 0) {
		     alert("Only JPEG, PNG, JPG file supported.");
		     this.value= "";
		}else{
			
			var resp = uploadFile("#UploadPhoto");
			
			$("#Photo").val(""+resp);
			
			setTimeout(function(){
				$("#ViewPhotoA").attr("href","/SecureExamManagementSystem/FILES/"+resp);
				$("#ViewPhotoI").attr("src","FILES/"+resp);
				
				alert("Photo Uploaded Successfully")
			},3000)
			
		}
		
	});
	
	
	$("#UploadSignature").on('change',function(){
		
		var file = this.files[0];
		var fileType = file["type"];
		var validImageTypes = ["image/gif", "image/jpeg", "image/png"];
		if ($.inArray(fileType, validImageTypes) < 0) {
		     alert("Only JPEG, PNG, JPG file supported.");
		     this.value= "";
		}else{
			
			var resp = uploadFile("#UploadSignature");

			
			$("#Signature").val(""+resp);
			
			setTimeout(function(){
				$("#ViewSignatureA").attr("href","/SecureExamManagementSystem/FILES/"+resp);
				$("#ViewSignatureI").attr("src","FILES/"+resp);
				
				alert("Signature Uploaded Successfully")
			},3000)
		}
		
	})
	
	
	$("#BtnSendMobileOTP").click(function(){
		if($("#MobileNo").val().length == 10){
			 	let urlParams = new URLSearchParams();
			    urlParams.append("FormType", "SendMobileOTP");
			    urlParams.append("MobileNo", ""+$("#MobileNo").val());
			    fetch("/SecureExamManagementSystem/RegistrationController", {
			        method: 'POST',
			        body: urlParams
			    }).then(function(response) {
			        return response.text()
			    }).then(
			        function(text) {
			           
			        	if(text == "200")
			        	{
			        		$("#MobileNoOTPMessage").html("OTP Sent Successfully. ");
			        		$("#MobileOTP").prop('disabled', false);
			        		$("#BtnVerifyMobileOTP").prop('disabled', false);
			        		
			        		$("#BtnVerifyMobileOTP").show();
			        		$("#BtnResendMobileOTP").hide();
			        		
			        		setTimeout(function(){
			        			
			        			$("#BtnResendMobileOTP").show();
			        			$("#BtnResendMobileOTP").prop('disabled', false);
			        			}, 30000);
			        		
			        	}else if(text == "-2"){
			        		
			        		$("#BtnVerifyMobileOTP").hide();
			        		$("#BtnResendMobileOTP").show();
			        		$("#MobileNoOTPMessage").html("OTP Sent Failed. ");
			        		
			        	}else
			        	{
			        		$("#BtnVerifyMobileOTP").hide();
			        		$("#BtnResendMobileOTP").show();
			        		$("#MobileNoOTPMessage").html("OTP Sent Failed. ");
			        	}
			        	
			        })
		}
	});
	
	
	
	
	$("#BtnSendEmailOTP").click(function(){
		$("#EmailIdOTPMessage").html("");
		if(validateEmail($("#EmailId").val())){
			 	let urlParams = new URLSearchParams();
			    urlParams.append("FormType", "SendEmailOTP");
			    urlParams.append("EmailId", ""+$("#EmailId").val());
			    fetch("/SecureExamManagementSystem/RegistrationController", {
			        method: 'POST',
			        body: urlParams
			    }).then(function(response) {
			        return response.text()
			    }).then(
			        function(text) {
			           
			        	if(text == "200")
			        	{
			        		$("#EmailIdOTPMessage").html("OTP Sent Successfully. ");
			        		$("#EmailIdOTP").prop('disabled', false);
			        		$("#BtnVerifyEmailIdOTP").prop('disabled', false);
			        		
			        		$("#BtnVerifyEmailIdOTP").show();
			        		$("#BtnResendEmailIdOTP").hide();
			        		
			        		setTimeout(function(){
			        			
			        			$("#BtnResendEmailIdOTP").show();
			        			$("#BtnResendEmailIdOTP").prop('disabled', false);
			        			}, 30000);
			        		
			        	}else if(text == "-2"){
			        		
			        		$("#EmailIdOTPMessage").html("Email Id is already exist please use  another email id.");
			        		
			        	}else
			        	{
			        		$("#BtnVerifyEmailIdOTP").hide();
			        		$("#BtnResendEmailIdOTP").show();
			        		$("#EmailIdNoOTPMessage").html("OTP Sent Failed. ");
			        		$("#BtnResendEmailIdOTP").prop('disabled', false);
			        	}
			        	
			        })
		}else
		{
			alert("Please Enter valid Email")
		}
	});
	
	
	
	
	
	
	
	$("#BtnVerifyMobileOTP").click(function(){
		let urlParams = new URLSearchParams();
	    urlParams.append("FormType", "ValidateMobileOTP");
	    urlParams.append("MobileNo", ""+$("#MobileNo").val());
	    urlParams.append("OTP", ""+$("#MobileOTP").val());
	    fetch("/SecureExamManagementSystem/RegistrationController", {
	        method: 'POST',
	        body: urlParams
	    }).then(function(response) {
	        return response.text()
	    }).then(
	        function(text) {
	           
	        	if(text == "VALIDATED")
	        	{
	        		MobileVerified = true;
	        		$("#MobileNo").prop("disabled",true);
	        		$("#MobileOTP").prop("disabled",true);
	        		$("#BtnVerifyMobileOTP").prop("disabled",true);
	        		
	        		$("#MobileNoOTPMessage").html("Mobile No Is Verified Successfully");
        			$("#BtnResendMobileOTP").hide();
	        		
	        	}else
	        	{
	        		MobileVerified = false;
	        		$("#BtnResendMobileOTP").show();
	        		$("#MobileNoOTPMessage").html("<b style='color:red'>Please Enter Correct OTP</b>");
	        	}
	        	
	        })
		
	})
	
	
	
		$("#BtnVerifyEmailIdOTP").click(function(){
		let urlParams = new URLSearchParams();
	    urlParams.append("FormType", "ValidateEmailOTP");
	    urlParams.append("EmailId", ""+$("#EmailId").val());
	    urlParams.append("OTP", ""+$("#EmailIdOTP").val());
	    fetch("/SecureExamManagementSystem/RegistrationController", {
	        method: 'POST',
	        body: urlParams
	    }).then(function(response) {
	        return response.text()
	    }).then(
	        function(text) {
	           
	        	if(text == "VALIDATED")
	        	{
	        		EmailVerified = true;
	        		$("#EmailId").prop("disabled",true);
	        		$("#EmailIdOTP").prop("disabled",true);
	        		$("#BtnVerifyEmailIdOTP").prop("disabled",true);
	        		$("#BtnResendEmailIdOTP").prop("disabled",true);
	        		
	        		$("#EmailIdOTPMessage").html("Email Id Is Verified Successfully");
	        		
	        	}else
	        	{
	        		$("#BtnResendEmailIdOTP").prop("disabled",false);
	        		
	        		EmailVerified = false;
	        		$("#EmailIdOTPMessage").html("<b style='color:red'>Please Enter Correct OTP</b>");
	        	}
	        	
	        })
		
	})
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

    var $w4finish = $('#RegistrationDetails').find('ul.pager li.finish'),
        $w4validator = $("#RegistrationDetails form").validate({
            highlight: function(element) {
                $(element).closest('.form-group').removeClass('has-success').addClass('has-error');
            },
            success: function(element) {
                $(element).closest('.form-group').removeClass('has-error');
                $(element).remove();
            },
            errorPlacement: function(error, element) {
                element.parent().append(error);
            }
        });

    $w4finish.on('click', function(ev) {
        ev.preventDefault();
        var validated =confInformation();
        if (validated) {
        	
        	

        	let urlParams = new URLSearchParams();
			  urlParams.append("FormType", "RegisterStudent") ;
			  urlParams.append("Body",JSON.stringify(values())); 
			
			fetch("/SecureExamManagementSystem/RegistrationController",
					{ method: 'POST',body: urlParams})
			.then(function(response){
				return response.json();
			})
			.then(function(json){
				
				console.log(json);
				
				
				 new PNotify({
                   title: json.title,
                   text: json.text,
                   type: json.type,
                   addclass: 'stack-bottomright',
                   stack: stack_bottomright
               });
				
				 
				 if(json.type == "success")
				{
					 alert("Redirecting to login page. Please Login");
					 window.location="/SecureExamManagementSystem";
				}
			})
        	
        	
        	
//            new PNotify({
//                title: 'Congratulations',
//                text: 'You completed the wizard form.',
//                type: 'custom',
//                addclass: 'notification-success',
//                icon: 'fa fa-check'
//            });
        }
    });

    $('#RegistrationDetails').bootstrapWizard({
        tabClass: 'wizard-steps',
        nextSelector: 'ul.pager li.next',
        previousSelector: 'ul.pager li.previous',
        firstSelector: null,
        lastSelector: null,
        onNext: function(tab, navigation, index, newindex) {
            var validated = tabValidation();
            if (!validated) {
                // $w4validator.focusInvalid();
                return false;
            }
        },
        onTabClick: function(tab, navigation, index, newindex) {
            if (newindex == index + 1) {
                return this.onNext(tab, navigation, index, newindex);
            } else if (newindex > index + 1) {
                return false;
            } else {
                return true;
            }
        },
        onTabChange: function(tab, navigation, index, newindex) {
            var $total = navigation.find('li').size() - 1;
            $w4finish[newindex != $total ? 'addClass' : 'removeClass']('hidden');
            $('#RegistrationDetails').find(this.nextSelector)[newindex == $total ? 'addClass' : 'removeClass']('hidden');
        },
        onTabShow: function(tab, navigation, index) {
            currIndex = index;

            var $total = navigation.find('li').length - 1;
            var $current = index;
            var $percent = Math.floor(($current / $total) * 100);
            $('#RegistrationDetails').find('.progress-indicator').css({
                'width': $percent + '%'
            });
            tab.prevAll().addClass('completed');
            tab.nextAll().removeClass('completed');
        }
    });


})




function tabValidation() {

    switch (currIndex) {
        case 0:
        	return basicInformation();
            break;
        case 1:
        	return userInformation();
        	break;
        case 2:
        	return pasInformation();
        	break;
        case 3:
        	return confInformation();
        	break;

        default:
            break;
    }



    return true;
}




function basicInformation()
{
	if(!MobileVerified ){
		alert("Please verify mobile number.")
		return false;
	}
		
	
	if(!EmailVerified){
		alert("Please verify email id.")
		return false;
	}
	
	return true;
}

function userInformation()
{
	if(validateFullName()==false && validateDateOfBirth()==false && validatePassword()==false && validateConfirmPassword()==false)
		return true;
	return false;
}
function pasInformation()
{
	if(validateSignature()==true && validatePhoto()==true)
		return true;
	return false;
}
function confInformation()
{
	if($("#AcceptCondtions").prop('checked'))
		return true;
	else {
		alert("Please accept terms and conditions")
	}
		return false;
}



function validateFullName()
{
	if(FullName.val().length< 1)
	{
		FullNameErr.html("Please Enter Full Name");
		return true;
	}else
	{
		FullNameErr.html("");
		return false;
	}
}

function validateDateOfBirth()
{
	if(DateOfBirth.val().length< 1)
	{
		DateOfBirthErr.html("Please pick valid Date of birth");
		return true;
	}else
	{
		DateOfBirthErr.html("");
		return false;
	}
}


function validatePassword()
{
	if(Password.val().length <=  8)
	{
		PasswordErr.html("Password length should greater than 7");
		return true;
	}else
	{
		PasswordErr.html("");
		return false;
	}
}

function validateConfirmPassword()
{
	if(Password.val() != ConfirmPassword.val())
	{
		ConfirmPasswordErr.html("Password is not matched");
		return true;
	}else
	{
		ConfirmPasswordErr.html("");
		return false;
	}
}




function validatePhoto(){
	
	if($("#Photo").val() == "")
	{
		alert("Please upload photo.")
		return false
	}else 
	return true;
	
}


function validateSignature(){
	if($("#Signature").val() == "")
	{
		alert("Please upload photo.")
		return false
	}else 
	return true;
}


function values(){	
	return {
		
		FullName:$("#FullName").val(),
		DateOfBirth:$("#DateOfBirth").val(),
		Password:$("#Password").val(),
		Email:$("#EmailId").val(),
		Mobile:$("#MobileNo").val(),
		Pas:$("#Photo").val()+","+$("#Signature").val()
	}		
}
