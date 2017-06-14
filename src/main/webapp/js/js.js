$(document).ready(function(){
	 $("#listusers").hide();
	 $("#listRestau").hide();
	 $(".pagelinks").hide();
	 
	 
	 $("#form-reservation").hide();
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
	
	 
    $("#buttonU").click(function(){
        $("#listusers").show();
        $("#listRestau").hide();
    });
    $("#buttonR").click(function(){
        $("#listRestau").show();
        $("#listusers").hide();
    });
    
    $("#beginTime").click(function(){
        $("#erreur1").hide();
    });
    $("#reserve").click(function(){
        $("#form-reservation").show();
        $("#allReservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").hide();
    });
    
    $("#allrestos").click(function(){
        $("#allReservation").show();
        $("#form-reservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").hide();
    });
    
    $("#allresrv").click(function(){
        $("#allReservation").hide();
        $("#form-reservation").hide();
        $("#userReservations").show();
        $("#futureReservations").hide();
    });
    
    $("#futureresrv").click(function(){
        $("#allReservation").hide();
        $("#form-reservation").hide();
        $("#userReservations").hide();
        $("#futureReservations").show();
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