/*商品详情页面判断数量的加减*/
jQuery.extend( {  
    min : 1,  
    reg : function(x) {  
         
        return new RegExp("^[1-9]\\d*$").test(x);  
    },  
    amount : function(obj, mode) {  
        var x = jQuery(obj).val();  
        if (this.reg(parseInt(x))) {  
            if (mode) {  
                x++;  
            } else {
            	if(x==1){
            		x=1;
            	}else{
            		x--;  
            	}
            }  
        } else {  
            
            jQuery(obj).val("1");
            jQuery(obj).focus();  
        } 
        	return x;  
    },  
    reduce : function(obj) {  
        var x = this.amount(obj, false);  
        jQuery(obj).val(x);
        
    },  
    add : function(obj) { 

        var x = this.amount(obj, true);  
        jQuery(obj).val(x); 
        console.log(x);
        
    },  
    modify : function(obj) {  
        var x = jQuery(obj).val();  
        //var max = jQuery('#nAmount').val();  
        if (!this.reg(parseInt(x))) {  
            jQuery(obj).val(1);  
            jQuery(obj).focus();  
            Messager.alert("请输入正确的数量！");
            
            return;  
        }  
        
    }  
}); 