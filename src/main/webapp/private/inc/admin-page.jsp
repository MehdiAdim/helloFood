<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>


<div class="container-fluid bg-admin text-center">
	<div class="row">
	
		<jsp:include page="/private/inc/user-sidenav.jsp" />
		
		
		<div class="col-sm-9 " id="listusers">

			<d:table name="users" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="20">
				<d:column property="idUtilisateur" title="ID" />
				<d:column property="role.roleName" title="Role" />
				<d:column property="nom" title="First Name" />
				<d:column property="prenom" title="Last Name"/>
				<d:column property="login" title="Login" />
				<d:column property="email" title="Email" />
				<d:column property="lastAccessDate" title="Last Access" />
				<d:column property="enabled" title="Enabled" />
			</d:table>
		</div>
		<div class="col-sm-9 " id="listRestau">

			<d:table name="users" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="20">
				<d:column property="idUtilisateur" title="ID" />
				<d:column property="role.roleName" title="Role" />
				<d:column property="nom" title="First Name" />
				<d:column property="prenom" title="Last Name"/>
				<d:column property="login" title="Login" />
				<d:column property="email" title="Email" />
				<d:column property="lastAccessDate" title="Last Access" />
				<d:column property="enabled" title="Enabled" />
			</d:table>
		</div>
		
		
		
		</div>




	<strong></strong>


</div>