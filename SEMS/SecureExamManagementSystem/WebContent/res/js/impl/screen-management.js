$(document).ready(function(){
	$("#CreateScreenButton").click(function(){
		createScreen();
	});
	
	
	
	
	
});


$(window).load(function(){
	getParentScreen();
})



function getParentScreen()
{
	var lData = get(BASEURL+"screen",{
		RequestType:"GetScreenParentList"
	});
	
	lData = JSON.parse(lData);
	
	$.each(lData,function(key,value){
		$("#ScreenParent").append("<option value=\""+value.ScreenId+"\">"+value.ScreenName+"</option>");
	})
}

function createScreen(){
	if($("#ScreenName").val() == "")
	{
		alert("Please Enter Screen Name.");
	}else if($("#ScreenURL").val() == "")
	{
		alert("Please Enter Screen URL.");
	}
	else{
		
		if($("#ScreenName").val() != "" && $("#ScreenURL").val() != "")
		{
			put(BASEURL+"screen",{
				RequestType:"CreateScreen",
				ScreenName:$("#ScreenName").val(),
				ScreenParent:$("#ScreenParent option:selected").val(),
				ScreenUrl : $("#ScreenURL").val(),
				ScreenIcon:$("#ScreenIcon").val(),
				
				
			},function(data){
				alert(data);
				$("#ScreenName").val("");
				$("#ScreenParent option:selected").val("0");
				 $("#ScreenURL").val("");
				 $("#ScreenIcon").val("")
				
			})
		}
	}
	
	
};



