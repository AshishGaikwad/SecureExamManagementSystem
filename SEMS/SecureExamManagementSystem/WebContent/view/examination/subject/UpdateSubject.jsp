<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="/view/impl/_header.jsp"%>
<body>
	<div class="row">
		<div class="col-sm-6">
			<form id="UpdateSubject" action="#" class="form-horizontal">

				<input type="hidden" name="FormType" id="FormType"
					value="UpdateSubject" />
				<section class="panel"> <header class="panel-heading">
				<div class="panel-actions">
					<a href="#" class="fa fa-caret-down"></a>
					<!--  <a href="#"
						class="fa fa-times"></a> -->
				</div>

				<h2 class="panel-title">Update Subject</h2>
				<!-- <p class="panel-subtitle">Basic validation will display a label
					with the error after the form control.</p> --> </header>
				<div class="panel-body">
					<div class="validation-message">
						<ul></ul>
					</div>


					<div class="form-group">
						<label class="col-sm-3 control-label">Subject Id <span
							class="required">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="SubjectId" id="SubjectId"
								class="form-control" title="Please enter a subject id" readonly
								placeholder="Please enter a subject id" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">Subject Name <span
							class="required">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="SubjectName" id="SubjectName" class="form-control"
								title="Please enter a subject name."
								placeholder="Please enter a subject name." required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Subject Code <span
							class="required">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="SubjectCode" id="SubjectCode"
								class="form-control" title="Please enter a subject code"
								readonly placeholder="Please enter a subject code" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Subject Head</label>
						<div class="col-sm-9">
							<select title="Please Select Subject Head" name="SubjectHead"
							
								id="SubjectHead" class="form-control" required>

							</select> <label class="error" for="SubjectHead"></label>
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Admission Start Date
							<span class="required">*</span>
						</label>
						<div class="col-sm-9">
							<input data-plugin-datepicker data-date-format="dd/mm/yyyy"
								data-plugin-masked-input="" data-input-mask="99/99/9999"
								type="text" name="AdmissionStartDate" id="AdmissionStartDate" class="form-control"
								title="Please enter a admission start date"
								placeholder="dd/mm/yyyy" required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Admission End Date <span
							class="required">*</span>
						</label>
						<div class="col-sm-9">
							<input data-plugin-datepicker data-date-format="dd/mm/yyyy"
								data-plugin-masked-input="" data-input-mask="99/99/9999"
								type="text" name="AdmissionEndDate" id="AdmissionEndDate" class="form-control"
								title="Please enter a admission end date"
								placeholder="dd/mm/yyyy" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">Date of Examination
							<span class="required">*</span>
						</label>
						<div class="col-sm-9">
							<input data-plugin-datepicker data-date-format="dd/mm/yyyy"
								data-plugin-masked-input="" data-input-mask="99/99/9999"
								type="text" name="DateOfExamination" id="DateOfExamination" class="form-control"
								title="Please enter Date of Examination"
								placeholder="dd/mm/yyyy" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">Date of Result <span
							class="required">*</span>
						</label>
						<div class="col-sm-9">
							<input data-plugin-datepicker data-date-format="dd/mm/yyyy"
								data-plugin-masked-input="" data-input-mask="99/99/9999"
								type="text" name="DateOfResult" id="DateOfResult" class="form-control"
								title="Please enter Date of Result" placeholder="dd/mm/yyyy"
								required />
						</div>
					</div>
					<div class="form-group">
						<label class="col-sm-3 control-label">Subject Fee <span
							class="required">*</span></label>
						<div class="col-sm-9">
							<input type="text" name="SubjectFee" id="SubjectFee"
								class="form-control" title="Please enter a subject fee"
								placeholder="Please enter a subject fee" required />
						</div>
					</div>

					<div class="form-group">
						<label class="col-sm-3 control-label">Description <span
							class="required">*</span></label>
						<div class="col-sm-9">
							<textarea name="SubjectDescription" id="SubjectDescription" rows="5"
								title="Please enter subject description" class="form-control"
								placeholder="Please enter subject description" required></textarea>
						</div>
					</div>
				</div>
				<footer class="panel-footer">
				<div class="row">
					<div class="col-sm-9 col-sm-offset-3">
						<button class="btn btn-primary">Update</button>

					</div>
				</div>
				</footer> </section>
			</form>
		</div>
		<div class="col-sm-6">
			<section class="panel"> <header class="panel-heading">
			<div class="panel-actions">
				<a href="#" class="fa fa-caret-down"></a>
				<!--  <a href="#"
						class="fa fa-times"></a> -->
			</div>

			<h2 class="panel-title">Subject List</h2>
			</header>

			<div class="panel-body">

				<table class="table table-bordered table-striped" id="subject-list"
					data-url="/SecureExamManagementSystem/SubjectController?FormType=GetSubject">
					<thead>
						<tr>
							<th>id</th>
							<th>name</th>
							<th>code</th>
							<th>head</th>
							<th>Admission Start Date</th>
							<th>Admission End Date</th>
							<th>Examination Date</th>
							<th>Result Date</th>
							<th>Fee</th>
							<th>Desc</th>
						</tr>
					</thead>
					<tbody id="subject-list-body">
					</tbody>
				</table>

			</div>
			</section>
		</div>
	</div>

