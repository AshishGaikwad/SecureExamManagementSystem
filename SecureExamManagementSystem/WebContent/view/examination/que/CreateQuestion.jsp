<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>
<body>
	<div class="row">
		<div class="col-md-12">
			<!-- <form id="CreateQuestion" action="#" class="form-horizontal"> -->

			<input type="hidden" name="FormType" id="FormType"
				value="CreateQuestion" />
			<section class="panel"> <header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a>
				<!--  <a href="#"
						class="fa fa-times"></a> -->
			</div>

			<h2 class="panel-title">Create Question</h2>
			<!-- <p class="panel-subtitle">Basic validation will display a label
					with the error after the form control.</p> --> </header>
			<div class="panel-body">
				<div class="validation-message">
					<ul></ul>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Subject List <span
						class="required">*</span></label>
					<div class="col-sm-9">
						<select title="Please Select Subject" name="SubjectList"
							id="SubjectList" class="form-control" required>

						</select> <label class="error" for="SubjectList"></label>
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Question <span
						class="required">*</span></label>
					<div class="col-sm-9">
						<input type="text" name="Question" id="Question"
							class="form-control" title="Please enter a Question"
							placeholder="Please enter a Question" required />
					</div>
				</div>
				<div class="form-group">
					<label class="col-sm-3 control-label">Options <span
						class="required">*</span></label>
					<div class="col-sm-9" id="optionDiv">
						<span style="cursor: pointer" id="AddOption"><u>Add
								option +</u></span>
					</div>
					<div class="col-sm-9" id="optionDiv">
						<!-- <input type="text" name="Option" id="Option"
								class="form-control" title="Please enter a Option"
								readonly placeholder="Please enter a Option" required />  -->
					</div>
				</div>

				<div class="form-group">
					<label class="col-sm-3 control-label">Correct Option <span
						class="required">*</span></label>
					<div class="col-sm-9">
						<select title="Please Select Correct Option" name="CorrectOption"
							id="CorrectOption" class="form-control" required>
							<option value="0">0</option>
						</select> <label class="error" for="CorrectOption"></label>
					</div>
				</div>


				<div class="form-group">
					<label class="col-sm-3 control-label">Marks <span
						class="required">*</span></label>
					<div class="col-sm-9">
						<input type="text" name="Marks" id="Marks" class="form-control"
							title="Please enter a Marks"
							placeholder="Please enter a Question" required />
					</div>
				</div>

			</div>
			<footer class="panel-footer">
			<div class="row">
				<div class="col-sm-9 col-sm-offset-3">
					<button class="btn btn-primary" id="CreateQuestion">Submit</button>
					<button type="reset" class="btn btn-default" id="reset">Reset</button>
				</div>
			</div>
			</footer> </section>
			<!-- </form> -->
		</div>
	</div>

</body>
<%@ include file="/view/impl/_vendor.jsp"%>
<%-- <script
	src="<%=request.getContextPath()%>/res/js/impl/role-management.js"></script> --%>

<script type="text/javascript">
$(window).load(function() {
    loadSubjects();
    sessionStorage.setItem("optionsJSON","[]");
    sessionStorage.setItem("optionsLast",0);
    
})

$(document).ready( function() {
	$("#Marks").ForceNumericOnly();
	
	$("#AddOption").click(function(){
		var last = sessionStorage.getItem("optionsLast");
		last++;
		$("#optionDiv").append('<br>'+last+'.  <input type="text" name="Option" id="Option-'+last+'" class="form-control options" title="Please enter a Option" placeholder="Please enter a Option" required />'); 
		sessionStorage.setItem("optionsLast",last);				
		$("#CorrectOption").append('<option value="' +last + '">' + last + '</option>')
	})

	$("#CreateQuestion").click(function(){
		
		if(validate())
		{
			  let urlParams = new URLSearchParams();
			  urlParams.append("FormType", "SaveQuestion") ;
			  urlParams.append("Body",JSON.stringify(values())); 
			
			fetch("/SecureExamManagementSystem/QuestionController",{ method: 'POST',body: urlParams})
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
				 reset();
			})
		}
	})
});

function validate() {
    if (validateSubject() == true && validateQuestion() == true && validateOptions() == true && validateCorrectOption() == true && validateMarks() == true)
        return true;
    return false;
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




function validateSubject()
{
	if($("#SubjectList option:selected").val() == 0 )
	{
		//$(".validation-message").html("");
		alert("Please Select Subject List");
		return false;
	}else {
		$(".validation-message").html("");
		return true;
	}	
}


function validateQuestion()
{
	if($("#Question").val() == "")
	{
		
		alert("Please Select Questions");
		return false;
	}else {
		return true;
	}	
}


function validateOptions()
{
	var last = sessionStorage.getItem("optionsLast");
	if(last <= 3)
	{
		//$(".validation-message").html("");
		alert("Please Add atleast three options");
		return false;
	}else {		
		for(var i = 1; i<=last ; i++)
		{
			if($("#Option-"+i).val() =="")
			{
				//$(".validation-message").html("");
				alert("Please enter text in "+i+ " of option");
				return false;
			}
		}		
		//$(".validation-message").html("");
		return true;
	}	
}

function validateCorrectOption()
{
	if($("#CorrectOption option:selected").val() == 0)
	{
		alert("Please Select Correct option Field");
		return false;
	}else {
		return true;
	}
}

function validateMarks(){
	if($("#Marks").val() == ""){
		alert("Please Enter marks");
		return false;
	}else {
		return true;
	}
}

function optionArray(){
	var last = sessionStorage.getItem("optionsLast");
	var options = [];	
	for(var i = 1; i<=last ; i++)
	{
		options.push({id:i,value:$("#Option-"+i).val()});
	}	
	return options;
}

function values(){	
	return {
		subjectId:$("#SubjectList option:selected").val(),
		question:$("#Question").val(),
		options:optionArray(),
		correctAnswer:$("#CorrectOption option:selected").val(),
		marks:$("#Marks").val()
	}		
}


function reset(){
	$("#SubjectList option:selected").val("0");
	$("#Question").val("");
	$("#optionDiv").html("");
	$("#CorrectOption option:selected").html("<option value=\"0\">0</option>");
	$("#CorrectOption option:selected").val("0");
	$("#Marks").val("");
}
</script>
</html>