self = BMS.index = {
	renderHomePage : function() {
		$.ajax({
            url: "/home",
            type: "get",
            dataType: "text",
            success: function(data) {
            	// alert(data);
            	$("#fh5co-main").empty().append(data);
            }
        });
	}
};

jQuery(document).ready(function() {
	with (BMS.index) {
		// renderHomePage();
	}
});
