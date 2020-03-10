<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>

<body id="create_screen" style="background-color: white"
	onload="openFullscreen()">
	<div class="container">
		<div id="StartExamination" class="row">
			<div class="col-sm-4"></div>
			<div class="col-sm-4">
				<h3>
					<u>Please Read Instruction Carefully</u>
				</h3>
				<ul>
					<li>After examination start don't click outside this TAB</li>
					<li>If you click outside Exam will terminated</li>
					<li>If you exit fullscreen exam will get terminated</li>
					<li>Please maximize screen if its already not maximized</li>
				</ul>
				<br>
				<form action="/SecureExamManagementSystem/ExaminationController" method="POST">
				<div class="form-group">'
				
					<label class="col-md-3 control-label" for="inputDefault">Examination Pin</label>
					<div class="col-md-9">
						<input type="text" class="form-control" placeholder="Please enter examination pin" id="epin" name="epin" value="">
						<input type="hidden" class="form-control" placeholder="Please enter examination pin" id="eid" name="eid" value="${EID}">
						<input type="hidden" class="form-control" placeholder="" id="FormType" name="FormType" value="StartExaminationPin">
					</div>

					
				</div>
				<label class="col-md-3 control-label error" id="FullNameErr"
						for="inputDefault">${Error}</label>
				<button class="btn btn-block btn-warning">I Read All
					Instruction Start Exam</button>
				<br> <br> <br> <br> <br> <br> <br>
				<br> <br> <br>
				
				</form>
			</div>
			<div class="col-sm-4"></div>
		</div>
	</div>
</body>

<%@ include file="/view/impl/_vendor.jsp"%>
<script>
	/* document.addEventListener("visibilitychange", function() {
	 alert("Hiee");  
	 console.log(document.hidden, document.visibilityState);
	 return false;
	 }, false); */

/* 	window.onblur = function() {
		console.log('lost focus');
		 alert("Lost focus") 
	}

	window.onfocus = function() {
		console.log('Got focus');
	} */
</script>



</html>