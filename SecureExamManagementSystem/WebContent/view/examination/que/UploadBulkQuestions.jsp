<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>
<body>
	<div class="row">
		<div class="col-md-12">
			
			<form method="POST" enctype="multipart/form-data" action="/SecureExamManagementSystem/QuestionController" id="bulkUploadQuestions">
			<input type="hidden" name="FormType" id="FormType"
				value="UploadBulkQuestion" />
			<section class="panel"> <header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a>
				<!--  <a href="#"
						class="fa fa-times"></a> -->
			</div>

			<h2 class="panel-title">Updload Bulk Question</h2>
			<p class="panel-subtitle">Document Should be in .CSV Format</p>  </header>
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
					<label class="col-sm-3 control-label">Quetions CSV File <span
						class="required">*</span></label>
					<div class="col-sm-9">
						<input type="file" class="form-control" id="bulkCSV" value="file" name="file" accept=".xlsx">
						 <label class="error" for=""></label>
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
			</form>
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

	
	
	$("#bulkUploadQuestions").submit(function(){
		
		if(validate())
		{
			alert("Submitting");
		}else
		{
			return false;
		}
		
	})
});

function validate() {
    if (validateSubject() && validateFile())
        return true;
    return false;
}

function loadSubjects() {
    let urlParams = new URLSearchParams();
    urlParams.append("FormType", "GetSubject")
    
    fetch("/SecureExamManagementSystem/SubjectController	", {
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


function validateFile()
{
	if($("#bulkCSV").val() == 0)
	{
		alert("Please Select CSV File");
		return false;
	}
	return true;
}

</script>
</html>