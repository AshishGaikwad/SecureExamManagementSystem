<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen"  onload="resizeIframe()">

	<div class="row">
		<div class="col-md-12">
			<div class="panel-group" id="accordion">

				<div class="panel panel-accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#AddNewRole">Add New Role</a>
						</h4>
					</div>
					<div id="AddNewRole" class="accordion-body collapse in">
						<section class="panel"> <header class="panel-heading">
						
						
						</header>
						<div class="panel-body">
							<div class="form-group">
								<label class="col-sm-4 control-label">Role Name </label>
								<div class="col-sm-8">
									<input type="text" name="AddRole" id="AddRole" class="form-control">
								</div>
							</div>
							
						</div>
						<footer class="panel-footer">
						<button class="btn btn-primary btn-block" id="AddRoleBtn">AddRole</button>
						
						</footer> </section>
						

					</div>


					<div class="panel panel-accordion">
						<div class="panel-heading">
							<h4 class="panel-title">
								<a class="accordion-toggle collapsed" data-toggle="collapse"
									data-parent="#accordion" href="#CreateUserAcco">Map Screens
									To Role</a>
							</h4>
						</div>
						<div id="CreateUserAcco" class="accordion-body collapse	">
							<div class="panel-body">
								<div class="col-lg-12">
									<div class="form-group">
										<label class="col-md-3 control-label" for="inputDefault">
											<a class="modal-with-form" data-toggle="modal"
											id="CreateRole" href="#RoleModal">Role Name</a>
										</label>

										<div class="col-md-6">
											<select class="form-control input-sm mb-md" id="RoleName">
												<option value="0">--Select Role--</option>
											</select>
										</div>
									</div>
									<table id="RoleMappingTable"
										class="table table-bordered table-striped mb-none">

									</table>
									<br> <br>
									<div class="form-group">
										<button id="CreateScreenButton"
											class="btn btn-block btn-primary">Create Role Mapping</button>
									</div>

								</div>


							</div>


						</div>
					</div>
				</div>





			</div>
		</div>
	</div>


	<div id="dialog" class="modal-block mfp-hide">
		<section class="panel"> <header class="panel-heading">
		<h2 class="panel-title">Are you sure?</h2>
		</header>
		<div class="panel-body">
			<div class="modal-wrapper">
				<div class="modal-text">
					<p>Are you sure that you want to delete this row?</p>
				</div>
			</div>
		</div>
		<footer class="panel-footer">
		<div class="row">
			<div class="col-md-12 text-right">
				<button id="dialogConfirm" class="btn btn-primary">Confirm</button>
				<button id="dialogCancel" class="btn btn-default">Cancel</button>
			</div>
		</div>
		</footer> </section>
	</div>


</body>
<%@ include file="../impl/_vendor.jsp"%>
<script
	src="<%=request.getContextPath()%>/res/js/impl/role-management.js"></script>
</html>