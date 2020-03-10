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
                            <a class="accordion-toggle" data-toggle="collapse" data-parent="#accordion" href="#CreateExaminationAcco">Create
                                Examination</a>
                        </h4>
                    </div>
                    <div id="CreateExaminationAcco" class="accordion-body collapse in">
                        <div class="panel-body">

                            <div class="row">
                            
                            <input type="hidden" value="" id="ExaminationId" class="ExaminationId" name="ExaminationId">
                                <div class="col-sm-4"></div>
                                <div class="col-sm-4 form-group">
                                    <button id="ButtonCreateExamination" class="btn  btn-primary">Create
                                    </button>
                                    <a id="ButtonEditExamination" class="btn  btn-primary modal-with-form" href="#modalForm">Edit
                                    </a>
                                    <button id="ButtonClearExamination" class="btn  btn-primary">Clear
                                    </button>


                                </div>
                                <div class="col-sm-4"></div>
                            </div>

                            <section id="ExaminationDiv" style="display:none">
                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Examination Title <span class="required">*</span></label>
                                        <div class="col-sm-9">
                                            <input type="text" name="ExaminationTitle" id="ExaminationTitle" class="form-control" title="Please enter a Examination Title" placeholder="Please enter a Examination Title" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Subject List <span class="required">*</san></label>
                                        <div class="col-sm-9">
                                            <select title="Please Select Subject" name="SubjectList" id="SubjectList" class="form-control" required>

                                            </select> <label class="error" for="SubjectList"></label>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label class="col-sm-2 control-label">Question Paper<span class="required">*</span></label>
                                        <div class="col-sm-9">
                                            <table class="table table-hover table-bordered mb-none" id="SubjectQuestionDetailsTable">
                                                <thead>
                                                    <tr align="right">
                                                        <th>Sr.No</th>
                                                        <th>Marks</th>
                                                        <th>No of Qustion</th>
                                                        <th>Total Question</th>
                                                        <th>No of Qustion * Marks</th>
                                                    </tr>
                                                </thead>
                                                <tbody>

                                                </tbody>
                                                <tfoot>
                                                    <tr align=right>
                                                        <tD colspan=2>Total Questions</tD>
                                                        <tD id="TotalQuestions">0</tD>
                                                        <tD>Total Marks</tD>
                                                        <tD id="TotalMarks">0</tD>
                                                    </tr>
                                                </tfoot>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Passing Marks<span class="required">*</span></label>
                                        <div class="col-sm-9">
                                            <input type="text" name="PassingMarks" id="PassingMarks" class="form-control numeric" title="Please enter a Passing Marks" placeholder="Please enter a Passing Marks" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Exam Duration <span class="required">*</san></label>
                                        <div class="col-sm-9">
                                            <input type="text" name="ExamDuration" id="ExamDuration" class="form-control numeric" title="Please enter a Exam Duration in Minutes" placeholder="Please enter a Exam Duration in Minutes" required />
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-12 form-group">
                                        <label class="col-sm-2 control-label">Description</label>
                                        <div class="col-sm-10">
                                            <div class="Description" id="Description" data-plugin-summernote data-plugin-options='{ "height": 180, "codemirror": { "theme": "ambiance" } }'></div>
                                        </div>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Admission Start
                                            Date <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-9">
                                            <input data-plugin-datepicker data-date-format="dd/mm/yyyy" data-plugin-masked-input="" data-input-mask="99/99/9999" type="text" name="AdmissionStartDate" id="AdmissionStartDate" class="form-control" title="Please enter a admission start date" placeholder="dd/mm/yyyy" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Admission End
                                            Date <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-9">
                                            <input data-plugin-datepicker data-date-format="dd/mm/yyyy" data-plugin-masked-input="" data-input-mask="99/99/9999" type="text" name="AdmissionEndDate" id="AdmissionEndDate" class="form-control" title="Please enter a admission end date" placeholder="dd/mm/yyyy" required />
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Hall Ticket
                                            Date <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-9">
                                            <input data-plugin-datepicker data-date-format="dd/mm/yyyy" data-plugin-masked-input="" data-input-mask="99/99/9999" type="text" name="HallTicketDate" class="form-control" title="Please enter a admission start date" id="HallTicketDate" placeholder="dd/mm/yyyy" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Examination Date<span class="required">*</span>
                                        </label>
                                        <div class="col-sm-9">
                                            <input data-plugin-datepicker data-date-format="dd/mm/yyyy" data-plugin-masked-input="" data-input-mask="99/99/9999" type="text" name="ExaminationDate" class="form-control" id="ExaminationDate" title="Please enter a admission end date" placeholder="dd/mm/yyyy" required />
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Result
                                            Date <span class="required">*</span>
                                        </label>
                                        <div class="col-sm-9">
                                            <input data-plugin-datepicker data-date-format="dd/mm/yyyy" data-plugin-masked-input="" data-input-mask="99/99/9999" type="text" name="ResultDate" class="form-control" title="Please enter a admission start date" id="ResultDate" placeholder="dd/mm/yyyy" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">

                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">Examination Fee<span class="required">*</span></label>
                                        <div class="col-sm-9">
                                            <input type="text" name="ExaminationFee" id="ExaminationFee" class="form-control" title="Please enter a Passing Marks" placeholder="Please enter a Passing Marks" required />
                                        </div>
                                    </div>
                                    <div class="col-sm-6 form-group">
                                        <label class="col-sm-3 control-label">View Form <span class="required">*</san></label>
                                        <div class="col-sm-9">
                                            <select title="Please Select Exam Duration " name="IsActive" id="IsActive" class="form-control" required>
                                                <option value="1">ACTIVE</option>
                                                <option value="0">INACTIVE</option>
                                            </select>
                                        </div>
                                    </div>
                                </div>


                                <div class="row">
                                    <div class="col-sm-3"></div>
                                    <div class="col-sm-6 form-group">

                                        <div class="form-group">
                                            <button id="ExaminationSubmitButton" class="btn btn-block btn-primary">Submit</button>
                                        </div>

                                    </div>
                                    <div class="col-sm-3"></div>
                                </div>
                            </section>


                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>


    <div id="modalForm" class="	modal-lg  mfp-hide" style="width: 100% !important;">
        <section class="panel">
            <header class="panel-heading">
                <h2 class="panel-title">Examinations</h2>
                <div class=" form-group">
                    <label class="col-sm-3 control-label">Subject List <span class="required">*</san></label>
                    <div class="col-sm-9">
                        <select title="Please Select Subject" name="SubjectListModal" id="SubjectListModal" class="form-control" required>

                        </select> <label class="error" for="SubjectList"></label>
                    </div>
                </div>
            </header>
            <div class="panel-body">
                <div class="table-responsive" style="height: 200px; overflow: auto;">
                    <table id="AllExaminationTableModal" class="table table-hover mb-none">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Title</th>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>
            <footer class="panel-footer">
                <div class="row">
                    <div class="col-md-12 text-right">
                        <button class="btn btn-default modal-dismiss">Cancel</button>
                    </div>
                </div>
            </footer>
        </section>
    </div>
