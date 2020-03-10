<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>
<style>
.send_ht:hover
{
	text-decoration: underline;
}

</style>

<body id="create_screen">
    <div class="row">
        <div class="col-md-12">
            <div class="panel-group" id="accordion">
                <div class="panel panel-accordion">
                    <div class="panel-heading">
                        <h4 class="panel-title">
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#CreateExaminationAcco">View
                                Examination</a>
                        </h4>
                    </div>
                    <div id="ViewExaminationAcco" class="accordion-body collapse in">
                        <div class="panel-body">
                            <div class="col-sm-12" id="AppliedExaminations">
                                

                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>

    <!-- Modal MD -->
    <!-- 	<a class="mb-xs mt-xs mr-xs modal-sizes btn btn-default"
		href="#modalMD">Medium</a> -->
</body>

<%@ include file="/view/impl/_vendor.jsp"%>
<script>
	$(document).ready(function(){
		
	
	 })
	
    $(window).load(function() {
    	loadAppliedExaminations();
    })
    
    function loadAppliedExaminations()
    {
    	let urlParams = new URLSearchParams();
        urlParams.append("FormType", "AppliedExaminationsTable")
        fetch("/SecureExamManagementSystem/ExaminationController", {
                method: 'POST',
                body: urlParams
            })
            .then(function(response) {
                return response.text()
            })
            .then(
                function(text) {
                 $("#AppliedExaminations").html(""+text)
                })
    }

    function sendHT(pHallTicket)
    {
    	let urlParams = new URLSearchParams();
        urlParams.append("FormType", "SendHT")
        urlParams.append("HallTicket", pHallTicket)
        fetch("/SecureExamManagementSystem/ExaminationController", {
                method: 'POST',
                body: urlParams
            })
            .then(function(response) {
                return response.text()
            })
            .then(
                function(text) {
                alert(text)
                })
    }
    
    function startExamination(pEId){
    	
    	if(confirm("Are you really want to start exam ? It will never reverted")){
    		var iframe = '<html><head><style>body, html {width: 100%; height: 100%; margin: 0; padding: 0}</style></head><body><iframe src="/SecureExamManagementSystem/exam?action=SE&&eid='+pEId+'" style="height:calc(100% - 4px);width:calc(100% - 4px)"></iframe></html></body>';

    	var win = window.open("","","toolbar=no,menubar=no,resizable=yes");
    	win.moveTo(0, 0);
    	win.resizeTo(screen.width, screen.height);
    	win.document.write(iframe);
    	}
    }
</script>

</html>