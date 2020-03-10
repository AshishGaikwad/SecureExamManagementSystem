var ActionState = 'none'

var FullName = $("#FullName");
var EmailId = $("#EmailId");
var DateOfBirth = $("#DateOfBirth");
var MobileNo = $("#MobileNo");
var Status = $("#Status");
var Password = $("#Password");
var ConfirmPassword = $("#ConfirmPassword");
var Roles = $("#Roles");
var UserId = $("#UserId");
var ButtonCreateUser = $("#ButtonCreateUser");
var ButtonEditUser = $("#ButtonEditUser");
var UserSubmitButton = $("#UserSubmitButton");

var FullNameErr = $("#FullNameErr");
var EmailIdErr = $("#EmailIdErr");
var DateOfBirthErr = $("#DateOfBirthErr");
var MobileNoErr = $("#MobileNoErr");
var StatusErr = $("#StatusErr");
var PasswordErr = $("#PasswordErr");
var ConfirmPasswordErr = $("#ConfirmPasswordErr");
var RolesErr = $("#RolesErr");

var FullName_Err = false;
var EmailId_Err = false;
var DateOfBirth_Err = false;
var MobileNo_Err = false;
var Status_Err = false;
var Password_Err = false;
var ConfirmPassword_Err = false;
var Roles_Err = false;

$(document).ready(function() {

	ButtonCreateUser.on('click', function() {
		enableAll();
		clearAll();
		ActionState = 'add'
			
		UserSubmitButton.html("Add User");
	});
	
	ButtonEditUser.on('click', function() {
		enableAll();
		clearAll();
		ActionState = 'edit'
		UserSubmitButton.html("Edit User");
	});
	
	
	
	
//	$(".user-table-data td").click(function(){
////		$.magnificPopup.close();
//		 var $row = $(this).closest("tr");    // Find the row
//	    var $text = $row.find(".nr").text(); // Find the text
//	    
//	    // Let's test it out
//	    alert($text);
//	})
//	
	
	UserSubmitButton.on('click', function() {
		
		FullName_Err = false;
		EmailId_Err = false;
		DateOfBirth_Err = false;
		MobileNo_Err = false;
		Status_Err = false;
		Password_Err = false;
		ConfirmPassword_Err = false;
		Roles_Err = false;
		
		
		
		validateFullName();
		validateEmailId();
		validateDateOfBirth();
		validateMobileNo();
//		validateStatus();
		validatePassword();
		validateConfirmPassword();
//		validateRoles();
		
		if(FullName_Err == false && EmailId_Err == false && DateOfBirth_Err==false && MobileNo_Err==false && Status_Err==false && Password_Err==false && ConfirmPassword_Err == false && Roles_Err == false)
		{
			var rType ="";
			
			if(ActionState == 'add')
				 rType ="AddNewUser";
			else if(ActionState == 'edit')
				 rType ="EditNewUser";
			
			var rol=Roles.val();
			
			var params = {
					RequestType : rType,
					UserId:UserId.val(),
					FullName : FullName.val(),
					EmailId:EmailId.val(),
					DateOfBirth:DateOfBirth.val(),
					MobileNo:MobileNo.val(),
					Status:Status.val(),
					Password:Password.val(),
					ConfirmPassword:ConfirmPassword.val(),
					RolesData:rol+""
				}
			
			put(BASEURL + "user",params,function(data){
				alert(data);
				userPromise();
				clearAll();
				disableAll();
			})
		}
	});
	
	
	
	

})

$(window).load(function() {
	getRealtedRoles();
	getUserStatus();
	userPromise();
	disableAll();
	if (ActionState == 'none') {
		UserSubmitButton.hide();
	}

})

function getRealtedRoles() {
	Roles.html("");
	var lData = get(BASEURL + "roles", {
		RequestType : "GetAllRoles",
	});

	lData = JSON.parse(lData);

	$.each(lData, function(key, value) {
		Roles.append("<option value=\"" + value.RoleId + "\">" + value.RoleName
				+ "</option>")
	})
}

function getUserStatus() {
	Status.html("");
	lData = [ "","ACTIVE", "INACTIVE" ];

	$.each(lData, function(key, value) {
		Status.append("<option value=\"" + key + "\">" + value + "</option>")
	})
}

function disableAll() {
	FullName.prop("disabled", true)
	EmailId.prop("disabled", true)
	DateOfBirth.prop("disabled", true)
	MobileNo.prop("disabled", true)
	Status.prop("disabled", true)
	Password.prop("disabled", true)
	ConfirmPassword.prop("disabled", true)
	Roles.prop("disabled", true)
}

function clearAll() {
	FullName.val("")
	UserId.val("")
	EmailId.val("")
	DateOfBirth.val("")
	MobileNo.val("")
	Status.val("")
	Password.val("")
	ConfirmPassword.val("")
	Roles.val("[]")
}


