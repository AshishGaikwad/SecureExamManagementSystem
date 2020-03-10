<!doctype html>
<html class="fixed">
<head>
<title>Secure Exam Management System</title>
<!-- Basic -->
<meta charset="UTF-8">

<!-- <meta name="keywords" content="HTML5 Admin Template" />
		<meta name="description" content="Porto Admin - Responsive HTML5 Template">
		<meta name="author" content="okler.net"> -->

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Web Fonts  -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light"
	rel="stylesheet" type="text/css">

<!-- Vendor CSS -->
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="assets/vendor/magnific-popup/magnific-popup.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

<link rel="stylesheet" href="assets/vendor/pnotify/pnotify.custom.css" />

<!-- Theme CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

<!-- Head Libs -->
<script src="assets/vendor/modernizr/modernizr.js"></script>

</head>
<body>
	<!-- start: page -->
	<!doctype html>
<html class="fixed">
<head>
<title>Secure Exam Management System</title>
<!-- Basic -->
<meta charset="UTF-8">

<!-- <meta name="keywords" content="HTML5 Admin Template" />
<meta name="description"
	content="Porto Admin - Responsive HTML5 Template">
<meta name="author" content="okler.net"> -->

<!-- Mobile Metas -->
<meta name="viewport"
	content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />

<!-- Web Fonts  -->
<link
	href="http://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700,800|Shadows+Into+Light"
	rel="stylesheet" type="text/css">

<!-- Vendor CSS -->
<link rel="stylesheet" href="assets/vendor/bootstrap/css/bootstrap.css" />
<link rel="stylesheet"
	href="assets/vendor/font-awesome/css/font-awesome.css" />
<link rel="stylesheet"
	href="assets/vendor/magnific-popup/magnific-popup.css" />
<link rel="stylesheet"
	href="assets/vendor/bootstrap-datepicker/css/datepicker3.css" />

<!-- Theme CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme.css" />

<!-- Skin CSS -->
<link rel="stylesheet" href="assets/stylesheets/skins/default.css" />

<!-- Theme Custom CSS -->
<link rel="stylesheet" href="assets/stylesheets/theme-custom.css">

<!-- Head Libs -->
<script src="assets/vendor/modernizr/modernizr.js"></script>

