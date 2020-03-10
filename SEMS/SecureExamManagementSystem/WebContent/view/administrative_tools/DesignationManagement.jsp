<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen" onload="resizeIframe()">

	<div class="row" style="padding: 1%">
		<div class="col-md-12">
			<div class="tabs">
				<ul class="nav nav-tabs">
					<li class="active"><a href="#CreateDesignation"
						data-toggle="tab"><i class="fa fa-star"></i> Create
							Designation</a></li>
					<li><a href="#EditDesignation" data-toggle="tab">Edit
							Designation</a></li>
				</ul>
				<div class="tab-content">
					<div id="CreateDesignation" class="tab-pane active">
						<div class="panel-body">

							<div class="form-group">
								<label class=" control-label">Name </label>
								<div class="">
									<input type="text" name="DesignationName" id="DesignationName"
										class="form-control">
								</div>
							</div>
							<div class="form-group">
								<label class=" control-label">Roles</label>
								<div class="">
									<select multiple data-plugin-selectTwo
										class="form-control populate" id="Roles">

									</select>
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-block" id="SubmitDesignation">Add</button>
							</div>
						</div>
					</div>
					<div id="EditDesignation" class="tab-pane">
						<div class="panel-body">

							<div class="form-group">
								<label class=" control-label">Name </label>
								<div class="">
									<select data-plugin-selectTwo
										class="form-control populate" id="EditDesignationList">

									</select>
								</div>
							</div>
							<div class="form-group">
								<label class=" control-label">Roles</label>
								<div class="">
									<select multiple data-plugin-selectTwo
										class="form-control populate" id="EditRolesList">

									</select>
								</div>
							</div>
							<div class="form-group">
								<button class="btn btn-primary btn-block" id="UpdateDesignation">Update</button>
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
	src="<%=request.getContextPath()%>/res/js/impl/cms/designation.js"></script>
</html>