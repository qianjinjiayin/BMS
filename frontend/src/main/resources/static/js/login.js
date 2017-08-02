jQuery(document).ready(function() {
    $.backstretch(["img/backgrounds/1.jpg", "img/backgrounds/2.jpg", "img/backgrounds/3.jpg"], {
        duration: 3000,
        fade: 750
    });

    $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
        $(this).removeClass('input-error');
    });

    $('#loginButton').on('click', function() {
    	checkMandatory($('#loginWindow'));
    	if(passMandatory){
    		clcikLoginButton();
    	}
    });
    
    $('#registerButton').on('click', function() {
    	checkMandatory($('#regitserWindow'));
    	if(passMandatory){
    		clickRegisterButton();
    	}
    });
    
    var passMandatory = true;
    var checkMandatory = function(window){
    	$(window).find('input[type="text"], input[type="password"], textarea').each(function() {
            if ($(this).val() == "") {
                $(this).addClass('input-error');
                passMandatory = false;
            } else {
                $(this).removeClass('input-error');
                passMandatory = true;
            }
        });
    };

    var clcikLoginButton = function(){
    	var username = $('#login-username').val();
    	var password = $('#login-password').val();
        $.ajax({
            url: "/validateLogin",
            type: "post",
            data: {"username": username, "password": password}, 
            dataType: "json",
            success: function(data) {
            	// alert("success");
            	
            	var messages = data.msgs;
        		var i;
        		for(i = 0; i < messages.length; i++) {
        			alert(messages[i]);
        		}
        		
            	var pass = data.pass;
            	if(pass){
            		$('#loginWindow .login-form').submit();
            	}
            },
            error: function(data){
            	alert("system error!");
            }
        });
    };
   
    var clickRegisterButton = function(){
    	var password = $('#register-password').val();
        var confirmedPassword = $('#register-confirmPassword').val();
        if (password !== confirmedPassword) {
            alert("Entered passwords differ");
            return;
        }

        $.ajax({
            url: "/user/create",
            type: "post",
            data: $('#regitserWindow .login-form').serialize(),
            dataType: "json",
            success: function(data) {
            	// alert("success");
            	
            	var messages = data.msgs;
        		var i;
        		for(i = 0; i < messages.length; i++) {
        			alert(messages[i]);
        		}
        		
            	var pass = data.pass;
            	if(pass){
            		$('#backToLoginButton').click();
            	}
            },
            error: function(data){
            	alert("system error!");
            }
        });

    };

    $('#openRegisterButton').on('click', function() {
        $('#loginWindow').hide();
        $('#regitserWindow').show();
    });

    $('#backToLoginButton').on('click', function() {
        $('#loginWindow').show();
        $('#regitserWindow').hide();
    });

});