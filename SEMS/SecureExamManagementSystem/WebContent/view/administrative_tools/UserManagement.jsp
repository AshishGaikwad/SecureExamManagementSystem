<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen">
	<div id="modalForm" class="	modal-lg  mfp-hide" style="
    width: 100% !important;
">
		<section class="panel"> <header class="panel-heading">
		<h2 class="panel-title">Users</h2>
		</header>
		<div class="panel-body">
			<div class="table-responsive" style="height: 200px; overflow: auto;">
				<table id="AllUserTable" class="table table-hover mb-none">
					<thead>
						<tr>
							<th>#</th>
							<th>Full Name</th>
							<th>Email</th>
							<th>Mobile</th>
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
		</footer> </section>
	</div>

	<div class="row">
		<div class="col-md-12">
			<div class="panel-group" id="accordion">
				<div class="panel panel-accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#CreateUserAcco">Create User</a>
						</h4>
					</div>
					<div id="CreateUserAcco" class="accordion-body collapse in">
						<div class="panel-body">
							<div class="col-sm-6">
							
							<input type="hidden" class="form-control" id="UserId" val="">
							
								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Full
										Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="FullName">
									</div>

									<label class="col-md-3 control-label error" id="FullNameErr"
										for="inputDefault"></label>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Email
										Id</label>
									<div class="col-md-6">
										<input type="email" class="form-control" id="EmailId">
									</div>
									<label class="col-md-3 control-label error" id="EmailIdErr"
										for="inputDefault"></label>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Date
										Of Birth</label>
									<div class="col-md-6">
										<input type="text" data-plugin-datepicker  data-plugin-datepicker data-date-format="dd/mm/yyyy" 
										data-input-mask="99/99/9999" placeholder="dd/mm/yyyy"
										class="form-control"
											id="DateOfBirth">
									</div>
									<label class="col-md-3 control-label error" id="DateOfBirthErr"
										for="inputDefault"></label>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Mobile
										No</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="MobileNo">
									</div>
									<label class="col-md-3 control-label error" id="MobileNoErr"
										for="inputDefault"></label>
								</div>


								<div class="form-group">
									<button id="ButtonCreateUser" class="btn  btn-primary">Create
										User</button>
									<a id="ButtonEditUser" class="btn  btn-primary modal-with-form"
										href="#modalForm">Edit User</a>

								</div>
							</div>

							<div class="col-sm-6">


								<div class="form-group">


									<label class="col-md-3 control-label" for="inputDefault">Status</label>
									<div class="col-md-6">
										<select  id="Status"
											class="form-control populate">
										</select>
									</div>
									<label class="col-md-3 control-label error" id="StatusErr"
										for="inputDefault"></label>

								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Password</label>
									<div class="col-md-6">
										<input type="password" class="form-control" id="Password">
									</div>
									<label class="col-md-3 control-label error" id="PasswordErr"
										for="inputDefault"></label>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Confirm
										Password</label>
									<div class="col-md-6">
										<input type="password" class="form-control" id="ConfirmPassword">
									</div>
									<label class="col-md-3 control-label error"
										id="ConfirmPasswordErr" for="inputDefault"></label>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Roles</label>
									<div class="col-md-6">
										<select multiple data-plugin-selectTwo
											class="form-control populate" id="Roles">

										</select>
									</div>

									<label class="col-md-3 control-label error" id="RolesErr"
										for="inputDefault"></label>
								</div>

								<div class="form-group">
									<button id="UserSubmitButton" class="btn btn-block btn-primary">Submit</button>
								</div>

							</div>


						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="../impl/_vendor.jsp"%>
<script
	src="<%=request.getContextPath()%>/res/js/impl/user-management.js"></script>
</html>