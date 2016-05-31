<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">
    <title>Furniture Store Online</title>
    
    <!-- core CSS -->
    <link href="${pageContext.request.contextPath}/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/font-awesome.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/prettyPhoto.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/animate.min.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/main.css" rel="stylesheet">
    <link href="${pageContext.request.contextPath}/resources/css/responsive.css" rel="stylesheet">
    <script src="${pageContext.request.contextPath}/resources/js/jquery.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/bootstrap.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.prettyPhoto.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/jquery.isotope.min.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/main.js"></script>
    <script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
    <script src='${pageContext.request.contextPath}/<c:url value="/resource/js/controllers.js" />'></script>
    <script src="${pageContext.request.contextPath}/resource/js/scripts.js"></script>
    <script src='<c:url value="${pageContext.request.contextPath}/resource/js/controllers.js" />'></script>
   <script src='<c:url value="${pageContext.request.contextPath}/resource/js/scripts.js" />'></script>
    <script>
 function formSubmit()
 {
    document.getElementById("logout").submit();
		 }
    </script>
</head><!--/head-->

<body>

    <header id="header">
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-sm-6 col-xs-4">
                        <div class="top-number"><p>  My Furniture Shop</p></div>
                    </div>
                    <div class="col-sm-6 col-xs-8">
                      
                            <div class="search navbar-right">
                                <form role="form">
                                    <input type="text" class="search-form" autocomplete="on" placeholder="Search">
                                    <i class="fa fa-search"></i>
                                </form>
                            </div>
                    </div>
                </div>
            </div><!--/.container-->
        </div><!--/.top-bar-->

        <nav class="navbar navbar-inverse" role="banner" id="check">
            <div class="container" id="myCheck">
                <div class="navbar-header" >
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    
                </div>
                <c:url value="/perform_logout" var="logout" />
                <form action="${logout}" method="post" id="logout">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                </form>
                
                 <div class="collapse navbar-collapse navbar">
                    <ul class="nav navbar-nav">
                       <li><a href="${pageContext.request.contextPath}/index">Home</a></li>
                        <li><a href="${pageContext.request.contextPath}/about">About Us</a></li>
                       <li><a href="${pageContext.request.contextPath}/products">All Products</a>
                     <c:if test="${pageContext.request.userPrincipal.name == 'Krishna'}">
                      <li><a href="${pageContext.request.contextPath}/prodRegistration">Add New Products</a></li></c:if>
						 <li><a href="${pageContext.request.contextPath}/contact">Contact Us</a></li>
						</ul>
                       
					<ul class="nav navbar-nav navbar-right">
					<c:if
					test="${pageContext.request.userPrincipal.name != null}">
					<li> Welcome :${pageContext.request.userPrincipal.name}</li>
					<li> <a href="javascript:formSubmit()">Logout</a></li>
					<security:authentication var="user" property="principal.authorities" />
					<security:authorize var="loggedIn" access="isAuthenticated()">
					<security:authorize access="hasRole('ROLE_ADMIN')">
					<li>Admin</li>
					</security:authorize>
					<security:authorize access="hasRole('ROLE_USER')">
					<li>User</li>
					</security:authorize>
					</security:authorize>
					</c:if>
					<c:if 
					   test="${pageContext.request.userPrincipal.name==null}">
					 <li><a href="${pageContext.request.contextPath}/login"><span class="glyphicon glyphicon-log-in"></span>Login</a></li> 
					  <li><a href="${pageContext.request.contextPath}/signUp"><span class="glyphicon glyphicon-user"></span>Sign Up</a></li> 
					</c:if>
					
					
					<li></li>
					
					
     
                            
                    </ul>
                </div>
            </div><!--/.container-->
        </nav><!--/nav-->
        
    </header>