</body>
<%@ include file="/view/impl/_vendor.jsp"%>
<script>
    var ActionState = 0;
    $(".noq").ForceNumericOnly()

    $(window).load(function() {
        loadSubjects();
        $("#ExaminationDiv").hide();
    })

    $(document).ready(function() {



        $("#ButtonCreateExamination").on('click', function() {
            $("#ExaminationDiv").show();

            if (ActionState == 2)
            	window.location.reload();
            
            $("#ExaminationSubmitButton").html("Create Examination");
            ActionState = 1;
        })

        $("#ButtonEditExamination").on('click', function() {
            $("#ExaminationDiv").hide();

            $("#ExaminationSubmitButton").html("Edit Examination");
            loadSubjectsModal()
            ActionState = 2;
        })

        $("#ButtonClearExamination").on('click', function() {
            window.location.reload();
        })

        $(".numeric").ForceNumericOnly();

        subjectEvent();

    })



    function subjectEvent() {



    	$("#ExaminationSubmitButton").click(function() {
        if (ActionState == 1) {
            examinationSubmitCreate()
        } else if (ActionState == 2) {
			
            examinationSubmitUpdate();
        }
    	});


        subjectListChange();
        subjectListModalChange();


        /* 		$("#ExaminationTitle").focusout(function(){
        			validateExamTitle();	
        			
        		});
        		
        		$("#SubjectList").change(function(){
        			validateSubjectList();	
        			
        		});
        		
        		$("#PassingMarks").focusout(function(){
        			validatePassingMarks();	
        			
        		});
        		
        		$("#ExamDuration").focusout(function(){
        			validateExamDuration();	
        			
        		});  		$("#Description").focusout(function(){
        			validateDescription();	
        			
        		});
        		
        		
        		$("#AdmissionStartDate").focusout(function(){
        			validateAdmissionStartDate();	
        			
        		});
        		
        		$("#AdmissionEndDate").focusout(function(){
        			validateAdmissionEndDate();	
        			
        		});
        		
        		$("#HallTicketDate").focusout(function(){
        			validateHallTicketDate();	
        			
        		});
        		
        		$("#ExaminationDate").focusout(function(){
        			validateExaminationDate();	
        			
        		});
        		
        		$("#ResultDate").focusout(function(){
        			validateResultDate();	
        			
        		});
        		
        		$("#ExaminationFee").focusout(function(){
        			validateExaminationFee();	
        			
        		});
         */




    }




    function loadSubjects() {
        let urlParams = new URLSearchParams();
        urlParams.append("FormType", "GetSubject")
        fetch("/SecureExamManagementSystem/SubjectController", {
            method: 'POST',
            body: urlParams
        }).then(function(response) {
            return response.json()
        }).then(
            function(json) {
                $("#SubjectList").html("");
                $("#SubjectList").append(
                    '<option value="0">Choose a Subject</option>');
                $.each(json, function(key, value) {
                    $("#SubjectList").append(
                        '<option value="' + value.id + '">' +
                        value.name + '</option>');
                })
            })
    }



    function loadSubjectsModal() {
        let urlParams = new URLSearchParams();
        urlParams.append("FormType", "GetSubject")
        fetch("/SecureExamManagementSystem/SubjectController", {
            method: 'POST',
            body: urlParams
        }).then(function(response) {
            return response.json()
        }).then(
            function(json) {
                $("#SubjectListModal").html("");
                $("#SubjectListModal").append(
                    '<option value="0">Choose a Subject</option>');
                $.each(json, function(key, value) {
                    $("#SubjectListModal").append(
                        '<option value="' + value.id + '">' +
                        value.name + '</option>');
                })
            })
    }

    function fetchSubjectQuestionDetailsParams(pId) {
        let urlParams = new URLSearchParams();
        urlParams.append("FormType", "FetchSubjectQuestionDetails");
        urlParams.append("SubjectId", pId);
        return {
            method: 'POST',
            body: urlParams
        };
    }

    function fetchSubjectQuestionDetails(pId) {

        fetch("/SecureExamManagementSystem/QuestionController",
            fetchSubjectQuestionDetailsParams(pId)).then(
            function(response) {
                return response.json()
            }).then(function(json) {
            alert(json)
        })
    }




    function validateExamTitle() {

        if ($("#ExaminationTitle").val() == "") {
            alert("Please enter valid examination title");
            return false;
        } else
            return true;

    }

    function validateSubjectList() {
        if ($("#SubjectList option:selected").val() == "0") {
            alert("Please enter valid subject id");
            return false;
        } else
            return true;
    }

    function validateTotalQuestions() {
        if ($("#TotalQuestions").text() == "0") {
            alert("Please fill queestion paper first. and add valid details");
            return false;
        } else
            return true;
    }


    function validateTotalMarks() {
        if ($("#TotalMarks").text() == "0") {
            alert("Please fill queestion paper first. and add valid details");
            return false;
        } else
            return true;
    }



    function validatePassingMarks() {

        alert($("#TotalMarks").text())
        if (validateTotalMarks()) {
            if ($("#PassingMarks").val() == "") {
                alert("Passing marks should not be empty");
                return false;
            } else if (Number($("#PassingMarks").val()) > Number($("#TotalMarks").text())) {
                alert("Passing marks should not be greater than total marks");
                $("#PassingMarks").val("0");
                return false;
            } else
                return true;
        }
    }


    function validateExamDuration() {
        if ($("#ExamDuration").val() == "") {
            alert("Please enter exam duration");
            return false;
        } else
            return true;
    }


    function validateDescription() {
        if ($("#Description").code() == "<p><br></p>") {
            alert("Please enter valid description");
            return false;
        } else
            return true;
    }




    function validateAdmissionStartDate() {
        if ($("#AdmissionStartDate").val() == "") {
            alert("Please enter Admission Start Date");
            return false;
        } else
            return true;
    }




    function validateAdmissionEndDate() {
        if ($("#AdmissionEndDate").val() == "") {
            alert("Please enter Admission End Date");
            return false;
        } else if (!isDateGreater($("#AdmissionStartDate").val(), $("#AdmissionEndDate").val())) {
            alert("End Date sould be greater than start date");
            $("#AdmissionEndDate").val("")
            return false;
        } else
            return true;
    }


    function validateHallTicketDate() {
        if ($("#HallTicketDate").val() == "") {
            alert("Please enter Hall Ticket Date");
            return false;
        } else if (!isDateGreater($("#AdmissionEndDate").val(), $("#HallTicketDate").val())) {
            alert("Hall Ticket Date sould be greater than Admission End date");
            $("#HallTicketDate").val("")
            return false;
        } else
            return true;
    }




    function validateExaminationDate() {
        if ($("#ExaminationDate").val() == "") {
            alert("Please enter Examination Date");
            return false;
        } else if (!isDateGreater($("#HallTicketDate").val(), $("#ExaminationDate").val())) {
            alert("Examination Date sould be greater than Hall ticket date");
            $("#ExaminationDate").val("")
            return false;
        } else
            return true;
    }


    function validateResultDate() {
        if ($("#ResultDate").val() == "") {
            alert("Please enter Result Date");
            return false;
        } else if (!isDateGreater($("#ExaminationDate").val(), $("#ResultDate").val())) {
            alert("Result Date sould be greater than Examination date");
            $("#ResultDate").val("")
            return false;
        } else
            return true;
    }

    function validateExaminationFee() {
        if ($("#ExaminationFee").val() == "") {
            alert("Please enter Examination fee");
            return false;
        } else
            return true;
    }


    function validate() {
        if (validateExamTitle() == true && validateSubjectList() == true &&
            validateTotalQuestions() == true &&
            validateTotalMarks() == true &&
            validatePassingMarks() == true &&
            validateExamDuration() == true &&
            validateDescription() == true &&
            validateAdmissionStartDate() == true &&
            validateAdmissionEndDate() == true &&
            validateHallTicketDate() == true &&
            validateExaminationDate() == true &&
            validateResultDate() == true && validateExaminationFee())
            return true;
        else
            return false;

    }


    function values() {
        return {

            SubjectList: $("#SubjectList option:selected").val(),
            TotalQuestions: $("#TotalQuestions").text(),
            MarkQueDetails: buildMarkQueDetails(),
            TotalMarks: $("#TotalMarks").text(),
            PassingMarks: $("#PassingMarks").val(),
            ExamDuration: $("#ExamDuration").val(),
            Description: $("#Description").code(),
            AdmissionStartDate: $("#AdmissionStartDate").val(),
            AdmissionEndDate: $("#AdmissionEndDate").val(),
            HallTicketDate: $("#HallTicketDate").val(),
            ExaminationDate: $("#ExaminationDate").val(),
            ResultDate: $("#ResultDate").val(),
            ExaminationFee: $("#ExaminationFee").val(),
            IsActive: $("#IsActive option:selected").val(),
            eTitle: $("#ExaminationTitle").val()
        }
    }


    function buildMarkQueDetails() {
        var qmDet = "";
        var mData = sessionStorage.getItem("SubjectQuestionMarks").split(",");

        for (var i = 1; i < mData.length; i++) {
            if (i == 1)
                qmDet = qmDet + "" + mData[i] + "=" + $("#noq-" + mData[i]).val();
            else
                qmDet = qmDet + "," + mData[i] + "=" + $("#noq-" + mData[i]).val();
        }

        return qmDet;

    }


    function examinationSubmitCreate() {
        //$("#ExaminationSubmitButton").click(function() {

            if (validate()) {
                let urlParams = new URLSearchParams();
                urlParams.append("FormType", "SaveExamination");
                urlParams.append("Body", JSON.stringify(values()));

                fetch("/SecureExamManagementSystem/ExaminationController", {
                        method: 'POST',
                        body: urlParams
                    })
                    .then(function(response) {
                        return response.json();
                    })
                    .then(function(json) {


                        new PNotify({
                            title: json.title,
                            text: json.text,
                            type: json.type,
                            addclass: 'stack-bottomright',
                            stack: stack_bottomright
                        });



                        if (json.type = "success")
                            $("#ExaminationDiv").hide();
                    })
            }
       // });
    }



    function examinationSubmitUpdate() {
        //$("#ExaminationSubmitButton").click(function() {

            if (validate()) {
                let urlParams = new URLSearchParams();
                urlParams.append("FormType", "UpdateExamination");
                urlParams.append("Body", JSON.stringify(values()));
                urlParams.append("ExaminationId", $("#ExaminationId").val());

                fetch("/SecureExamManagementSystem/ExaminationController", {
                        method: 'POST',
                        body: urlParams
                    })
                    .then(function(response) {
                        return response.json();
                    })
                    .then(function(json) {


                        new PNotify({
                            title: json.title,
                            text: json.text,
                            type: json.type,
                            addclass: 'stack-bottomright',
                            stack: stack_bottomright
                        });



                        if (json.type = "success")
                            $("#ExaminationDiv").hide();
                    })
            }
        //});
    }

    function subjectListChange() {
        $("#SubjectList").change(function() {
        	subjectListdata($(this).val())
        });


    }

    
    function subjectListdata(pData){
    	

        fetch("/SecureExamManagementSystem/QuestionController",
                fetchSubjectQuestionDetailsParams(pData))
            .then(function(response) {
                return response.json()
            })
            .then(function(json) {
                $("#SubjectQuestionDetailsTable tbody").html("");
                var count = 1;

                var marksArrays = "";
                $.each(json, function(key, value) {
                    var d = '<tr align="center" class="currRow" id="qm-' + value.questions_marks + '"><tD class="srno" id="srno-' + count + '">' + count + '</tD><tD class="marks" id="marks-' + value.questions_marks + '">' + value.questions_marks + '</tD><tD class="noqi" id="noqi-' + value.questions_marks + '"><input type="text"class="noq" dataattr="' + value.questions_marks + '" id="noq-' + value.questions_marks + '" value="0" /></tD><tD class="tq" id="tq-' + value.questions_marks + '">' + value.count + '</tD><tD class="multinq" id="multinq-' + value.questions_marks + '">0</tD></tr>';
                    $("#SubjectQuestionDetailsTable tbody").append(d);
                    marksArrays = marksArrays + "," + value.questions_marks;
                    count++;
                })
                sessionStorage.setItem("SubjectQuestionMarks", marksArrays);
                $(".noq").ForceNumericOnly()
                $(".noq").focusout(function() {


                    var currMarkNo = $(this).attr('dataattr');
                    var markId = "#marks-" + currMarkNo;
                    var noqiId = "#noqi-" + currMarkNo;
                    var noqId = "#noq-" + currMarkNo;
                    var tqId = "#tq-" + currMarkNo;
                    var multinqId = "#multinq-" + currMarkNo;

                    if (Number($(noqId).val()) > Number($(tqId).text())) {
                        alert("No of questions should not be greater than total questions");
                        $(this).val("0");

                    }

                    var a = Number($(noqId).val());
                    var b = Number($(markId).text());
                    var sum = a * b;
                    $(multinqId).html("" + sum);

                    var mData = sessionStorage.getItem("SubjectQuestionMarks").split(",");


                    var tNo = 0;
                    var tNoM = 0;
                    for (var i = 1; i < mData.length; i++) {

                        tNo = tNo + Number($("#noq-" + mData[i]).val());
                        tNoM = tNoM + Number($("#multinq-" + mData[i]).html());
                    }
                    $("#TotalQuestions").text(tNo);
                    $("#TotalMarks").text(tNoM);

                });



            });
    }


    function subjectListModalChange() {
        $("#SubjectListModal").change(function() {
        	
        	
        	getExaminationListBySubject();
        	
        });


    }

	function getExaminationListBySubject(){
		let urlParams = new URLSearchParams();
        urlParams.append("FormType", "GetExaminationListBySubject");
        urlParams.append("SubjectId",$("#SubjectListModal option:selected").val() );

    	
    	fetch("/SecureExamManagementSystem/ExaminationController",{
    		 method: 'POST',
             body: urlParams
    	})
    	.then(function(response){
    		return response.json();
    	}).then(function(json){
  
    		$("#AllExaminationTableModal tbody").html("");
    		$.each(json, function(key, value){
    			
    			$("#AllExaminationTableModal tbody").append('<tr class="modal-row" id="'+value.eId+'" ondblclick="userModalClicked(`'+value.eId+'`)"><td>'+value.eId+'</td><td>'+value.eTitle+'</td></tr>');
    			
    		});
    	});
	}
	
	
	function userModalClicked(pId)
	{
		getExaminationData(pId)
	}
	
	
	
	function getExaminationData(pId)
	{
		let urlParams = new URLSearchParams();
        urlParams.append("FormType", "GetExaminationData");
        urlParams.append("ExaminationId",pId);

    	
    	fetch("/SecureExamManagementSystem/ExaminationController",{
    		 method: 'POST',
             body: urlParams
    	})
    	.then(function(response){
    		return response.json();
    	}).then(function(json){
  
    		
    		console.log(json);
    		  		
    		subjectListdataModal(json.eSubjectId, json.eMarkQueDetails)
    		
			
    		
    		
    		
    		
    		$("#ExaminationId").val(json.eId);
    		$("#ExaminationTitle").val(json.eTitle);
    		$("#SubjectList").val(json.eSubjectId);
    		$("#TotalQuestions").text(json.eTotalQue);
    		$("#TotalMarks").text(json.eTotalMarks);
    		$("#PassingMarks").val(json.ePassingMarks);
    		$("#ExamDuration").val(json.eDuration);
    		$("#Description").code(json.eDescription);
    		$("#AdmissionStartDate").val(json.eAdmissionStartDate);
    		$("#AdmissionEndDate").val(json.eAdmissionLastDate);
    		$("#HallTicketDate").val(json.eHallTicketDate);
    		$("#ExaminationDate").val(json.eDate);
    		$("#ResultDate").val(json.eResultDate);
    		$("#ExaminationFee").val(json.eFee);
    		$("#IsActive").val(json.eIsActive);
    		
    		
    		
    		$("#ExaminationDiv").show();
    		
    		
    		$.magnificPopup.close();
    		
    		
    	})
		
		
	}
	
	
