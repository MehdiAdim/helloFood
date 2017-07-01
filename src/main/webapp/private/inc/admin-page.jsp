<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>
<%@taglib uri="/struts-tags" prefix="s"%>


<div class="container-fluid bg-admin text-center">
	<div class="row">

		<jsp:include page="/private/inc/user-sidenav.jsp" />


		<div class="col-sm-9 " id="listusers">

			<d:table name="users" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="20">
				<d:column property="idUtilisateur" title="ID" />
				<d:column property="role.roleName" title="Role" />
				<d:column property="nom" title="First Name" />
				<d:column property="prenom" title="Last Name" />
				<d:column property="login" title="Login" />
				<d:column property="email" title="Email" />
				<d:column property="lastAccessDate" title="Last Access" />
				<d:column property="enabled" title="Enabled" />
			</d:table>
		</div>


		<div class="col-sm-9 " id="allRestos">

			<d:table name="restos" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="20">

				<d:column property="idRestaurant" title="ID" />
				<d:column property="adresseRestaurant" title="ADRESSE" />
				<d:column property="nomRestaurant" title="NAME" />

			</d:table>

		</div>
		<div class="col-sm-9 " id="reservations">

			<d:table name="reservations" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="15">

				<d:column property="idReservation" title="ID" />
				<d:column property="restaurant.nomRestaurant" title="RESTAURANT" />
				<d:column property="user.login" title="USER" />
				<d:column property="startReservation" title="START" />
				<d:column property="endReservation" title="END" />
				<d:column property="notExpired" title="VALID" />
				<d:column property="table.numTable" title="TABLE" />


			</d:table>

		</div>
		<div class="col-sm-9 " id="tables">

			<d:table name="tables" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="15">

				<d:column property="idTable" title="ID" />
				<d:column property="numTable" title="NUM" />
				<d:column property="restaurant.nomRestaurant" title="RESTAURANT" />
				<d:column property="isOccupied" title="IS OCCUPIED" />


			</d:table>

		</div>

		<div class="col-sm-9 " id="occupiedTablesNow">

			<d:table name="occupiedTablesNow" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="15">

				<d:column property="idTable" title="ID" />
				<d:column property="numTable" title="NUM" />
				<d:column property="restaurant.nomRestaurant" title="RESTAURANT" />
				<d:column property="isOccupied" title="IS OCCUPIED" />


			</d:table>

		</div>


		<div class="col-sm-9 " id="deleteUser">
			<s:form action="deleteUser" id="submitForm" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />
					
					<div class="alert alert-info" style="padding-bottom: 5px; padding-top: 5px;">
					<p>
						Choose user to delete . 
					</p>
				</div>

				<s:select cssClass="browser-default input-lg textT"
					label="User" headerKey="-1" listKey="idUtilisateur"
					listValue="%{login}" headerValue="Choose a user ..."
					list="users" name="selectedUserToDelete" />
				<a href="javascript:deleteSubmit()" Class="btn btn-primary" data-toggle="tooltip" title="Delete" >
				Delete
				</a>
			</s:form>
		</div>




	</div>




	<strong></strong>


</div>