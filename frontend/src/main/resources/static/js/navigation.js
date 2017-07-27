self = BMS.navigation = {
		TARGET_HOME : "/home",
		TARGET_USER_MANAGEMENT : "/userManagement",
		TARGET_BOOK_MANAGEMENT : "/bookManagement",
		
		bindToNavigation : function() {
			$('#fh5co-main-menu a').on('click', function(e) {
				
				var parent_li = $(this).parent();
				parent_li.siblings('li').removeClass('fh5co-active');
				parent_li.addClass('fh5co-active');
				
				var targetUrl;
				var targetName = $(this).text();
				switch (targetName) {
					case "Home":
						targetUrl = self.TARGET_HOME;
						break;
					case "User Management":
						targetUrl = self.TARGET_USER_MANAGEMENT;
						break;
					case "Book Management":
						targetUrl = self.TARGET_BOOK_MANAGEMENT;
						break;
					default:
						alert("000");
				}
				
				$.ajax({
	                url: targetUrl,
	                type: "get",
	                dataType: "text",
	                success: function(data) {
	                	// alert(data);
	                	$("#fh5co-main").empty().append(data);
	                }
	            });
			});
		}
};

jQuery(document).ready(function() {
	with (BMS.navigation) {
		// bindToNavigation();
	}
});
