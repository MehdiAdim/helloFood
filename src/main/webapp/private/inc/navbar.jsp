<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
   
    
	<!--Import Google Icon Font-->
	<link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
	
	
	<!--Import materialize.css-->	
	<link rel="stylesheet" type="text/css" media="screen,projection,print"
		href=<%out.print(request.getContextPath() + "/css/materialize.css");%> />
		
	<!--Import bootstrap.css-->
	<link rel="stylesheet" type="text/css" media="screen,projection,print"
		href=<%out.print(request.getContextPath() + "/css/bootstrap.css");%> />
		
	<!--Import picki.css-->
	<link rel="stylesheet" type="text/css" media="screen,projection,print"
		href=<%out.print(request.getContextPath() + "/css/timepicki.css");%> />
		
		
	
	<!--Import my style-->
	<link rel="stylesheet" type="text/css" media="screen,projection,print"
		href=<%out.print(request.getContextPath() + "/css/style.css");%> />
		
	<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.4.1/css/bootstrap-datepicker3.css"/>
	
	<!--Let browser know website is optimized for mobile-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    
    
	<title>helloFood</title>

	
</head>

<body>

 <!-- Logout  -->
 
 <jsp:include page="/private/inc/logout.jsp" />
 
 
 <nav class="navbar navbar-default">
  <div class="container">
    <div class="navbar-header">
      <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#"><strong>helloFood</strong></a>
    </div>
    <div class="collapse navbar-collapse" id="myNavbar">
      <ul class="nav navbar-nav navbar-right">
 
        
        
        
        <c:if test="${!empty pageContext.request.userPrincipal}">
        <li><a href="${pageContext.request.contextPath}/private/userProfile" style="padding-top:0px" >
        <i class="material-icons upcss">perm_identity</i></a></li>
		
		<li><a href="javascript:formSubmit()" data-toggle="tooltip" title="Log Out!" style="padding-top:0px">
			<i class="material-icons upcss">power_settings_new</i>
		</a></li>
		
			
		</c:if>
      </ul>
    </div>
  </div>
</nav>






