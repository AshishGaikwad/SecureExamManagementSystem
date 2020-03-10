<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../impl/_header.jsp"%>
<body id="create_screen">
	<div class="col-lg-12">
		<div class="form-group">
			<label class="col-md-3 control-label" for="inputDefault">Screen Name</label>
			<div class="col-md-6">
				<input type="text" class="form-control"  id="ScreenName">
			</div>
		</div>
	</div>
	<div class="col-lg-12">
		<div class="form-group">
			<label class="col-md-3 control-label" for="inputDefault">Screen Parent</label>
			<div class="col-md-6">
				<select class="form-control input-sm mb-md" id="ScreenParent">
					<option>Option 1</option>
					<option>Option 2</option>
					<option>Option 3</option>
				</select>
			</div>
		</div>
	</div>
	<div class="col-lg-12">
		<div class="form-group">
			<label class="col-md-3 control-label" for="inputDefault">Screen URL</label>
			<div class="col-md-6">
				<input type="text" class="form-control"  id="ScreenName">
			</div>
		</div>
	</div>	
	<div class="col-lg-12">
		<div class="form-group">
			<label class="col-md-3 control-label" for="inputDefault">Screen Icon</label>
			<div class="col-md-6">
				<input type="text" class="form-control"  id="ScreenIcon">
			</div>
		</div>
	</div>
	



</body>
<%@ include file="../impl/_vendor.jsp"%>
<script src="<%=request.getContextPath() %>/res/js/impl/create-screen.js"></script>
</html>