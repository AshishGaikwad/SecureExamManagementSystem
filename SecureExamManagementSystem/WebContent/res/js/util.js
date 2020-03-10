function get(pPageName, pJsonData) {
	var lData;
	$.ajaxSetup({
		async : false
	})

	$.post(pPageName, pJsonData, function(data) {
		lData = data;
	})
	$.ajaxSetup({
		async : true
	})

	return lData;
}

function put(pPageName, pJsonData, pCallBack) {

	$.post(pPageName, pJsonData, pCallBack)

}

function validateEmail(mail) {
	if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(mail)) {
		return (true)
	}
	// alert("You have entered an invalid email address!")
	return (false)
}

jQuery.fn.ForceNumericOnly = function() {
	return this
			.each(function() {
				$(this)
						.keydown(
								function(e) {
									var key = e.charCode || e.keyCode || 0;
									// allow backspace, tab, delete, enter,
									// arrows, numbers and keypad numbers ONLY
									// home, end, period, and numpad decimal
									return (key == 8 || key == 9 || key == 13
											|| key == 46 || key == 110
											|| key == 190
											|| (key >= 35 && key <= 40)
											|| (key >= 48 && key <= 57) || (key >= 96 && key <= 105));
								});
			});
};

	var pImageData = "";

function getFileAsString(pFileId, pTarget)
{
	
	var filesSelected = document.getElementById(pFileId).files;
	var pImg = "";
	if(filesSelected.length > 0)
		{
			var fileToLoad = filesSelected[0];
			var fileReader = new FileReader();
			fileReader.onload = function(fileLoadedEvent){
				pImageData = "";
				pImg = fileLoadedEvent.target.result;	
				
				$("#"+pTarget).val(pImg);
			}
			fileReader.readAsDataURL(fileToLoad);
		}
	
}


function setImage(pImg)
{
	pImageData = "";
	pImageData = pImg;
}


function getImage()
{
	return pImageData;
}




function isDateGreater(pStartDate, pEndDate)
{
	var g1 = new Date(formatDate(pStartDate)); 
    var g2 = new Date(formatDate(pEndDate)); 
    
    if (g1.getTime() < g2.getTime()) 
        return true
    else
       return false;
}



function formatDate(pDate)
{
	var date = pDate.split("/");
	
	
	return date[1]+"/"+date[0]+"/"+date[2];
}




function uploadFile(pFileQuerySelctor){
	var fileResp = "";
	var data = new FormData();     
	jQuery.each($(pFileQuerySelctor)[0].files, function(i, file) {
	    data.append(i, file);
	});
	
	$.ajaxSetup({
		  async: false
		});
	
	$.ajax({
	    method:"POST",
	    contentType: 'multipart/form-data',
	    data: data,
	    url: "/SecureExamManagementSystem/FileUploader",
	    cache: false,
	    contentType: false,
	    processData: false,
	    success: function(pData){
	    	fileResp = pData;
	    }
	});
	
	$.ajaxSetup({
		  async: true
		});
	
	
	return fileResp;
}







function openPopup(popUpName) { // get the class name in arguments here
    $.magnificPopup.open({
        items: {
            src: popUpName,
        },
        type: 'inline'
    });
}


function todayDate(){
	var td = new Date()
	return (td.getMonth()+1) +"/"+td.getDate()+"/"+td.getFullYear();
}


