<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
	<jsp:include page="/private/inc/navbar.jsp" />
	
	
	<c:if test="${empty pageContext.request.userPrincipal}">
		<jsp:include page="/private/inc/form-login.jsp" />
	</c:if>
	<c:if test="${!empty pageContext.request.userPrincipal}">
		<jsp:include page="/private/inc/denied.jsp" />
	</c:if>


	<div class="container-fluid bg-2 text-center">
		<h3>What Am I?</h3>
		<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do
			eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim
			ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut
			aliquip ex ea commodo consequat.</p>
		<a href="#" class="btn btn-default btn-lg"> Search</a>
	</div>

	<div class="container-fluid bg-3 text-center">
		<h3>Where To Find Me?</h3>
		<div class="row">
			<div class="col-sm-4">
				<p>Lorem ipsum..</p>
				<img src="birds1.jpg" alt="Image">
			</div>
			<div class="col-sm-4">
				<p>Lorem ipsum..</p>
				<img src="birds2.jpg" alt="Image">
			</div>
			<div class="col-sm-4">
				<p>Lorem ipsum..</p>
				<img src="birds3.jpg" alt="Image">
			</div>
		</div>
	</div>
	<jsp:include page="/private/inc/javascript.jsp" />
	<jsp:include page="/private/inc/footer.jsp" />
	
	