<%@ taglib uri="http://displaytag.sf.net" prefix="d"%>
<%@taglib uri="/struts-tags" prefix="s"%>

<div class="container-fluid bg-user text-center">
	<div class="row">
		<div class="col-sm-3 ">
			<p>koko</p>
		</div>
		<div class="col-sm-6 ">

			<s:form action="addPersonnel" method="POST">
				<input type="hidden" name="${_csrf.parameterName}"
					value="${_csrf.token}" />

				<s:select cssClass="browser-default input-lg" label="Restaurant"
					headerKey="-1" listKey="idRestaurant" listValue="%{nomRestaurant}"
					headerValue="Choose a restaurant ..." list="restos"
					name="selectedRestaurant" />

				<%-- <p>
					Enter Date:
					<s:textfield name="beginDate" type="text" id="datepicker-2"
						cssClass="form-control input-lg"></s:textfield>
				</p> --%>

				<div class="form-group">
					<!-- Date input -->
					<label class="control-label" for="date">Date</label>
					 <s:textfield
						cssClass="form-control " id="date" name="beginDate" placeholder="Choose the day of your reservation"
						type="text" />
					 <s:textfield
						cssClass="form-control " id="beginTime" name="beginTime" 
						type="text" />
				</div>
				
				
				
				


				<s:submit value="Valider" cssClass="btn btn-primary" />
			</s:form>



		</div>
		<div class="col-sm-3 ">
			<p>koko</p>
		</div>

	</div>
</div>