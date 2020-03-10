$(document).ready(function() {

	$('#RoleName').on('change', function () {
	     var selectedValue = this.selectedOptions[0].value;
	     var selectedText  = this.selectedOptions[0].text;
	     $("#RoleMappingTable").html("");
	     
	     
	     if(selectedValue > 0 )
	    	 getAllScreen(); getMappings(selectedValue);
	    
	});
	
	$("#AddRoleBtn").click(function() {
		put(BASEURL + "roles", {
			RequestType : "AddNewRole",
			RoleName:$("#AddRole").val()
		},function(data)
		{
			alert(data);
			getRoles();
			$("#AddRole").val("")
			$("#RoleMappingTable").html("");
		});
		
	});
	
	
	$("#CreateScreenButton").click(function(){
		
		debugger;	
		var lData = new Array();;
		$('#RoleMappingTable tbody tr').each(function(){
			
			var trId = $(this).attr("id").split("-");
			var ScreenId = trId[1];			
			
//			alert(typeof $("table#RoleMappingTable tbody #tr-"+ScreenId+" #check-"+ScreenId+"").prop("checked"))
			if($("table#RoleMappingTable tbody #tr-"+ScreenId+" #check-"+ScreenId+"").prop("checked") == true)
			{
				var tempJSON = {};
				tempJSON["RoleId"] = $("#RoleName option:selected").val();
				tempJSON["UserId"] = ScreenId;
				var R = $("table#RoleMappingTable tbody #tr-"+ScreenId+" #r-"+ScreenId+"").prop("checked") == true?1 : 0 ;
				var W = $("table#RoleMappingTable tbody #tr-"+ScreenId+" #w-"+ScreenId+"").prop("checked") == true?1 : 0 ;
				var U = $("table#RoleMappingTable tbody #tr-"+ScreenId+" #u-"+ScreenId+"").prop("checked") == true?1 : 0 ;
				var D = $("table#RoleMappingTable tbody #tr-"+ScreenId+" #d-"+ScreenId+"").prop("checked") == true?1 : 0 ;
				var RWUD = R+"~"+W+"~"+U+"~"+D;
				tempJSON["filler1"] = RWUD;
				tempJSON["Rowstate"] = 1;
				lData.push(tempJSON);
			}else
			{
//				alert("in else")
			}
			
			
			
		});
		
		
		
		put(BASEURL + "roles", {
			RequestType : "AddRoleMapping",
			RoleMappingData:JSON.stringify(lData)
		},function(data)
		{
			alert(data);
			$("#AddRole").val("")
//			$("#RoleMappingTable").html("");
		});
//		alert(JSON.stringify(lData))
	})
	
	
	
	
});

$(window).load(function() {
	getRoles();
// $("#RoleMappingTable").DataTable({
//
// });
})


function getRoles() {
	var lData = get(BASEURL + "roles", {
		RequestType : "GetAllRoles"
	});


	lData = JSON.parse(lData);
	$("#RoleName").html("");
	$("#RoleName").append(
			"<option value=\"" + 0 + "\">" + "Please Select Role"
					+ "</option>");
	$.each(lData, function(key, value) {

		$("#RoleName").append(
				"<option value=\"" + value.RoleId + "\">" + value.RoleName
						+ "</option>");
	})
}

function createRole()
{
}

var getAllScreen = function(){
	
	var lData = get(BASEURL + "screen", {
		RequestType : "GetAllScreens"
	});
	
	lData = JSON.parse(lData);
	
	var builder = ""
	$.each(lData, function(key, value) {

		builder = builder+
				`	<tr id="tr-${value.ScreenId}">
						<td><input type="checkbox" id="check-${value.ScreenId}"></td>
						<td>${value.ScreenId}</td>
						<td>${value.ScreenName}</td>
						<td><input type="checkbox" id="r-${value.ScreenId}"></td>
						<td><input type="checkbox" id="w-${value.ScreenId}"></td>
						<td><input type="checkbox" id="u-${value.ScreenId}"></td>
						<td><input type="checkbox" id="d-${value.ScreenId}"></td>
					</tr>`
		
	});
	
	$("#RoleMappingTable").html("");
	
	$("#RoleMappingTable").append(	`<thead>
			<tr>
			<th>Select</th>
			<th>Screen Id</th>
			<th>Screen Name</th>
			<th>Read</th>
			<th>Write</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
	</thead><tbody>${builder}</tbody>`)
}


var getMappings = function(pRoleId){
	var lData = get(BASEURL + "roles", {
		RequestType : "GetUsersMappedRole",
		pRoleID:pRoleId
	});
	lData = JSON.parse(lData);
	
	var parent = "table#RoleMappingTable tbody"
	$.each(lData,function(key,value){
		
		var pData = (value.RWUD).split("~");
		var pR = pData[0];
		var pW = pData[1];
		var pU = pData[2];
		var pD = pData[3];
		
			
		
		var query = parent+" #tr-"+value.s_id+" #check-"+value.s_id
		$(query).prop("checked",true)
		
		if(pR == "1")
			$(parent+" #tr-"+value.s_id+" #r-"+value.s_id).prop("checked",true)
		else
			$(parent+" #tr-"+value.s_id+" #r-"+value.s_id).prop("checked",false);
		if(pW == "1")
			$(parent+" #tr-"+value.s_id+" #w-"+value.s_id).prop("checked",true)
		else
			$(parent+" #tr-"+value.s_id+" #w-"+value.s_id).prop("checked",false)
		if(pU == "1")
			$(parent+" #tr-"+value.s_id+" #u-"+value.s_id).prop("checked",true)
		else
			$(parent+" #tr-"+value.s_id+" #u-"+value.s_id).prop("checked",false)
		if(pD == "1")
			$(parent+" #tr-"+value.s_id+" #d-"+value.s_id).prop("checked",true)
		else
			$(parent+" #tr-"+value.s_id+" #d-"+value.s_id).prop("checked",false)
		
		
		
	})
	
	
}
