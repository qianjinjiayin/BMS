self = BMS.user = {
		TARGET_HOME : "/home",
		
		bindToNavigation : function() {
		}
};

jQuery(document).ready(function() {
    $('#updateButton').on('click', function(e) {
    	$.ajax({
            url: "/user/update",
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
    });
    
    
	with (BMS.user) {
		// bindToNavigation();
	}
});
