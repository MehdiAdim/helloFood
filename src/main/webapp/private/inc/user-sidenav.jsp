<div class="col-sm-3">

	
	
	
	<ul class="collapsible" data-collapsible="accordion">
		<li>
			<div class="collapsible-header">
				<p>NAME</p>
			</div>
			<div class="collapsible-body">

				<p> Name : <strong>${user.nom} ${user.prenom}</strong></p>
				
			</div>
		</li>
		<li>
			<div class="collapsible-header">
				<p>ROLE</p>
			</div>
			<div class="collapsible-body">
				<p><strong>${user.role.roleName}</strong></p>
			</div>
		</li>
		
		<li>
			<div class="collapsible-header">
				<p>LAST ACCESS</p>
			</div>
			<div class="collapsible-body">
				<p><strong>${user.lastAccessDate}</strong></p>
			</div>
		</li>
		<li>
			<div class="collapsible-header">
				<p>IP ADRESSE</p>
			</div>
			<div class="collapsible-body">
				<p><strong>${pageContext.request.localAddr}
				 
				</strong></p>
			</div>
		</li>
	</ul>


</div>



