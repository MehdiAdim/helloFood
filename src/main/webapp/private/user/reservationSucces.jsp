<jsp:include page="/private/inc/navbar.jsp" />

<div class="container-fluid bg-buttonn text-center">
	
	<div class="alert alert-info">
		<strong> ACCEPTED RESERVATION</strong>
		
		<p>See you on : ${reservation.startReservation}</p>
		<p>Restaurant : <strong>${reservation.restaurant.nomRestaurant}</strong></p>
		<p>Table : <strong>${reservation.table.numTable}</strong></p>
		<p>Client : <strong>${reservation.user.nom} ${reservation.user.prenom}</strong></p>
		
		
		
	</div>
	<br/>

</div>
<jsp:include page="/private/inc/javascript.jsp" />

<jsp:include page="/private/inc/footer.jsp" />