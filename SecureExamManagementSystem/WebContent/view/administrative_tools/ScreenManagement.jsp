<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen">

	<div class="row">
		<div class="col-md-12">
			<div class="panel-group" id="accordion">
				<div class="panel panel-accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a class="accordion-toggle" data-toggle="collapse"
								data-parent="#accordion" href="#CreateUserAcco">Create Screen</a>
						</h4>
					</div>
					<div id="CreateUserAcco" class="accordion-body collapse in">
						<div class="panel-body">
							<div class="col-lg-12">
								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Screen
										Name</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="ScreenName">
									</div>
								</div>
								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Screen
										Parent</label>
									<div class="col-md-6">
										<select class="form-control input-sm mb-md" id="ScreenParent">
											<option value="0">No Parent</option>
										</select>
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Screen
										URL</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="ScreenURL">
									</div>
								</div>

								<div class="form-group">
									<label class="col-md-3 control-label" for="inputDefault">Screen
										Icon</label>
									<div class="col-md-6">
										<input type="text" class="form-control" id="ScreenIcon">
									</div>
								</div>
								<div class="form-group">
									<button id="CreateScreenButton" class="btn btn-block btn-primary">Create Screen</button>
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
<script src="<%=request.getContextPath()%>/res/js/impl/screen-management.js"></script>
</html>