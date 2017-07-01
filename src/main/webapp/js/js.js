$(document).ready(function(){
	 $("#listusers").hide();
	 $("#allRestos").hide();
	 $("#reservations").hide();
	 $("#tables").hide();
	 $("#occupiedTablesNow").hide();
	 $("#deleteUser").hide();
	 
	
	 $(".pagelinks").hide();
	 
	 

	 $("#allReservation").hide();
	 $("#userReservations").hide();
	 $("#futureReservations").hide();
	 
	 
	
	$('#beginTime').timepicki(
			{
				show_meridian:false,
				min_hour_value:0,
				max_hour_value:23,
				step_size_minutes:15,
				overflow_minutes:true,
				increase_direction:'up',
				disable_keyboard_mobile: true
				}		
	); 
	$('#endTime').timepicki(
			{
				show_meridian:false,
				min_hour_value:0,
				max_hour_value:23,
				step_size_minutes:15,
				overflow_minutes:true,
				increase_direction:'up',
				disable_keyboard_mobile: true
				}		
	);
	
	 
    $("#usersclick").click(function(){
        $("#listusers").show();
        $("#allRestos").hide();
        $("#reservations").hide();
        $("#tables").hide();
        $("#occupiedTablesNow").hide();
        $("#deleteUser").hide();

    });
    $("#restosclick").click(function(){
        $("#allRestos").show();
        $("#listusers").hide();
        $("#reservations").hide();
        $("#tables").hide();
        $("#occupiedTablesNow").hide();
        $("#deleteUser").hide();

    });
    $("#resevclick").click(function(){
        $("#allRestos").hide();
        $("#listusers").hide();
        $("#reservations").show();
        $("#tables").hide();
        $("#occupiedTablesNow").hide();
        $("#deleteUser").hide();

    });
    $("#tablesclick").click(function(){
        $("#allRestos").hide();
        $("#listusers").hide();
        $("#reservations").hide();
        $("#tables").show();
        $("#occupiedTablesNow").hide();
        $("#deleteUser").hide();
    });
    $("#nowclick").click(function(){
        $("#allRestos").hide();
        $("#listusers").hide();
        $("#reservations").hide();
        $("#tables").hide();
        $("#occupiedTablesNow").show();
        $("#deleteUser").hide();
        
    });
    $("#deleteclick").click(function(){
        $("#allRestos").hide();
        $("#listusers").hide();
        $("#reservations").hide();
        $("#tables").hide();
        $("#occupiedTablesNow").hide();
        $("#deleteUser").show();
        
    });
    
    
    
    
    
    
    $("#beginTime").click(function(){
        $("#erreur1").hide();
    });
    $("#reserve").click(function(){
        $("#form-reservation").show();
        $("#allReservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").hide();
        $("#deleteUser").hide();
    });
    
    $("#allrestos").click(function(){
        $("#allReservation").show();
        $("#form-reservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").hide();
        $("#deleteUser").hide();
    });
    
    $("#allresrv").click(function(){
        $("#allReservation").hide();
        $("#form-reservation").hide();
        $("#userReservations").show();
        $("#futureReservations").hide();
        $("#deleteUser").hide();
    });
    
    $("#futureresrv").click(function(){
        $("#allReservation").hide();
        $("#form-reservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").show();
        $("#deleteUser").hide();
    });
    
});

$(document).ready(function(){
  var date_input=$('input[name="beginDate"]'); //our date input has the name "date"
  var container=$('.bootstrap-iso form').length>0 ? $('.bootstrap-iso form').parent() : "body";
  var options={
    format: 'dd/mm/yyyy',
    container: container,
    todayHighlight: true,
    autoclose: true,
  
   
  };
  date_input.datepicker(options);
  
});

$(document).ready(function() {
    $('select').material_select();
    
  });

function deleteSubmit() {
    var txt;
    var r = confirm("Are you sure ?");
    if (r == true) {
    	document.getElementById("submitForm").submit();
    } else {
       
    }
  
}


