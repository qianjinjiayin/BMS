
jQuery(document).ready(function() {

    $('.editUserButton').on('click', function(e) {
    	var userId = $(this).parent().find('[type=hidden]').val();
    	editUser(userId);
    });
    
    var editUser = function(userId){
    	window.location.href='/user/updateUserPage' + "?userId=" + userId;
    };
    
    var validate = function(){
    	$('#userinfoForm').find('.mandatory').each(function() {
            if ($(this).val() == "") {
                $(this).addClass('input-error');
            } else {
                $(this).removeClass('input-error');
            }
        });
    };
    
});
