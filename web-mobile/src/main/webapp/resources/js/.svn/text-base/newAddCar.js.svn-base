   $(function(){

        		

	        $("input[name='allCheckedShop']").click(function() {


	        	$(this).parents(".mui-content").siblings(".mui-content").find($("input[type='checkbox']")).prop('checked',false);

	            if(this.checked ==  true){
	               $(this).parent(".car_shop").siblings(".OA_task_1").find($("[type='checkbox'][name='choose']")).prop('checked', true);
	               
	            }else{
	               $(this).parent(".car_shop").siblings(".OA_task_1").find($("[type='checkbox'][name='choose']")).prop('checked', false);
	              
	            }
	            //调整商品数量
	            goodsCountAdjust();
	            
	        });
	        $("input[name='choose']").click(function(event) {

	         $(this).parents(".mui-content").siblings(".mui-content").find($("input[type='checkbox']")).prop('checked',false);

	          if($("input[name='choose']:checked").length == $("input[name='choose']").length){

	            $(this).parents(".OA_task_1").siblings(".car_shop").find('input[name=\'allCheckedShop\']').prop("checked", true);


	          }else if($(this).parents(".mui-content").find('input[name=\'choose\']:checked').length == $(this).parents(".mui-content").find('input[name=\'choose\']').length){

	             $(this).parents(".mui-content").find('input[name=\'allCheckedShop\']').prop("checked", true);
	          }else {
	              $(this).parents(".mui-content").find('input[name=\'allCheckedShop\']').prop("checked", false);
	          }
	          //调整商品数量
	          goodsCountAdjust();
	        });



	        /*编辑*/
	        $(".compile").on("click",function(){
	        	$(this).parent().siblings(".OA_task_1").find('.shop_goods_mes').hide();
	        	$(this).parent().siblings(".OA_task_1").find('.shop_goods_mes2').show();
	        	$(this).hide();$(this).siblings(".complete").show();
			});

			/*完成*/
			$(".complete").on("click",function(){
				$(this).parent().siblings(".OA_task_1").find('.shop_goods_mes').show();
				$(this).parent().siblings(".OA_task_1").find('.shop_goods_mes2').hide();
	        	$(this).hide();$(this).siblings(".compile").show();
			});

	        /*加减*/
	        
	         //减
	        $(".shop_goods_mes2").on("click",".center #min",function(){
	        	var goodscount = $(this).siblings("#text_box");
				var num = $(this).parents(".shop_goods_mes2").siblings(".shop_goods_mes").find(".num");

				 if (parseInt(goodscount.val())==1){
		            $(this).attr('disabled',true);
		            return;
		        }
				goodscount.val(parseInt(goodscount.val())-1);
				if(parseInt(goodscount.val())==1){
		        	$(".shop_goods_mes .number input#min").css('background-image', 'url(./images/min2.png)');
		        }
				$(this).attr('disabled',false);

				var number = parseInt(goodscount.val());
		        num.html(number);
		        //调整商品数量
		        goodsCountAdjust($(this).closest("li").attr("id"), number);
			});
			//增加
			$(".shop_goods_mes2").on("click",".center #add",function(){

				var goodscount = $(this).siblings("#text_box");
				var num = $(this).parents(".shop_goods_mes2").siblings(".shop_goods_mes").find(".num");
				goodscount.val(parseInt(goodscount.val())+1);
				 if (parseInt(goodscount.val()) > 1){
				 	$(".shop_goods_mes .number input#min").css('background-image', 'url(./images/min.png)');
		            $('#min').attr('disabled',false);//neng dain
		            $('#add').attr('disabled',false);
		        }else{
		        	$(".shop_goods_mes .number input#min").css('background-image', 'url(./images/min2.png)');
					$('#add').attr('disabled',false);

		        }

		        var number = parseInt(goodscount.val());
		        num.html(number);
		        //调整商品数量
		        goodsCountAdjust($(this).closest("li").attr("id"), number);
			});

			$(".shop_goods_mes2").on("keyup",".center #text_box",function(){

				var goodscount = $(this);
				 if (parseInt(goodscount.val()) > 1){
				 	$(".shop_goods_mes .number input#min").css('background-image', 'url(./images/min.png)');
		            $('#min').attr('disabled',false);//neng dain
		            $('#add').attr('disabled',false);
		        }else{
		        	$(".shop_goods_mes .number input#min").css('background-image', 'url(./images/min2.png)');
					$('#add').attr('disabled',false);
		        }
    			if(isNaN(goodscount.val()) || parseInt(goodscount.val()) < 1){
    				goodscount.val(1);
    			}
    			if(!goodscount.val()){
    				goodscount.val(1);
    			}
    			
    			var num = $(this).parents(".shop_goods_mes2").siblings(".shop_goods_mes").find(".num");
    			var number = parseInt(goodscount.val());
		        num.html(number);
		        //调整商品数量
		        goodsCountAdjust($(this).closest("li").attr("id"), number);
    		});
			
			$(".account_btn").bind("click", function(){
				if($("#has_default_address").val() != "true"){
					mui.confirm('请先填写详细收货地址', '', ['确认', '取消'], function(e) {
						if (e.index == 0) {
							location.href=webPath+"/buyer/address.htm";
						}
					});
					return false;
				}
				var $cbx = $("input[name='choose']:checked");
				if($cbx.length > 0){
					var ids = [];
					$cbx.each(function(){
						var $this = $(this);
						ids.push($this.val());
						$("#gcs_id").val(ids.join(","));
						var name = $this.closest("ul").prev().find(".shop_tit").html();
						if(name == "云购币"){
							$("#goods_type").val("CN");
						}else if(name == "平台商家"){
							$("#goods_type").val("SELLER");
						}else if(name == "云购币专区"){
							$("#goods_type").val("YGB");
						}
						
					});
					$('#cart_form').submit();
				}
			});

     });
   
   	//统计结算订单商品
	function statisGoodsOrder(){
		var $cbx = $("input[name='choose']:checked");
		var totalNum = $cbx.length;
		var totalMoney = 0;
		$cbx.each(function(){
			var $container = $(this).siblings(".shop_goods_mes");
			var price = $.trim($container.find(".price").html().replace("¥", ""));
			var num = $.trim($container.find(".num").html());
			totalMoney += parseFloat(price) * parseFloat(num);
		});
		totalMoney = new Number(totalMoney).toFixed(2);
		$("#total_num").html(totalNum);
		$("#total_money").html("¥ " + totalMoney);
	}
	/* 修改数量 */
	function goodsCountAdjust(goodsId, count, gift_id){
		if(goodsId && count){
			/*var type =  $("#" + goodsId).data("type");
			if(type == "0"){
				if(count > 1){
					mui.alert("F码商品一次只能购买一件!", "提示");	
					$("#" + goodsId).find("#text_box").val(1);
					$("#" + goodsId).find(".num").html(1);
					count = 1;
				}
			}*/
			var gc_id = goodsId.split("_")[1];
			var gcs = "";
			$("input[name='choose']:checked").each(function(){
				var id=jQuery(this).val();
				gcs = id+","+gcs;
			});
			if(gcs==""){
				gcs="-1";//为了和顶部的购物车计算总价区分开，如果gcs为空则会计算购物车所有商品总价，为-1则不会计算任何物品
			}
			$.ajax({
				url: webPath+"/goods_count_adjust.htm",
				data: {"gc_id":gc_id,"count":count,"gcs":gcs,"gift_id":gift_id},
				async: false,
				dataType: "json",
				success: function(data){
					if(data.code=="100"){
						//修改成功
					}else{
						if(data.code == "200" || data.code == "300"){
							mui.alert("库存不足，请重新选择数量", "提示");	
							$("#" + goodsId).find("#text_box").val(1);
							$("#" + goodsId).find(".num").html(1);
							goodsCountAdjust(goodsId, 1, gift_id);
						}else{
							mui.alert("系统繁忙，请稍后重试！", "提示");	
						}
					}
				}
			});
		}
		statisGoodsOrder();
	}