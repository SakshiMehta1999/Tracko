
function openNav() {
    document.getElementById("mySidenav").style.width = "40%";
}

function openNav1() {
    document.getElementById("mySidenav1").style.width = "40%";
}

function closeNav() {
	document.getElementById("mySidenav").style.width = "0";
}

function closeNav1() {
	document.getElementById("mySidenav1").style.width = "0";
}

////////////////////////////jquery/////////////////////////////

$(document).ready(function(){
    $("#btn").click(function(){
        $("#btn").hide();
		$("#btn1").hide();
     });
    $("#btn1").click(function(){
		$("#btn").hide();
		$("#btn1").hide();
	 });
	$(".closebtn").click(function(){
		$("#btn").show();
		$("#btn1").show();
	 });
	
});



///////////////////company-name validation/////////////////////
$(document).ready(function(){
	var patt = new RegExp("^[A-Z]");
	$("#comnm").blur(function(){
      if(!patt.test($('#comnm').val())) {
		  $(".error1").show();
		  $(".error1").html($('#comnm').val() +" :required,first letter should be uppercase");
		  $(".error1").css("background-color", "red");
		  $("#comnm").val("");
	  }else{
		  $(".error1").delay(2000).fadeOut();
		  $(".error1").html("correct");
		  $(".error1").css("background-color", "green");
	  }
	});
});

///////////////////CEO validation///////////////////////
$(document).ready(function(){
	var patt = new RegExp("^[A-Z]");
	$("#ceonm").blur(function(){
      if(!patt.test($('#ceonm').val())) {
		  $(".error2").show();
		  $(".error2").html($('#ceonm').val() +" :required,first letter should be uppercase");
		  $(".error2").css("background-color", "red");
		  $("#ceonm").val("");
	  }else{
		  $(".error2").delay(2000).fadeOut();
		  $(".error2").html("correct");
		  $(".error2").css("background-color", "green");
	  }
	});
});



////////////////////////////email-validation//////////////////
$(document).ready(function(){
	var patt = new RegExp("[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?");
	$("#email").blur(function(){
      if(!patt.test($('#email').val())) {
		  $(".error3").show();
		  $(".error3").html($('#email').val() +" : invalid email");
		  $(".error3").css("background-color", "red");
		  $("#email").val("");
	  }else{
		  $(".error3").delay(2000).fadeOut();
		  $(".error3").html("correct");
		  $(".error3").css("background-color", "green");
	  }
	});
});
/////////////////////password///////////////////////
$(document).ready(function(){
	var patt = new RegExp("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[$@$!%*?&])[A-Za-z\\d$@$!%*?&]{8,10}");
	$("#passval").blur(function(){
      if(!patt.test($('#passval').val())) {
		  $(".error4").show();
		  $(".error4").html("invalid password : must be one uppercase ,lowercase character, special symbol ,and numeric ");
		  $(".error4").css("background-color", "red");
		  $("#passval").val("");
	  }else{
		  $(".error4").delay(2000).fadeOut();
		  $(".error4").html("correct");
		  $(".error4").css("background-color", "green");
	  }
	});
});
//////////////////////////////repassword/////////////////////////////
$(document).ready(function(){
	$("#repass").blur(function(){
      if($("#repass").val() != $("#passval").val()) {
		  $(".error5").show();
		  $(".error5").html("password and repassword must match !!!");
		  $(".error5").css("background-color", "red");
		  $("#repass").val("");
	  }else{
		  $(".error5").delay(2000).fadeOut();
		  $(".error5").html("match");
		  $(".error5").css("background-color", "green");
	  }
	});
});




