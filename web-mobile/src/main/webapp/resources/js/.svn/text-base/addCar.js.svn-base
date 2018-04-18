(function($){

  var addCar={
    //匹配正则
    amountReg:/^\d+$/,
    //初始化
    init:function(){
     /* this.add();*/
      /*this.minus();*/
      this.totalAmount();
      this.edit();
      this.bill_delete();
    },
    //增加数量
  	/*add:function(){

  		$(".wrapper").on("click",".btn-jia",function(){
        
  			var num=$(this).prev("input.amount").val();

        if(!num||!(addCar.amountReg.test(num))){
          num=1;
        }else{
           num++;
        }
       $(this).prev("input.amount").val(num);
       addCar.totalAmount();
      });
  	},*/
    //减少数量
   /* minus:function(){
      $(".wrapper").on("click",".btn-jian",function(){
        var num=$(this).next("input.amount").val();
        if(num&&addCar.amountReg.test(num)&&num>1){
          num--;
          $(this).next("input.amount").val(num);
        }
       addCar.totalAmount();
      });
    },*/
    //合计和结算
    totalAmount:function(){
      var total_amount=0.0;
      var  items= $(".cart_item .fl.c_checkbox:checked");
      items.each(function(){
        var item=$(this).parent(".cart_item");
         var price=item.find(".price").text().replace("¥","");
         var num=item.find(".amount").val();

         if(price&&num){
           total_amount+=price*num;
         }
        
      });
      $(".addcar-jies .jies-heji").text("应付款：¥ "+ total_amount.toFixed(1));
      $(".addcar-jies .jies-btn").text("结算("+items.size()+")");
    },
    //编辑
   edit:function(){
      var html=$(".jies-btn").text();
      $(".editor").click(function(){
      	 var text=$(this).find('span').text();
      	 if(text=='完成'){
      	 	$(this).find('span').text('编辑');
      	 }else{
      	 	$(this).find('span').text('完成');
      	 }
        if($(".jies-btn").text()=='删除'){
           $(".jies-btn").text(html);           
          $(".jies-btn").css("background","#19bf96 none repeat scroll 0 0");
        }else{
          $(".jies-btn").text('删除');
          $(".jies-btn").css("background","#30c5a0 none repeat scroll 0 0");
        }
    	})
   },

   //结算或者删除
   bill_delete:function(){
     $(".jies-btn").click(function(){
       var  items= $(".cart_item .fl.c_checkbox:checked");
        if(items.size()==0){
        	tipsbox("请选中商品");
          return;
        }
       if($(".jies-btn").text()=='删除'){
           more_big_cart_remove();
          items.each(function(){
            $(this).parent().remove();
          });
          $(".cart_list").each(function(){
          	 if($(this).find(".cart_item").length==0){
          	 		$(this).remove();
          	 }
          });
          //shanchu
          addCar.totalAmount();
        }else{
        	 if($("a.noselect-address").length){
		       	  tipsbox("请填写收货地址");
		       	  return;
		      }
        	confirm_cart();
        }
     });
   }
  }
  //调用初始化
   $(document).ready(function(){
   	 addCar.init();
    $('input.amount').on('input propertychange', function() {  
        if(!addCar.amountReg.test($(this).val())){
          $(this).val(1);
        }
    });
   });
   //商品的选中或者商家的选中进行修改合计和结算
   $(document).ready(function(){
      //点击商品复选框
      $(".wrapper").on("change",".fl.c_checkbox",function(){
   
    	  if($(".wrapper input[type='checkbox']").length==$(".wrapper input[type='checkbox']:checked").length){
     	 		$("#cart_check_all").prop("checked",true);
     	 	 }else{
        	 		$("#cart_check_all").removeAttr("checked");
        	 		if($(this).parent().hasClass('cart_item')){
        	 			var length=$(this).parent().parent().find(".cart_item  input[type='checkbox']:checked").length;       
        	 			if(length==0){
        	 				$(this).parent().parent().find(".shop_title .fl.c_checkbox").removeAttr("checked");
        	 			}
        	 			else if(length>0){
        	 				$(this).parent().parent().find(".shop_title .fl.c_checkbox").prop("checked",true);
        	 			}
        	 		}
        	 		 
       	 	 }

          if($(".jies-btn").text()=='删除'){
               addCar.bill_delete();
         }else{
             addCar.totalAmount();
         }
          
       });
      //选中商家或者商品
      $(".wrapper").on("change",".shop_title .fl.c_checkbox",function(){
         if($(this).prop("checked")){
            $(this).parent().parent().find(".cart_item .fl.c_checkbox").prop("checked",true);

         }else{
            $(this).parent().parent().find(".cart_item .fl.c_checkbox").removeAttr("checked");
         }
         if($(".wrapper input[type='checkbox']").length==$(".wrapper input[type='checkbox']:checked").length){
   	 		$("#cart_check_all").prop("checked",true);
   	 	 }else{
   	 		$("#cart_check_all").removeAttr("checked");
   	 	 }
         if($(".jies-btn").text()=='删除'){
            addCar.bill_delete();
         }else{
           addCar.totalAmount();
         }
       });
      //判断是否要全选按钮选中
      $(".wrapper").on("change","input[type='checkbox']",function(){
      	 if($(this).prop("checked")){
      	 	if($(".wrapper input[type='checkbox']").length==$(".wrapper input[type='checkbox']:checked").length){
      	 		$("#cart_check_all").prop("checked",true);
      	 	}else{
       	 		$("#cart_check_all").removeAttr("checked");
      	 	 }
      	 }
      });
      //全选
      $("#cart_check_all").on("change",function(){

        if($(this).prop("checked")){
             $(".content").find("input[type='checkbox']").prop("checked",true);

         }else{
           $(".content").find("input[type='checkbox']").removeAttr("checked");
         }
         if($(".jies-btn").text()=='删除'){
           addCar.bill_delete();
         }else{
           addCar.totalAmount();
         }
         
       });
   })
})(jQuery);