function subjectListdataModal(pData,pMarkDetails){
    	

        fetch("/SecureExamManagementSystem/QuestionController",
                fetchSubjectQuestionDetailsParams(pData))
            .then(function(response) {
                return response.json()
            })
            .then(function(json) {
                $("#SubjectQuestionDetailsTable tbody").html("");
                var count = 1;

                var marksArrays = "";
                $.each(json, function(key, value) {
                    var d = '<tr align="center" class="currRow" id="qm-' + value.questions_marks + '"><tD class="srno" id="srno-' + count + '">' + count + '</tD><tD class="marks" id="marks-' + value.questions_marks + '">' + value.questions_marks + '</tD><tD class="noqi" id="noqi-' + value.questions_marks + '"><input type="text"class="noq" dataattr="' + value.questions_marks + '" id="noq-' + value.questions_marks + '" value="0" /></tD><tD class="tq" id="tq-' + value.questions_marks + '">' + value.count + '</tD><tD class="multinq" id="multinq-' + value.questions_marks + '">0</tD></tr>';
                    $("#SubjectQuestionDetailsTable tbody").append(d);
                    marksArrays = marksArrays + "," + value.questions_marks;
                    count++;
                })
                sessionStorage.setItem("SubjectQuestionMarks", marksArrays);
                
                var qmd = pMarkDetails.split(",");
        		
        		
        		for(var i = 0; i<qmd.length; i++){
        			var tmpQMD = qmd[i].split("=")
        			
        			
        			$("#noq-"+tmpQMD[0]).val(tmpQMD[1]);
        			
        			
        		}
                
                
                
                $(".noq").ForceNumericOnly()
                $(".noq").focusout(function() {


                    var currMarkNo = $(this).attr('dataattr');
                    var markId = "#marks-" + currMarkNo;
                    var noqiId = "#noqi-" + currMarkNo;
                    var noqId = "#noq-" + currMarkNo;
                    var tqId = "#tq-" + currMarkNo;
                    var multinqId = "#multinq-" + currMarkNo;

                    if (Number($(noqId).val()) > Number($(tqId).text())) {
                        alert("No of questions should not be greater than total questions");
                        $(this).val("0");

                    }

                    var a = Number($(noqId).val());
                    var b = Number($(markId).text());
                    var sum = a * b;
                    $(multinqId).html("" + sum);

                    var mData = sessionStorage.getItem("SubjectQuestionMarks").split(",");


                    var tNo = 0;
                    var tNoM = 0;
                    for (var i = 1; i < mData.length; i++) {

                        tNo = tNo + Number($("#noq-" + mData[i]).val());
                        tNoM = tNoM + Number($("#multinq-" + mData[i]).html());
                    }
                    $("#TotalQuestions").text(tNo);
                    $("#TotalMarks").text(tNoM);

                    
                    
                    
                   
            		
            		

                });



            });
    }
</script>

</html>