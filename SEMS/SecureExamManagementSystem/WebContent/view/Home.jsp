<!doctype html>


<%@page import="batu.dev.sem.utils.Util"%>
<%@page
	import="batu.dev.sem.bundles.UserManagement.daoimpl.ScreenDaoImpl"%>
<%@page import="batu.dev.sem.bundles.UserManagement.entity.UserEntity"%>
<%
	if (session.getAttribute("USER_ENTITY") == null) {
		response.sendRedirect(request.getContextPath() + "/");
	}
%>
<html class="fixed sidebar-left-collapsed js flexbox flexboxlegacy csstransforms csstransforms3d no-overflowscrolling no-mobile-device custom-scroll">
<%
	UserEntity lUserEntity = (UserEntity) session.getAttribute("USER_ENTITY");
	String pas = lUserEntity.getPas();
	
	System.out.println("pas== "+pas);
	String ps[] = null;
	String photo = "";
	if(pas != null)
	{
		ps = pas.split(",");
	}

	
	if(ps != null)
	{
		photo = "/SecureExamManagementSystem/FILES/"+ps[0];
	}else
	{
		photo = "assets/images/!logged-user.jpg";
	}
%>
<%@ include file="impl/_header.jsp"%>
<body>

	<link rel="stylesheet" href="res/css/home.css" />

	<script type="text/javascript">
			const lFullname = "<%=lUserEntity.getFullName()%>";
			const lEmail = "<%=lUserEntity.getEmail()%>" ;
			const lToken = "<%=lUserEntity.getPassword()%>";
			const lBasePath = "<%=request.getContextPath().toString()%>";
	</script>
	<section class="body">
	
	<div class="lds-dual-ring"></div>
		<input type="hidden" id="requestToken" value="">
		<input type="hidden" id="requestId" value="">
		<!-- start: header -->
		<header class="header">
			<div class="logo-container">
				<a href="../" class="logo"> <img src="assets/images/logo.png"
					height="35" alt="Porto Admin" />
				</a>
				<div class="visible-xs toggle-sidebar-left"
					data-toggle-class="sidebar-left-opened" data-target="html"
					data-fire-event="sidebar-left-opened">
					<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
				</div>
			</div>

			<!-- start: search & user box -->
			<div class="header-right">
				<span class="separator"></span> <span class="separator"></span>

				<div id="userbox" class="userbox">
					<a href="#" data-toggle="dropdown">
						<figure class="profile-picture">
							<img src="<%=photo%>" alt="Joseph Doe"
								class="img-circle"
								data-lock-picture="<%=photo%>" />
						</figure>
						<div class="profile-info" data-lock-name="John Doe"
							data-lock-email="johndoe@okler.com">
							<span class="name" id="display_name">John Doe Junior</span>
							<!-- <span class="role">administrator</span> -->
						</div> <i class="fa custom-caret"></i>
					</a>

					<div class="dropdown-menu">
						<ul class="list-unstyled">
							<li class="divider"></li>
<!-- 							<li><a role="menuitem" tabindex="-1"
								href="pages-user-profile.html"><i class="fa fa-user"></i> My
									Profile</a></li> -->
							<li><a role="menuitem" tabindex="-1" href="#"
								data-lock-screen="true"><i class="fa fa-lock"></i> Lock
									Screen</a></li>
							<li><a role="menuitem" tabindex="-1"
								href="<%=request.getContextPath().toString()%>/Logout"><i class="fa fa-power-off"></i>
									Logout</a></li>
						</ul>
					</div>
				</div>
			</div>
			<!-- end: search & user box -->
		</header>
		<!-- end: header -->

		<div class="inner-wrapper">
			<!-- start: sidebar -->
			<aside id="sidebar-left" class="sidebar-left">

				<div class="sidebar-header">
					<div class="sidebar-title">Navigation</div>
					<div class="sidebar-toggle hidden-xs"
						data-toggle-class="sidebar-left-collapsed" data-target="html"
						data-fire-event="sidebar-left-toggle">
						<i class="fa fa-bars" aria-label="Toggle sidebar"></i>
					</div>
				</div>

				<div class="nano">
					<div class="nano-content">
						<nav id="menu" class="nav-main" role="navigation">



							<%
								out.print(Util.createMenus(request));
							%>

						</nav>
					</div>

				</div>

			</aside>
			<!-- end: sidebar -->

			<section role="main" class="content-body">
				<header class="page-header">
					<h2>Home</h2>

<!-- 					<div class="right-wrapper pull-right">
						<ol class="breadcrumbs">
							<li><a href="index.html"> <i class="fa fa-home"></i>
							</a></li>
							<li><span>Layouts</span></li>
							<li><span>Default</span></li>
						</ol>

						<a class="sidebar-right-toggle" data-open="sidebar-right"><i
							class="fa fa-chevron-left"></i></a>
					</div> -->
				</header>

				<!-- start: page -->
				<iframe id="CentralFrame" onload="resizeIframe()" src=""></iframe>

				<!-- end: page -->
			</section>
		</div>
	</section>

	<%@ include file="impl/_vendor.jsp"%>
	<script src="res/js/home.js"></script>
	<script type="text/javascript">
		document.getElementById("requestToken").value = lToken;
		document.getElementById("requestId").value = lEmail;
	</script>
</body>
</html>