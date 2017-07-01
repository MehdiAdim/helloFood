<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>
<%@taglib uri="/struts-tags" prefix="s"%>



<div class="container-fluid bg-user text-center">
	<div class="row">


		<jsp:include page="/private/inc/user-sidenav.jsp" />

		<div class="col-sm-1 "></div>



		<div class="col-sm-6 " id="form-reservation">

			<s:form action="askReservation" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<div class="alert alert-info" style="padding-bottom: 5px; padding-top: 5px;">
					<p>
						Here you can reserve in your favorite restaurant . 
					</p>
				</div>

				<s:select cssClass="browser-default input-lg textT"
					label="Restaurant" headerKey="-1" listKey="idRestaurant"
					listValue="%{nomRestaurant}" headerValue="Choose a restaurant ..."
					list="restos" name="selectedRestaurant" />
				<br/>

				<div class="form-group">
					<!-- Date input -->
					<s:textfield cssClass="form-control " id="date" name="beginDate"
						placeholder="Choose the day of your reservation" type="text" />
						<br/>
					<s:textfield cssClass="form-control " id="beginTime"
						name="beginTime" type="text" placeholder="Hour of begining" />
						<br/>
					<s:textfield cssClass="form-control " id="endTime" name="endTime"
						type="text" placeholder="Hour of finishing" />
				</div>


				<s:submit value="Valider" cssClass="btn btn-primary" />
				<br/>
				<br/>
				<div class="alert alert-danger erreur1" style="padding-bottom: 5px; padding-top: 5px;">
				  <strong>Error!</strong> ${sessionScope.erreur }
				</div>


			</s:form>
		</div>
		
		<div class="col-sm-6 " id="allReservation">
		
			<d:table name="restos" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="20">
				
				<d:column property="idRestaurant" title="ID" />
				<d:column property="adresseRestaurant" title="ADRESSE" />
				<d:column property="nomRestaurant" title="NAME" />
				
			</d:table>
			
		</div>
		
		<div class="col-sm-6 " id="userReservations">
		
			<d:table name="userReservations" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="15"
				
				>
				
				<d:column property="idReservation" title="ID" />
				<d:column property="restaurant.nomRestaurant" title="RESTAURANT" />
				<d:column property="startReservation" title="START" />
				<d:column property="endReservation" title="END" />
				<d:column property="notExpired" title="VALID" />
				<d:column property="table.numTable" title="TABLE" />
				
				
			</d:table>
			
		</div>
		
		<div class="col-sm-6 " id="futureReservations">
		
			<d:table name="futureReservations" requestURI="/home" id="table"
				class="table table-striped table-condensed txtsize" pagesize="15"
				
				>
				
				<d:column property="idReservation" title="ID" />
				<d:column property="restaurant.nomRestaurant" title="RESTAURANT" />
				<d:column property="startReservation" title="START" />
				<d:column property="endReservation" title="END" />
				<d:column property="notExpired" title="VALID" />
				<d:column property="table.numTable" title="TABLE" />
				
				
			</d:table>
			
		</div>
		
		
		

	</div>
</div>