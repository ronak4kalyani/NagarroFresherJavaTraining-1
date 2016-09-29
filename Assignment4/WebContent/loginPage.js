$(function(){
	
	var radio  =$("input[type=radio]") ;
	
	//divs
	var kindOfUserDiv =$("#kindOfUser");
	var loginDiv  = $("#login") ;
	var registerDiv  = $("#register") ;
	var forgotPasswordDiv =$("#forgotPasswordDiv");
	
	//link of forgot Pass
	var fpassSpan  = $("#fpassSpan") ;
	
	//forms
	var fpForm =$("#fpForm");
	var loginForm = $("#loginForm");
	var registrationForm = $("#registrationForm");
	
	//Msg
	var fpValidationMsg = $("#fpValidationMsg");
	var loginValidationMsg= $("#loginValidationMsg") ;
	var RegistrationValidationMsg=$("#RegistrationValidationMsg");
	
	//input form controls
	var registerPass =  $("#registerPass");
	var registerRePass = $("#registerRePass");
	var registerFullName =  $("#registerFullName");
	var registerUserName = $("#registerUserName");
	var registerEmail =  $("#registerEmail");
	
	
	radio.on("click",function(){
		var val =  $(this).val();
		$(this).prop('checked', false);
		kindOfUserDiv.css("display","none");
		if (val=="existing")
			loginDiv.css("display","block");
		else
			registerDiv.css("display","block");
	});
	
	fpassSpan.on("click",function(){
		loginDiv.css("display","none");
		forgotPasswordDiv.css("display","block");
	});
	
	fpForm.on("submit",function(e){
		var a = $("#forgotPasswordUserName").val();
		var b = $("#forgotPasswordEmail").val();
		e.preventDefault();
		 $.ajax({url: "forgotPass", method:"post" ,data: { Username: a, email: b },success: function(data){
			 fpValidationMsg.html(data);
		    }});
		 fpValidationMsg.css("display","block");
	});
	
	loginForm.on("submit",function(e){
		var a = $("#loginUserName").val();
		var b = $("#loginPass").val();
		e.preventDefault();
		$.ajax({url: "login", method:"post", data: { loginuserName: a, loginpass: b },success: function(data){
			loginValidationMsg.html(data);
			if(data=="Login sucessful")
				window.location.replace("ImageUtility");
	    }});
		loginValidationMsg.css("display","block");
	});
	
	registrationForm.on("submit",function(event){
		var a  = registerFullName.val() ;
		var b=  registerUserName.val();
		var c  = registerEmail.val() ;
		var d=  registerPass.val();
		var e  = registerRePass.val() ;
		
		event.preventDefault();
		RegistrationValidationMsg.css("display","block");
		if(d!=e) {
			RegistrationValidationMsg.html("Password don't match");
		  } 
		else
		{
			$.ajax({url: "RegisterUser", method:"post", data: {name:a , userName: b,email:c ,pass: d },success: function(data){
				RegistrationValidationMsg.html(data);
				console.log(data);
				if(data=="Registered sucessfully") 
				window.location.replace("ImageUtility");
		    }});
		}
		
	});
	
	function getCookie(cname) {
	    var name = cname + "=";
	    var ca = document.cookie.split(';');
	    for(var i = 0; i <ca.length; i++) {
	        var c = ca[i];
	        while (c.charAt(0)==' ') {
	            c = c.substring(1);
	        }
	        if (c.indexOf(name) == 0) {
	            return c.substring(name.length,c.length);
	        }
	    }
	    return "";
	}
	
	function init(){
		var a = getCookie("username") ;
		if(a!="")
			window.location.replace("Welcome");
	}
	
	init();
});