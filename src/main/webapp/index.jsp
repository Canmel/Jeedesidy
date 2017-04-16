<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<meta charset="utf-8" />
		<title>Olive Admin - Flat & Responsive Bootstrap Admin Template</title>
		<script src="static/js/angular/angular.js"></script>
		<script src="static/js/jquery-1.8.3.min.js"></script>
		<script src="static/js/angular/angular-ui-router.js"></script>
		<script src="static/js/bootstrap/bootstrap.min.js" ></script>
		<script src="static/js/jquery.dcjqaccordion.2.7.js" ></script>
		<script src="static/js/jquery.nicescroll.js" ></script>
		<script src="static/js/jquery.scrollTo.min.js" ></script>
		<script src="static/js/respond.min.js" ></script>
		<script src="static/js/app.js"></script>
		<script src="static/js/pager.js"></script>
		<script src="static/js/controller/userController.js" ></script>
		<script src="static/js/controller/menuController.js" ></script>
		<script src="static/js/controller/siderbarController.js" ></script>
		<script src="static/filter/angular-filter.js"></script>
		<script src="static/js/service/pageQuery.js"></script>
		 
		<link rel="stylesheet" href="static/css/bootstrap/bootstrap.min.css" />		
		<link rel="stylesheet" href="static/css/bootstrap/bootstrap-reset.css">
		<link rel="stylesheet" href="static/font-awesome/css/font-awesome.css" />
		<link rel="stylesheet" href="static/css/style.css" />
		<link rel="stylesheet" href="static/css/style-responsive.css" />
		<link rel="stylesheet" href="static/css/morris.css" />
		<link rel="stylesheet" href="static/css/clndr.css" />
		<title></title>
	</head>
	<body ng-app='meedesidy'>
		<section>
			<!-- head start -->
			<header class="header white-bg">
				<div class="sidebar-toggle-box">
				  <div  data-placement="right" class="fa fa-bars tooltips"></div>
				</div>
        		<a href="pages/index.jsp" class="logo">Olive<span>Admin</span></a>
      		</header>
			<!-- head end -->
			<!-- BEGIN SIDEBAR -->
			<aside>
				<div id="sidebar" class="nav-collapse" ng-controller='sidebar'>
				  <ul class="sidebar-menu" id="nav-accordion">
				    <li><a href="index.html">
				    	<i class="fa fa-dashboard"></i>
				    	<span> Dashboard</span></a>
				    </li>
				  	<li class="sub-menu dcjq-parent-li" ng-repeat="v in menus" ng-if="v.pid==0" ng-click="showMenu($event)">
						<a class="dcjq-parent" name='top_menu'>
							<i class="fa fa-book"></i> 
							<span>{{v.name}}</span>
						</a>
						<ul class="sub" style="display: ; overflow: hidden;" ng-if="true">
							<li ng-repeat="m in menus" ng-if="m.pid==v.id" ng-click="go($event, m.resouce)"><a style="cursor: pointer;">{{m.name}}</a></li>
						</ul>
					</li>
				  </ul>
				</div>
			</aside>
      		<!-- END SIDEBAR -->
		  <section id="main-content">
	  		<!-- BEGIN WRAPPER  -->
	        	<section class="wrapper">
	        		<div ui-view></div>
	        	</section>
			<!-- END WRAPPER  -->
	      </section>
	      <!-- main context -->
	      <footer class="site-footer">
	        <div class="text-center">2013 &copy; Olive Admin by 
	          <a href="" target="_blank">Olive Enterprise</a>
	          <a href="#" class="go-top"><i class="fa fa-angle-up"></i></a>
	        </div>
	      </footer>
		</section>
	</body>
	<script> 
		$(function(){
			var minHeight = $(document).height()-$("header").height()-$("footer").height() * 2;
			$(".wrapper").css('min-height',minHeight);
		});
	</script>
</html>