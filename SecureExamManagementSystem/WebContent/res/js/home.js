$(document).ready(function() {

});
$(window).load(function() {
	$("#display_name").html(lFullname);
	hideLoader();

})


function setUpUrl(pData) {
	$("#CentralFrame").attr("src",lBasePath+"/page_loader?token="+pData);
}




function hideLoader()
{
	$(".lds-dual-ring").fadeOut(100);
}


function showLoader()
{
	$(".lds-dual-ring").fadeIn(100);
}