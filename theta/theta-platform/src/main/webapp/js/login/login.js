/**
 * user login operation
 */
var login = {
	init : function() {
		// do nothing;
	},
	signIn:function(){
		$.ajax({
            type: "POST",
            url: base_url+'theta-platform/userLogin/login',
            data:
            {
	            'userId':"aaa"
			 },
            dataType: "json",
            sync:'true',
            success: function(resp){
               if(resp)
               {
               	if(0==resp.code){
               		var ctx = $('#ctx').val();
               		window.location.href=base_url+'theta-platform/'+resp.data;
               	}
               	else{
               		// reload
               		//location.reload(); 
               	}
               }
            },
            error:function(resp){
            	
            }
        }).done(function(resp){
       });
	}
}