function enableAll() {
	FullName.prop("disabled", false)
	EmailId.prop("disabled", false)
	DateOfBirth.prop("disabled", false)
	MobileNo.prop("disabled", false)
	Status.prop("disabled", false)
	Password.prop("disabled", false)
	ConfirmPassword.prop("disabled", false)
	Roles.prop("disabled", false)

	UserSubmitButton.show();
}


function validateFullName()
{
	if(FullName.val().length< 1)
	{
		FullNameErr.html("Please Enter Full Name");
		FullName_Err = true;
	}else
	{
		FullNameErr.html("");
		FullName_Err = false;
	}
}

function validateEmailId()
{
	if(!validateEmail(EmailId.val()))
	{
		EmailIdErr.html("Please Enter Valid Email Id");
		EmailId_Err = true;
	}else if(EmailId.val().length< 1){
		EmailIdErr.html("Please Enter Valid Email Id");
		EmailId_Err = false;
	}else
	{
		EmailIdErr.html("");
		EmailId_Err = false;
	}
}

function validateDateOfBirth()
{
	if(DateOfBirth.val().length< 1)
	{
		DateOfBirthErr.html("Please pick valid Date of birth");
		DateOfBirth_Err = true;
	}else
	{
		DateOfBirthErr.html("");
		DateOfBirth_Err = false;
	}
}

function validateMobileNo()
{
	if(MobileNo.val().length< 1)
	{
		MobileNoErr.html("Please enter correct Mobile No");
		MobileNo_Err = true;
	}else
	{
		MobileNoErr.html("");
		MobileNo_Err = false;
	}
}

function validateStatus()
{
	if(Status.select2("val").length < 1)
	{
		StatusErr.html("Please Select Status");
		Status_Err = true;
	}else if(Status.select2("val") ==  0)
	{
		StatusErr.html("Please Select Status");
		Status_Err = false;
	}else
	{
		StatusErr.html("");
		Status_Err = false;
	}
}

function validatePassword()
{
	if(Password.val().length <=  8)
	{
		PasswordErr.html("Password length should greater than 7");
		Password_Err = true;
	}else
	{
		PasswordErr.html("");
		Password_Err = false;
	}
}

function validateConfirmPassword()
{
	if(Password.val() != ConfirmPassword.val())
	{
		ConfirmPasswordErr.html("Password is not matched");
		ConfirmPassword_Err = true;
	}else
	{
		ConfirmPasswordErr.html("");
		ConfirmPassword_Err = false;
	}
}

function validateRoles()
{
	if(Roles.select2("val").length< 1)
	{
		RolesErr.html("Please Select Role");
		Roles_Err = true;
	}else if(Status.select2("val") ==  0)
	{
		RolesErr.html("Please Select Role");
		Roles_Err = false;
	}else
	{
		RolesErr.html("");
		Roles_Err = false;
	}
}



function userPromise(){
	
	var urlParams = new URLSearchParams();
	urlParams.append("RequestType","GetAllUser")
	
	var params = {
			method:'POST',
			body:urlParams
		}
	fetch(BASEURL + "user",params)
	.then(function(response){return response.json()})
	.then(function(json){
		$("#AllUserTable tbody").html("");
		
		console.log(json)
		
		$.each(json,function(key,value)
		{
			$("#AllUserTable tbody").append(`
					<tr class="user-table-data" onclick="userTableRowClicked('${value.UserId}')" id="user-${value.UserId}">
						<td>${value.UserId}</td>
						<td>${value.FullName}</td>
						<td>${value.Email}</td>
						<td>${value.Mobile}</td>
					</tr>
			`);
			
			
		})
		
		table = $('#AllUserTable').DataTable();
		 
		table.destroy();
		 
		table = $('#AllUserTable').DataTable( {
			"paging": false
		} );
		
		
	}).catch(function(errer){
		
	})
	
	
}

function userTableRowClicked(pId){
	
	
	var urlParams = new URLSearchParams();
	urlParams.append("RequestType","GetUser");
	urlParams.append("UserId",pId);
	
	var params = {
			method:'POST',
			body:urlParams
		}
	fetch(BASEURL + "user",params)
	.then(function(response){return response.json()})
	.then(function(json){
		
		var RolesArray = json.Roles;
			FullName.val(json.FullName);
			EmailId.val(json.Email);
			DateOfBirth.val(json.DateOfBirth);
			MobileNo.val(json.Mobile);
			Status.val(json.Status);
			Password.val(json.Password);
			ConfirmPassword.val(json.Password);
			UserId.val(json.UserId);
			Roles.val(RolesArray);
			Roles.trigger('change');
//			ConfirmPassword.val();
			
			
			enableAll();
			
			
			
		
	}).catch(function(errer){
		
	})
	
	
	$.magnificPopup.close();
}

