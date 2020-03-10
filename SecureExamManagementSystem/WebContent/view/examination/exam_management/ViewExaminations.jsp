<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>

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
                            <div class="col-sm-12">
                                <table id="TableViewExaminations" class="table table-bordered mb-none">
                                    <thead>
                                        <tr>
                                            <th>#</th>
                                            <th>Name</th>
                                            <th>Start Date</th>
                                            <th>End Date</th>
                                            <th>Hall Ticket Date</th>
                                            <th>Exam Date</th>
                                            <th>Result Date</th>
                                            <th>Fee</th>
                                            <th>Apply</th>
                                        </tr>
                                    </thead>
                                    <tbody>


                                    </tbody>
                                </table>

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

    <div id="modalApply" class="modal-block modal-block-md mfp-hide">
        <section class="panel">
            <header class="panel-heading">
                <h2 class="panel-title">Please Read Examination Details then apply</h2>
            </header>
            <div class="panel-body" id="currExamDetail" style="height:230px; overflow:scroll">

            </div>
            <footer class="panel-footer">
                <div class="row">
                    <div class="col-md-12 text-right">
                    	<input type="hidden" value="" id="currentExaminationDetails">
                        <button class="btn btn-primary" id="MakePayment">Payment & Apply</button>
                        <button class="btn btn-default modal-dismiss">Cancel</button>
                    </div>
                </div>
            </footer>
        </section>
    </div>
</body>

<%@ include file="/view/impl/_vendor.jsp"%>
<script>
	$(document).ready(function(){
		
		$("#MakePayment").click(function(){
			paymentLink()			
		})
		
	})
	
	
	
	

	
    $(window).load(function() {
        loadExaminations();

    })
    
    
    function paymentLink()
	{
    	let urlParams = new URLSearchParams();
        urlParams.append("FormType", "PaymentLink")
        urlParams.append("CurrentExaminationDetails",$("#currentExaminationDetails").val())
        fetch("/SecureExamManagementSystem/ExaminationController", {
                method: 'POST',
                body: urlParams
            })
            .then(function(response) {
                return response.text()
            })
            .then(
                function(text) {

					if(text == "400")
					{
						alert("Failed To create payment link")
						window.location.reload;
						
					}else if(text == "998")
					{
						alert("Already Applied. Please check inside aplied exam");
						window.location.reload;
						
					}else
					{
						window.location = text;
					}
             })
    }
	
    

    function loadExaminations() {
        let urlParams = new URLSearchParams();
        urlParams.append("FormType", "GetExaminations")
        fetch("/SecureExamManagementSystem/ExaminationController", {
                method: 'POST',
                body: urlParams
            })
            .then(function(response) {
                return response.json()
            })
            .then(
                function(json) {
                    $("#TableViewExaminations tbody").html("");
                    
                    var tDate = todayDate();
                    
                    $.each(json, function(key, value) {
                    	/* alert("value.eDate "+value.eDate) */
                    	
                    	var todayDate = new Date(tDate)
                    	var endDate = new Date(formatDate( value.eAdmissionLastDate))
                    	
                    	if(endDate >= todayDate)
                    	{
                    	
                        $("#TableViewExaminations tbody")
                            .append(
                                '<tr><td id="eId-' + value.eId + '">' +
                                value.eId +
                                '</td><td id="eName-' + value.eId + '">' +
                                value.eTitle +
                                '</td><td id="eSD-' + value.eId + '">' +
                                value.eAdmissionStartDate +
                                '</td><td id="eED-' + value.eId + '">' +
                                value.eAdmissionLastDate +
                                '</td><td id="eHD-' + value.eId + '">' +
                                value.eHallTicketDate +
                                '</td><td id="eExD-' + value.eId + '">' +
                                value.eDate +
                                '</td><td id="eRD-' + value.eId + '">' +
                                value.eResultDate +
                                '</td><td id="eF-' + value.eId + '">' +
                                value.eFee +
                                '</td><td id=""><button class="btn btn-info" id="eApplyButton" onclick="openData(' +
                                value.eId +
                                ')">Apply</button></td></tr>');
                    		}
                    })

                    $("#TableViewExaminations").DataTable();

                })
    }
    
    
    
    
    function examinationsDetailsTable(pId)
    {
    	let urlParams = new URLSearchParams();
        urlParams.append("FormType", "ExaminationsDetailsTable")
        urlParams.append("ExaminationId",pId)
        fetch("/SecureExamManagementSystem/ExaminationController", {
                method: 'POST',
                body: urlParams
            })
            .then(function(response) {
                return response.text()
            })
            .then(
                function(text) {
                 $("#currExamDetail").html(""+text)
                })
    }

    function openData(pData) {
    	$("#currentExaminationDetails").val(pData);
        //alert(pData)
		examinationsDetailsTable(pData);
        openPopup("#modalApply");
    }
    
   /*  function todayDate(){
    	var td = new Date()
    	return (td.getMonth()+1) +"/"+td.getDate()+"/"+td.getFullYear();
    } */
</script>

</html>