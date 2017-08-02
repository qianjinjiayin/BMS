self = BMS.user = {
		TARGET_HOME : "/home",
		
		bindToNavigation : function() {
		}
};

jQuery(document).ready(function() {
	
	$('#userinfoForm .mandatory').on('focus', function() {
        $(this).removeClass('input-error');
    });

    $('#createButton').on('click', function(e) {
    	validate();
    	createUser();
    });
    
    var validate = function(){
    	$('#userinfoForm').find('.mandatory').each(function() {
            if ($(this).val() == "") {
                $(this).addClass('input-error');
            } else {
                $(this).removeClass('input-error');
            }
        });
    };
    
    var createUser = function(){
    	if($('#userinfoForm .input-error').length == 0){
    		
    		$.ajax({
                url: "/user/create",
                type: "post",
                data: $('#userinfoForm').serialize(),
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
                		
                	}
                },
                error: function(data){
                	alert("system error!");
                }
            });
    	}
    };
    
    
    
	with (BMS.user) {
		// bindToNavigation();
	}
});
