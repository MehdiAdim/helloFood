 
	 <form action="${pageContext.request.contextPath}/logout" id="logoutForm"
					method="post">
					<input type="hidden" name="${_csrf.parameterName}"
						value="${_csrf.token}" />
	</form>
	<script>
		function formSubmit() {
			document.getElementById("logoutForm").submit();
		}
	</script>