</body>
<%@ include file="/view/impl/_vendor.jsp"%>

<script type="text/javascript">
	$(window).load(function() {
		loadSubjectHead();
		loadSubjects()
		/* $("#SubjectCode").val(new Date().toISOString()); */
	})

	$(document)
			.ready(
					function() {

						$("#SubjectFee").ForceNumericOnly();

						var $summaryForm = $("#UpdateSubject");
						$summaryForm.validate({
							errorContainer : $summaryForm
									.find('div.validation-message'),
							errorLabelContainer : $summaryForm
									.find('div.validation-message ul'),
							wrapper : "li"
						});

						$("#UpdateSubject")
								.each(
										function() {
											$(this)
													.validate(
															{
																highlight : function(
																		element) {
																	$(element)
																			.closest(
																					'.form-group')
																			.removeClass(
																					'has-success')
																			.addClass(
																					'has-error');
																},
																success : function(
																		element) {
																	$(element)
																			.closest(
																					'.form-group')
																			.removeClass(
																					'has-error');
																}
															});
										});

						$("#UpdateSubject")
								.submit(
										function(e) {
											e.preventDefault();
											e.stopPropagation();
											e.stopImmediatePropagation();
											let urlParams = new URLSearchParams(
													$("#UpdateSubject")
															.serialize());
											if (validate()) {
												fetch(
														"/SecureExamManagementSystem/SubjectController",
														{
															method : 'POST',
															body : urlParams
														})
														.then(
																function(
																		response) {
																	return response
																			.json()
																})
														.then(
																function(json) {
																	console
																			.log(json);

																	new PNotify(
																			{
																				title : json.title,
																				text : json.text,
																				type : json.type,
																				addclass : 'stack-bottomright',
																				stack : stack_bottomright
																			});

																	if (json.type == "success") {
																		document
																				.getElementById(
																						"UpdateSubject")
																				.reset();
																		/* $("#SubjectCode").val(new Date().toISOString()); */
																	}
																})
											}

											return false;
										})

					});

	function validate() {
		if ($("#UpdateSubject .validation-message").css("display") == "none")
			return true;
		return false;
	}

	function loadSubjectHead() {
		let urlParams = new URLSearchParams();
		urlParams.append("FormType", "FetchSubjectHead")
		fetch("/SecureExamManagementSystem/SubjectController", {
			method : 'POST',
			body : urlParams
		}).then(function(response) {
			return response.json()
		}).then(
				function(json) {

					$("#SubjectHead").html("");
					$("#SubjectHead").append(
							'<option value="">Choose a Subject Head</option>');
					$.each(json, function(key, value) {
						$("#SubjectHead").append(
								'<option value="' + value.UserId + '">'
										+ value.FullName + '</option>');
					})
				})
	}

	function loadSubjects() {
		let urlParams = new URLSearchParams();
		urlParams.append("FormType", "GetSubject")
		fetch("/SecureExamManagementSystem/SubjectController", {
			method : 'POST',
			body : urlParams
		})
				.then(function(response) {
					return response.json()
				})
				.then(
						function(json) {
							$("#subject-list-body").html("");
							$
									.each(
											json,
											function(key, value) {
												$("#subject-list-body")
														.append(
																'<tr id="'+value.id+'"><td class="id">'
																		+ value.id
																		+ '</td><td class="name">'
																		+ value.name
																		+ '</td><td class="code">'
																		+ value.code
																		+ '</td><td class="head">'
																		+ value.head
																		+ '</td><td class="admissionStartDate">'
																		+ value.admissionStartDate
																		+ '</td><td class="admissionEndDate">'
																		+ value.admissionEndDate
																		+ '</td><td class="examinationDate">'
																		+ value.examinationDate
																		+ '</td><td class="resultDate">'
																		+ value.resultDate
																		+ '</td><td class="fee">'
																		+ value.fee
																		+ '</td><td class="desc">'
																		+ value.desc
																		+ '</td></tr>');
											})

							$("#subject-list").DataTable();

							$("#subject-list-body tr").click(function() {
								
								
								$("#SubjectId").val($(this).find('.id').html());
								$("#SubjectName").val($(this).find('.name').html());
								$("#SubjectCode").val($(this).find('.code').html());
								$("#SubjectHead").val($(this).find('.head').html());
								$("#AdmissionStartDate").val($(this).find('.admissionStartDate').html());
								$("#AdmissionEndDate").val($(this).find('.admissionEndDate').html());
								$("#DateOfExamination").val($(this).find('.examinationDate').html());
								$("#DateOfResult").val($(this).find('.resultDate').html());
								$("#SubjectFee").val($(this).find('.fee').html());
								$("#SubjectDescription").val($(this).find('.desc').html());
							});
						})
	}
</script>
</html>