</head>
<body>
	<!-- start: page -->
	<div class="row">
		<div class="col-xs-12">
			<section class="panel form-wizard" id="RegistrationDetails">
				<header class="panel-heading">
					<div class="panel-actions">
						<!-- 	<a href="#" class="fa fa-caret-down"></a> <a href="#"
							class="fa fa-times"></a> -->
					</div>

					<h2 class="panel-title">User Registration</h2>
				</header>
				<div class="panel-body">
					<div class="wizard-progress wizard-progress-lg">
						<div class="steps-progress">
							<div class="progress-indicator"></div>
						</div>
						<ul class="wizard-steps">
							<li class="active"><a href="#RegistrationDetails-BasicInformation"
								data-toggle="tab"><span>1</span>Contact Information</a></li>
							<li><a href="#RegistrationDetails-UserInformation"
								data-toggle="tab"><span>2</span>User Information Info</a></li>
							<li><a href="#RegistrationDetails-PAS" data-toggle="tab"><span>3</span>Photo
									and Signature</a></li>
							<li><a href="#RegistrationDetails-Conf"
								data-toggle="tab"><span>4</span>Confirmation</a></li>
						</ul>
					</div>

					<form class="form-horizontal" novalidate="novalidate">
						<div class="tab-content">
							<div id="RegistrationDetails-BasicInformation" class="tab-pane active">
								<div class="row">
									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-3 control-label" for="MobileNo">Mobile
												No</label>
											<div class="col-sm-7">
												<input type="text" class="form-control" name="MobileNo"
													id="MobileNo" maxlength="10" required>
											</div>
											<div class="col-sm-2">
												<button type="button" class="btn btn-info"
													id="BtnSendMobileOTP">SEND</button>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="MobileOTP">OTP</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="MobileOTP"
													id="MobileOTP" required disabled> <label
													id="MobileNoOTPMessage"></label>
											</div>

										</div>
										<div class="form-group">

											<label class="col-sm-3 control-label"></label>
											<div class="col-sm-9">
												<button type="button" class="btn btn-block btn-info"
													id="BtnVerifyMobileOTP" disabled>Verify Mobile</button>
												<button type="button" style="display: none"
													class="btn btn-block btn-info" id="BtnResendMobileOTP"
													disabled>Resend Mobile OTP</button>
											</div>
										</div>

									</div>
									<div class="col-sm-6">

										<div class="form-group">
											<label class="col-sm-3 control-label" for="EmailId">Email
												Id</label>
											<div class="col-sm-7">
												<input type="email" class="form-control" name="EmailId"
													id="EmailId" required>
											</div>
											<div class="col-sm-2">
												<button type="button" class="btn btn-info"
													id="BtnSendEmailOTP">SEND</button>
											</div>
										</div>
										<div class="form-group">
											<label class="col-sm-3 control-label" for="EmailIdOTP">OTP</label>
											<div class="col-sm-9">
												<input type="text" class="form-control" name="EmailIdOTP"
													id="EmailIdOTP" required disabled> <label
													id="EmailIdOTPMessage"></label>
											</div>

										</div>
										<div class="form-group">

											<label class="col-sm-3 control-label"></label>
											<div class="col-sm-9">
												<button type="button" class="btn btn-block btn-info"
													id="BtnVerifyEmailIdOTP" disabled>Verify Email Id</button>
												<button type="button" style="display: none"
													class="btn btn-block btn-info" id="BtnResendEmailIdOTP"
													disabled>Resend Email OTP</button>
											</div>
										</div>



									</div>
								</div>

							</div>
							<div id="RegistrationDetails-UserInformation" class="tab-pane">
								<div class="row">
									<div class="col-sm-3"></div>
									<div class="col-sm-6">
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
											<label class="col-md-3 control-label" for="inputDefault">Date
												Of Birth</label>
											<div class="col-md-6">
												<input type="text" data-plugin-datepicker
													data-plugin-datepicker data-date-format="dd/mm/yyyy"
													data-input-mask="99/99/9999" placeholder="dd/mm/yyyy"
													class="form-control" id="DateOfBirth">
											</div>
											<label class="col-md-3 control-label error"
												id="DateOfBirthErr" for="inputDefault"></label>
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
												<input type="password" class="form-control"
													id="ConfirmPassword">
											</div>
											<label class="col-md-3 control-label error"
												id="ConfirmPasswordErr" for="inputDefault"></label>
										</div>
									</div>
									<div class="col-sm-3"></div>
								</div>

							</div>
							<div id="RegistrationDetails-PAS" class="tab-pane ">


								<div class="row">

									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-sm-3 control-label" for="inputDefault">Upload
												Photo</label>
											<div class="col-sm-6">
												<input type="file" class="form-control" id="UploadPhoto">
												<input type="hidden" class="form-control" id="Photo">


											</div>
											<label class="col-sm-3 control-label error"
												id="UploadPhotoErr" for="inputDefault"></label>
										</div>
										<div class="form-group">
											<div class="col-sm-3"></div>
											<div class="col-sm-3">
												<h5 class="text-semibold text-dark text-uppercase">View
													Photo</h5>
												<a id="ViewPhotoA" href="assets/images/projects/project.jpg"
													data-plugin-lightbox
													data-plugin-options='{ "type":"image" }'
													title="Caption. Can be aligned it to any side and contain any HTML.">
													<img id="ViewPhotoI" class="img-responsive"
													src="assets/images/projects/project.jpg" width="145">
												</a>
											</div>

										</div>

									</div>

									<div class="col-sm-6">
										<div class="form-group">
											<label class="col-md-3 control-label" for="inputDefault">Upload
												Signature</label>
											<div class="col-md-6">
												<input type="file" class="form-control" id="UploadSignature">
												<input type="hidden" class="form-control" id="Signature">
											</div>
											<label class="col-md-3 control-label error"
												id="UploadSignatureErr" for="inputDefault"></label>
										</div>
										<div class="form-group">
											<div class="col-sm-3"></div>
											<div class="col-sm-3">
												<h5 class="text-semibold text-dark text-uppercase">View
													Signature</h5>
												<a id="ViewSignatureA"
													href="assets/images/projects/project.jpg"
													data-plugin-lightbox
													data-plugin-options='{ "type":"image" }'
													title="Caption. Can be aligned it to any side and contain any HTML.">
													<img id="ViewSignatureI" class="img-responsive"
													src="assets/images/projects/project.jpg" width="145">
												</a>
											</div>

										</div>

									</div>

								</div>
							</div>
							<div id="RegistrationDetails-Conf" class="tab-pane">
								<h3>Terms & Conditions</h3>
								<div style="height: 300px; overflow: scroll; background: white">What
									is Lorem Ipsum? Lorem Ipsum is simply dummy text of the
									printing and typesetting industry. Lorem Ipsum has been the
									industry's standard dummy text ever since the 1500s, when an
									unknown printer took a galley of type and scrambled it to make
									a type specimen book. It has survived not only five centuries,
									but also the leap into electronic typesetting, remaining
									essentially unchanged. It was popularised in the 1960s with the
									release of Letraset sheets containing Lorem Ipsum passages, and
									more recently with desktop publishing software like Aldus
									PageMaker including versions of Lorem Ipsum. Why do we use it?
									It is a long established fact that a reader will be distracted
									by the readable content of a page when looking at its layout.
									The point of using Lorem Ipsum is that it has a more-or-less
									normal distribution of letters, as opposed to using 'Content
									here, content here', making it look like readable English. Many
									desktop publishing packages and web page editors now use Lorem
									Ipsum as their default model text, and a search for 'lorem
									ipsum' will uncover many web sites still in their infancy.
									Various versions have evolved over the years, sometimes by
									accident, sometimes on purpose (injected humour and the like).


									Where does it come from? Contrary to popular belief, Lorem
									Ipsum is not simply random text. It has roots in a piece of
									classical Latin literature from 45 BC, making it over 2000
									years old. Richard McClintock, a Latin professor at
									Hampden-Sydney College in Virginia, looked up one of the more
									obscure Latin words, consectetur, from a Lorem Ipsum passage,
									and going through the cites of the word in classical
									literature, discovered the undoubtable source. Lorem Ipsum
									comes from sections 1.10.32 and 1.10.33 of "de Finibus Bonorum
									et Malorum" (The Extremes of Good and Evil) by Cicero, written
									in 45 BC. This book is a treatise on the theory of ethics, very
									popular during the Renaissance. The first line of Lorem Ipsum,
									"Lorem ipsum dolor sit amet..", comes from a line in section
									1.10.32. The standard chunk of Lorem Ipsum used since the 1500s
									is reproduced below for those interested. Sections 1.10.32 and
									1.10.33 from "de Finibus Bonorum et Malorum" by Cicero are also
									reproduced in their exact original form, accompanied by English
									versions from the 1914 translation by H. Rackham. Where can I
									get some? There are many variations of passages of Lorem Ipsum
									available, but the majority have suffered alteration in some
									form, by injected humour, or randomised words which don't look
									even slightly believable. If you are going to use a passage of
									Lorem Ipsum, you need to be sure there isn't anything
									embarrassing hidden in the middle of text. All the Lorem Ipsum
									generators on the Internet tend to repeat predefined chunks as
									necessary, making this the first true generator on the
									Internet. It uses a dictionary of over 200 Latin words,
									combined with a handful of model sentence structures, to
									generate Lorem Ipsum which looks reasonable. The generated
									Lorem Ipsum is therefore always free from repetition, injected
									humour, or non-characteristic words etc.</div>

								<br> <input type="checkbox" class="" id="AcceptCondtions">

								<label class="control-label">I accept Terms and
									Conditions.</label>

							</div>

						</div>
					</form>
				</div>
				<div class="panel-footer">
					<ul class="pager">
						<li class="previous disabled"><a><i
								class="fa fa-angle-left"></i> Previous</a></li>
						<li class="finish hidden pull-right"><a>Finish</a></li>
						<li class="next"><a>Next <i class="fa fa-angle-right"></i></a>
						</li>
					</ul>
				</div>
			</section>
		</div>
	</div>
	<!-- end: page -->

	<!-- Vendor -->
	<script src="assets/vendor/jquery/jquery.js"></script>
	<script
		src="assets/vendor/jquery-browser-mobile/jquery.browser.mobile.js"></script>
	<script src="assets/vendor/bootstrap/js/bootstrap.js"></script>
	<script src="assets/vendor/nanoscroller/nanoscroller.js"></script>
	<script
		src="assets/vendor/bootstrap-datepicker/js/bootstrap-datepicker.js"></script>
	<script src="assets/vendor/magnific-popup/magnific-popup.js"></script>
	<script src="assets/vendor/jquery-placeholder/jquery.placeholder.js"></script>

	<script src="assets/vendor/jquery-validation/jquery.validate.js"></script>
	<script src="assets/vendor/bootstrap-wizard/jquery.bootstrap.wizard.js"></script>
	<script src="assets/vendor/pnotify/pnotify.custom.js"></script>


	<!-- Theme Base, Components and Settings -->
	<script src="assets/javascripts/theme.js"></script>

	<!-- Theme Custom -->
	<script src="assets/javascripts/theme.custom.js"></script>

	<!-- Theme Initialization Files -->
	<script src="assets/javascripts/theme.init.js"></script>

	<!-- FUNCTIONAL JAVASCRIPTSS -->
	<script src="res/js/config.js"></script>
	<script src="res/js/util.js"></script>
	<script src="res/js/index.js"></script>
	<script src="res/js/registration.js"></script>

</body>
</html>