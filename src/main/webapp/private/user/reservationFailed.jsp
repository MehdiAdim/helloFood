<jsp:include page="/private/inc/navbar.jsp" />

<div class="container-fluid bg-buttonn text-center">

	<div class="alert alert-danger">
		<br /> <strong> FAILED RESERVATION</strong> <br />
		<p>AUCUNE TABLE LIBRE DANS CETTE RESTAURANT</p>
		<br />

	</div>
	<br />
	<%-- <li><a href="${pageContext.request.contextPath}/private/userProfile" style="padding-top:0px" >
        <i class="material-icons upcss">perm_identity</i></a></li>
		
		<li><a href="javascript:formSubmit()" data-toggle="tooltip" title="Log Out!" style="padding-top:0px">
			<i class="material-icons upcss">power_settings_new</i>
		</a></li> --%>


	<div class="btn-group mr-2" role="group" aria-label="First group">
		<a href="${pageContext.request.contextPath}/private/userProfile" class="btn btn-secondary">RESERVE IN OTHER RESTAURANTS</a>
		
		<a type="button" href="${pageContext.request.contextPath}/public/login" class="btn btn-secondary">WELCOME PAGE</a>

		<a href="javascript:formSubmit()" data-toggle="tooltip" title="Log Out!"  class="btn btn-secondary">LOG OUT</a>
	</div>

</div>
<jsp:include page="/private/inc/javascript.jsp" />

<jsp:include page="/private/inc/footer.jsp" />