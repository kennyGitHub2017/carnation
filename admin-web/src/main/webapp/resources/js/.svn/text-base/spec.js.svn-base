String.prototype.trim = function(){  
	return this.replace(/(^\s*)|(\s*$)/g, "");  
} 
var spec_return=(function(){
	var nowIndex;
	$(".js-add-sku-group").click(function(){
		var radom=+new Date();
		var html="<div class=\"sku-sub-group\">";
		html+="<h3 class=\"sku-group-title\">";
		html+="<div class=\"select2-container js-sku-name select2-dropdown-open select2-container-active\" id=\"s2id_"+radom+"\" style=\"width: 100px;\">";
		html+="<a href=\"javascript:void(0)\" onclick=\"return false;\" class=\"select2-choice\" tabindex=\"-1\">";   
		html+="<span class=\"select2-chosen\">&nbsp;</span>";
		html+="<abbr class=\"select2-search-choice-close\"></abbr>";   
		html+="<span class=\"select2-arrow\"><b></b></span>";
		html+="</a>";
		html+="<input class=\"select2-focusser select2-offscreen\" type=\"text\" id=\"s2id_autogen100\" disabled=\"\">";
		html+="</div>";
		html+="<input type=\"hidden\" name=\"sku_name\" value=\"-1\" class=\"js-sku-name select2-offscreen\" tabindex=\"-1\">";
		if($(".js-sku-list-container .sku-sub-group").length==0){					
    		html+="<label for=\"js-addImg-function\" class=\"addImg-radio\">";
        	html+="<input type=\"checkbox\" id=\"js-addImg-function\">添加规格图片</label>";
       	}
        html+="<a class=\"js-remove-sku-group remove-sku-group\">×</a>";	
		html+="</h3>";
		html+="<div class=\"js-sku-atom-container sku-group-cont\"></div>";
		if($(".js-sku-list-container .sku-sub-group").length==0){
			html+="<div class=\"sku-group-cont\" id=\"js-tip-instruction\" style=\"padding: 0px 10px; display: none;\">";
			html+="    <p class=\"help-desc\">目前只支持为第一个规格设置不同的规格图片</p>";
			html+="    <p class=\"help-desc\">设置后，用户选择不同规格会显示不同图片</p>";
			html+="    <p class=\"help-desc\">建议尺寸：640 x 640像素</p>";
			html+="</div>";
		}
		html+="</div>";
		$(".js-sku-list-container").append(html);
		$("#s2id_"+radom).addClass("select2-dropdown-open select2-container-active select2-drop-above");
		nowIndex=$(".select2-container").index($(".select2-dropdown-open")[0]);
		
		
		
		if(!document.getElementById("select2-drop-mask")){
			$("body").append("<div id=\"select2-drop-mask\" class=\"select2-drop-mask\"></div>");					
		}else{
			$("#select2-drop-mask").show();
		}
		
		if(!document.getElementById("select2-drop")){
			$.ajax({
			     type: 'POST',
			     anysc:false,
			     url: $("#webpath").val()+"/admin/get_spec_list.htm",
			    data: {},
			    success: function(data){
			    	console.log(data);
			    	var select2Drop="<div class=\"select2-drop select2-display-none select2-with-searchbox select2-drop-active\" id=\"select2-drop\">";
					select2Drop+="<div class=\"select2-search\">";
					select2Drop+="<input type=\"text\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" spellcheck=\"false\" class=\"select2-input\">";
					select2Drop+="</div>";
					select2Drop+="<ul class=\"select2-results\">";					
					for(var i=0,len=data.length;i<len;i++){						
						select2Drop+="<li data-gid=\""+data[i].id+"\" class=\"select2-results-dept-0 select2-result select2-result-selectable\">";
						select2Drop+="<div class=\"select2-result-label\"><span class=\"select2-match\"></span>"+data[i].name+"</div>";
						select2Drop+="</li>";
					}					
					select2Drop+="</ul>";
					select2Drop+="</div>";
					$("body").append(select2Drop);
					var top=$("#s2id_"+radom).offset().top+$("#s2id_"+radom).height();
					var left=$("#s2id_"+radom).offset().left;
					$("#select2-drop").show().css("top",top).css("left",left).css("width","100px");
			    },
			    dataType: 'json'

			});			
			
		}else{
			var top=$("#s2id_"+radom).offset().top+$("#s2id_"+radom).height();
			var left=$("#s2id_"+radom).offset().left;
			$("#select2-drop").show().css("top",top).css("left",left).css("width","100px");
		}
		
		if($(".js-sku-list-container .sku-sub-group").length>=3){
			$(this).hide();
		}
	});
	
	$(document).delegate('.select2-drop .select2-results li','mouseover',function(){
		$(this).addClass("select2-highlighted").siblings().removeClass("select2-highlighted");
	})
	$(document).delegate('.select2-drop .select2-results li','mouseout',function(){
		$(this).removeClass("select2-highlighted");
	})
	
	$(".sku-group").delegate('a.select2-choice','click',function(){				
		nowIndex=$(".sku-group a.select2-choice").index(this);
		var that=this;
		if($(this).parent().hasClass('select2-dropdown-open select2-container-active')){
			$("#select2-drop").hide();
		}else{
			if(!document.getElementById("select2-drop")){
				$.ajax({
				     type: 'POST',
				     anysc:false,
				     url: $("#webpath").val()+"/admin/get_spec_list.htm",
				    data: {},
				    success: function(data){
				    	console.log(data);
				    	var select2Drop="<div class=\"select2-drop select2-display-none select2-with-searchbox select2-drop-active\" id=\"select2-drop\">";
						select2Drop+="<div class=\"select2-search\">";
						select2Drop+="<input type=\"text\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" spellcheck=\"false\" class=\"select2-input\">";
						select2Drop+="</div>";
						select2Drop+="<ul class=\"select2-results\">";					
						for(var i=0,len=data.length;i<len;i++){						
							select2Drop+="<li data-gid=\""+data[i].id+"\" class=\"select2-results-dept-0 select2-result select2-result-selectable\">";
							select2Drop+="<div class=\"select2-result-label\"><span class=\"select2-match\"></span>"+data[i].name+"</div>";
							select2Drop+="</li>";
						}					
						select2Drop+="</ul>";
						select2Drop+="</div>";
						$("body").append(select2Drop);
						var top=$(that).parent().offset().top+$(that).parent().height();
						var left=$(that).parent().offset().left;
						$("#select2-drop").show().css("top",top).css("left",left).css("width","100px");
						$("#select2-drop-mask").show();
				    },
				    dataType: 'json'

				});			
				
			}else{
				var top=$(this).parent().offset().top+$(this).parent().height();
				var left=$(this).parent().offset().left;
				$("#select2-drop").show().css("top",top).css("left",left).css("width","100px");
				$("#select2-drop-mask").show();
			}
		}
		if(!document.getElementById("select2-drop-mask")){
			$("body").append("<div id=\"select2-drop-mask\" class=\"select2-drop-mask\"></div>");					
		}else{
			$("#select2-drop-mask").show();
		}
		
		$(this).parent().toggleClass("select2-dropdown-open select2-container-active");
	});
	
	function uiPopover(obj,addid){
		var left=$(obj).offset().left-175;
		var top=$(obj).offset().top+20;
		var html="";
		html+="<div id=\"popover"+addid+"\" class=\"ui-popover top-center\" style=\"top: "+top+"px; left: "+left+"px;\">";
		html+="	<div class=\"ui-popover-inner\" style=\"width: 350px;\">";
		html+="		<div class=\"select2-container select2-container-multi js-select2 select2-dropdown-open select2-container-active\" id=\"pop"+addid+"\" style=\"width: 240px;\">";
		html+="		<ul class=\"select2-choices\">  ";
		
		html+="			<li class=\"select2-search-field\">";
		html+="			<input type=\"text\" autocomplete=\"off\" autocorrect=\"off\" autocapitalize=\"off\" spellcheck=\"false\" class=\"select2-input\" id=\"s2id_autogen38\" tabindex=\"-1\" style=\"width: 228px;\">";  
		html+="			</li>";
		html+="		</ul>";
		html+="		</div>";
		html+="		<input type=\"hidden\" class=\"js-select2 select2-offscreen\" style=\"width: 242px;\" tabindex=\"-1\" value=\"2154084\">";
        html+="		<button class=\"ui-btn ui-btn-primary js-save\" style=\"vertical-align: top\">确定</button>";
        html+="		<button class=\"ui-btn js-cancel\" style=\"vertical-align: top\">取消</button>";
		html+="	</div>";
		html+="	<div class=\"arrow\"></div>";
		html+="</div>";
		return html;
	}
	
	function uiDrop(obj,addid){
		var left=$(obj).offset().left-1;
		var top=$(obj).offset().top+$(obj).height()+10;
		var html="";				
		html+="<div id=\"drop"+addid+"\" class=\"select2-drop select2-drop-multi select2-display-none select2-drop-active\" style=\"top: "+top+"px; left: "+left+"px; width: 240px; display: block;\">";   
		html+="	<ul class=\"select2-results\">";
		html+="	</ul>";
		html+="</div>";
		return html;
	}
	
	
	$(".sku-group").delegate('.js-remove-sku-group','click',function(){//移出规格组
		var index=$(".js-remove-sku-group").index(this);
		$(".sku-sub-group").eq(index).remove();
		$(".js-add-sku-group").show();
		if(index==0){
			var checkedHtml="";
			checkedHtml+="<label for=\"js-addImg-function\" class=\"addImg-radio\">";
        	checkedHtml+="<input type=\"checkbox\" id=\"js-addImg-function\">添加规格图片</label>";
        	$(".js-sku-list-container .sku-sub-group").eq(0).find(".js-remove-sku-group").before(checkedHtml);
        	var tipsHtml="";
        	tipsHtml+="<div class=\"sku-group-cont\" id=\"js-tip-instruction\" style=\"padding: 0px 10px; display: none;\">";
			tipsHtml+="    <p class=\"help-desc\">目前只支持为第一个规格设置不同的规格图片</p>";
			tipsHtml+="    <p class=\"help-desc\">设置后，用户选择不同规格会显示不同图片</p>";
			tipsHtml+="    <p class=\"help-desc\">建议尺寸：640 x 640像素</p>";
			tipsHtml+="</div>";
			$(".js-sku-list-container .sku-sub-group").eq(0).find(".js-sku-atom-container").after(tipsHtml);
		}
		inventory_type_change();
	});
	$(".sku-group").delegate('#js-addImg-function','change',function(){//首规格添加规格图片
		if($(this).prop("checked")){
			$("#js-tip-instruction").show();
			$(".sku-sub-group").eq(0).find(".sku-atom").addClass("active");					
			$(".sku-sub-group").eq(0).find(".sku-atom .upload-img-wrap").removeClass("hide");
		}else{
			$("#js-tip-instruction").hide();					
			$(".sku-sub-group").eq(0).find(".sku-atom").removeClass("active");
			$(".sku-sub-group").eq(0).find(".sku-atom .upload-img-wrap").addClass("hide");
		}
	});
	
	$(document).delegate('.select2-with-searchbox .select2-results li','click',function(){
		var addid=$(this).attr("data-gid");
		var list=$(".sku-sub-group .select2-container .select2-focusser.select2-offscreen");
		var flag=false;
		list.each(function(){
			if($(this).val()==addid){
				flag=true;
			}
		});
		if(flag){
			_alert("所选规格已添加");
			return;
		}
		
		$("#select2-drop-mask").hide();
		
		var keywords=$(this).find('.select2-result-label').html().replace(/<[^>]+>/g,"");
		$(".sku-group .select2-chosen").eq(nowIndex).html(keywords);
		$(".sku-sub-group .select2-container .select2-focusser.select2-offscreen").eq(nowIndex).val(addid);
		$("#select2-drop").hide();
		$("#select2-drop .select2-results li").removeClass("select2-selected");
		$("#select2-drop").find(".select2-input").val("");
		$(".sku-group .select2-container").eq(nowIndex).removeClass('select2-dropdown-open select2-container-active');				
		var addStr="<div><div class=\"js-sku-atom-list sku-atom-list\"></div><a data-addid="+addid+" href=\"javascript:;\" class=\"js-add-sku-atom add-sku\" style=\"display: inline-block;\">+添加</a></div>";
			
		$(".js-sku-atom-container").eq(nowIndex).html(addStr);
		$("[id^=popover]").hide();
		$("[id^=drop]").hide();				
	});
	
	$(".sku-group").delegate(".js-add-sku-atom","click",function(){//添加按钮事件
		var addid=$(this).attr("data-addid");
		if($("#popover"+addid).css("display")=="block") return;
		if(document.getElementById("popover"+addid)){
			$("#popover"+addid).show().find(".select2-input").focus();
			autoChangePopoverPosition(addid);
		}else{
			var uiPopoverHtml=uiPopover(this,addid);
			$("body").append(uiPopoverHtml);
			$("#popover"+addid).find(".select2-input").focus();
		}				
	});
	
     
     $(document).delegate(".ui-popover .select2-input","keydown",function(e){
    	 if (e.keyCode == 13) {
    		 $(this).closest(".ui-popover-inner").find(".js-save").trigger("click"); 
         }  
     }); 
	
	
	//弹出框确定按钮事件
	$(document).delegate(".ui-popover .js-save","click",function(){
		var index=$(this).closest("[id^=popover]").attr("id").replace("popover","");
		var list1= $(".js-add-sku-atom[data-addid="+index+"]").prev(".js-sku-atom-list").find(".sku-atom span[data-atom-id]");
		var skuname=$("#pop"+index).find(".select2-input").val();
		if(skuname==""){
			_alert('规格不能为空');
			return;
		}
		var flag=false;
		list1.each(function(){
			if(skuname==$(this).html()){
				flag=true;
			}
		})
		if(flag){
			_alert('所选规格已存在');
			return;
		}
		
		var groupIndex=$(".js-add-sku-atom[data-addid]").index($(".js-add-sku-atom[data-addid="+index+"]"));		
		$.ajax({
		     type: 'POST',
		     anysc:false,
		     url: $("#webpath").val()+"/admin/goods_property_save_batch.htm",
		    data: {specId:index,propertyName:skuname},
		    success: function(data){
		    	var appendStr="";
		    	//console.log(data);
		    	var dta=data[0];
		    	
	    		if($("#js-addImg-function").prop("checked")&&groupIndex==0){
					appendStr+="<div class=\"sku-atom active\"><span data-atom-id=\""+dta.id+"\">"+dta.value+"</span>";
					appendStr+="<div class=\"atom-close close-modal small js-remove-sku-atom\">×</div>";
					appendStr+="<div class=\"upload-img-wrap\">";
					appendStr+="    <div class=\"arrow\"></div>";
					appendStr+="    <div class=\"js-upload-container\" style=\"position:relative;\">";				        
					appendStr+="            <div class=\"add-image js-btn-add\">+</div>";      
					appendStr+="    </div>";
					appendStr+="</div>";				
					appendStr+="</div>";
				}else{
					appendStr+="<div class=\"sku-atom\"><span data-atom-id=\""+dta.id+"\">"+dta.value+"</span>";
					appendStr+="<div class=\"atom-close close-modal small js-remove-sku-atom\">×</div>";
					appendStr+="<div class=\"upload-img-wrap hide\">";
					appendStr+="    <div class=\"arrow\"></div>";
					appendStr+="    <div class=\"js-upload-container\" style=\"position:relative;\">";				        
					appendStr+="            <div class=\"add-image js-btn-add\">+</div>";      
					appendStr+="    </div>";
					appendStr+="</div>";				
					appendStr+="</div>";
				}
		    	
				$(".js-add-sku-atom[data-addid="+index+"]").prev(".js-sku-atom-list").append(appendStr);
								
				//关闭
				autoChangePopoverPosition(index);
				$("#pop"+index).find(".select2-input").focus().val("");
				$("[name=inventoryType]").eq(1).prop("checked","checked");
				inventory_type_change();
		    	
		    },
		    dataType: 'json'

		});
	});
	
	//弹出框取消按钮
	$(document).delegate(".ui-popover .js-cancel","click",function(){
		var index=$(this).closest("[id^=popover]").attr("id").replace("popover","");
		$("#pop"+index+" .select2-choices .select2-search-choice .select2-search-choice-close").trigger("click");
		$("#pop"+index+" .select2-choices .select2-search-choice").remove();
		$("#popover"+index).hide();
		$("#drop"+index).hide();
	});	
	
	//动态改变drop位置
	function autoChangeDropPosition(index){
		var obj=$("#pop"+index).find(".select2-input");
		if(!obj[0]){
			return;
		}
		var left=obj.offset().left-1;
		var top=obj.offset().top+obj.height()+10;
		$("#drop"+index).css("left",left).css("top",top);
	}
	//改变popover位置
	function autoChangePopoverPosition(index){
		var obj=$(".js-add-sku-atom[data-addid="+index+"]");
		if(!obj[0]){
			return;
		}
		var left=obj.offset().left-175;
		var top=obj.offset().top+20;
		$("#popover"+index).css("left",left).css("top",top);
	}
	
	//规格删除按钮事件处理
	$(".sku-group").delegate(".js-remove-sku-atom","click",function(){
		var index=$(this).closest(".js-sku-atom-list").next(".js-add-sku-atom").attr("data-addid");
		var id=$(this).prev("span").attr("data-atom-id");
		$(this).closest(".sku-atom").remove();
		$.ajax({
		     type: 'POST',
		     url: $("#webpath").val()+"/admin/goods_property_delete.htm",
		    data: {id:id},
		    success: function(data){
		    },
		    dataType: 'json'
		});
		
		inventory_type_change();
		$("#drop"+index).find(".select2-results li[data-id="+id+"]").removeClass("select2-selected").removeAttr("data-used");		
		autoChangePopoverPosition(index);
		autoChangeDropPosition(index);
		//
	});
	
	//规格搜索框事件
	$(document).delegate("#select2-drop .select2-input","input",function(){
		var value=$(this).val().trim();
		var all=$("#select2-drop .select2-results li");
		if(value!=""){					
			all.each(function(){
				$(this).removeClass("select2-selected");
				if($(this).find(".select2-result-label").html().replace(/<[^>]+>/g,"").indexOf(value)>-1){
					
				}else{
					$(this).addClass("select2-selected");
				}
			});
		}else{
			all.removeClass("select2-selected");
		}
		
		
	});			
	
	$(document).delegate('#select2-drop-mask','click',function(){
		$(this).hide();
		$("#select2-drop").hide();
		$("#select2-drop .select2-results li").removeClass("select2-selected");
		$("#select2-drop").find(".select2-input").val("");
		$(".js-sku-name").removeClass("select2-dropdown-open select2-container-active");
	});
	
	
	//规格图片上传弹框
	function showModelFixed(){
		if(document.getElementById("modelFixed")){
			document.getElementById("modelFixed").style.display="block";
		}else{
			var ele=document.createElement("div");
			ele.id="modelFixed";
			document.body.appendChild(ele);
		}
	}
	function hideModelFixed(){
		if(document.getElementById('modelFixed')){
			document.getElementById('modelFixed').style.display="none";
		}
	}
	//规格图片上传点击事件
	var obj_uploadImgCon=null;
	$(".sku-group").delegate(".upload-img-wrap .js-upload-container .add-image","click",function(){
		showModelFixed();
		$("#imgUploadCon").show();
		obj_uploadImgCon=$(this).parent();		
	});
	//图片上传弹框关闭
	$("#imgUploadCon .close").click(function(){
		$("#imgUploadCon").hide();
		$("#spec_pic").val("");
		$("#imgUploadCon .upload-local-image-list .js-remove-attachment").trigger("click");
		$(".upload_input_dialog").val("");
		$("#imgUploadCon .js-confirm").removeClass("ui-btn-primary").addClass("ui-btn-disabled");
		hideModelFixed();
	});
	
	//图片上传成功之后的移出事件
	$("#imgUploadCon .upload-local-image-list").delegate(".js-remove-attachment","click",function(){
		$("#imgUploadCon .upload-local-image-item").remove();
		$("#imgUploadCon .js-add-local-attachment").show();
		$("#imgUploadCon .modal-footer .ui-btn").removeClass("ui-btn-primary").addClass("ui-btn-disabled");
		$(".upload_input_dialog").val("");
	});
	
	//图片异步上传事件
	function event_imgUpload(url){
		var str="";
		str+="<li class=\"upload-local-image-item\">";
    	str+="	<div class=\"image-box\" style=\"background-image: url("+url+")\"></div>";
		str+="	<a href=\"javascript:;\" class=\"close-modal small js-remove-attachment\">×</a>";
		str+="</li>";
		$("#imgUploadCon ul.upload-local-image-list").html(str);
		$("#imgUploadCon .js-add-local-attachment").hide();
		$("#imgUploadCon .modal-footer .ui-btn").addClass("ui-btn-primary").removeClass("ui-btn-disabled");
	}
	
	/*jQuery(".upload_input_dialog").live("change",function(){
		var eid = this.id;
		jQuery.ajaxFileUpload({
	            url:$("#webpath").val()+'/seller/goods_property_img_upload.htm?propertyId='+propertyId,			
				url : $("#webpath").val()+'/seller_apply/image_save.htm?mark='+ "id_card_reverse",
	            
	            fileElementId:[eid],
	            fileFilter : ".jpg,.gif,.png",
				fileSize : 1048576,
	            dataType: 'json',                
	            success: function (data){
	            	console.log(data);
	            	event_imgUpload(data);
	        		$("#tempURL").val(data);
				}
			});
	})*/
	jQuery(".local-image-region")
	.on(
			"change",":file[mark]",
			function() {
				var that = jQuery(this), mark = that.attr("mark");
				var eid = this.id;

			

			jQuery.ajaxFileUpload({
							url:$("#webpath").val()+'/admin/goods_property_img_upload.htm?mark='+mark,
							fileElementId : [ eid ],
							fileFilter : ".jpg,.gif,.png",
							fileSize : 1048576,
							dataType : "text",
							success : function(data) {											
								//console.log(data);
								event_imgUpload(data);
				        		$("#tempURL").val(data);
							}
						});
			});
	
/*	$(".upload_input_dialog").change(function(){
		var propertyId=obj_uploadImgCon.closest(".sku-atom").find("span[data-atom-id]").attr("data-atom-id");
		jQuery.ajaxFileUpload({
            url:$("#webpath").val()+'/seller/goods_property_img_upload.htm?propertyId='+propertyId,			
			url : $("#webpath").val()+'/seller_apply/image_save.htm?mark='+ "id_card_reverse",
            
            fileElementId:['upload_input_dialog'],
            fileFilter : ".jpg,.gif,.png",
			fileSize : 1048576,
            dataType: 'json',                
            success: function (data){
            	console.log(data);
            	event_imgUpload(data);
        		$("#tempURL").val(data);
			}
		});
		
	});*/
	
	//图片上传弹出框确定按钮
	$("#imgUploadCon .js-confirm").click(function(){
		if($(this).hasClass("ui-btn-disabled")){
			_alert("请上传图片");
			return;
		}
		obj_uploadImgCon.attr("url",$("#tempURL").val());
		$("#imgUploadCon .close").trigger("click");
		var html="";
		var tempURL=$("#tempURL").val();
		html+="<div class=\"js-enter-wrap\">";
        html+="    <a href=\"javascript:;\" class=\"close-modal small js-btn-close\" title=\"删除\">×</a>";
        html+="    <img src=\""+tempURL+"\" class=\"js-img-preview\">";
        html+="    <div class=\"img-edit js-btn-edit\">替换</div>";
        html+="</div>";
		obj_uploadImgCon.html(html);
	});
	
	//规格图片删除按钮
	$(".sku-group").delegate(".upload-img-wrap .js-upload-container .js-btn-close","click",function(){
		$(this).parent().parent().removeAttr("url").html("<div class=\"add-image js-btn-add\">+</div>");
	});
	//规格图片替换
	$(".sku-group").delegate(".upload-img-wrap .js-upload-container .js-btn-edit","click",function(){
		showModelFixed();
		$("#imgUploadCon").show();
		obj_uploadImgCon=$(this).closest(".js-upload-container");
	});
	//改造规格属性变化触发的函数
	function inventory_type_change(){
		  getValueItem();
		  var rv=jQuery(":radio[name=inventoryType]:checked").val();
		  if(rv=="all"){
			 jQuery("#inventory_detail_content").empty(); 
		     jQuery("#inventory_detail").hide();
		  }else{
		  	jQuery("#inventory_detail_content").empty();
			var goods_spec_ids="";
			  jQuery(".js-sku-atom-container .js-sku-atom-list .sku-atom span[data-atom-id]").each(function(){
			     goods_spec_ids=jQuery(this).attr("data-atom-id")+","+goods_spec_ids;
			  });
			  //console.log(goods_spec_ids);
			  if(goods_spec_ids!=""){
			   jQuery.post($("#webpath").val()+"/admin/goods_inventory.htm",{"goods_spec_ids":goods_spec_ids},function(data){
			     jQuery("#inventory_detail_content").append(data);	
				 jQuery("#inventory_detail").show();
				 setValueItem();
				 if(jQuery("#inventory_detail_content>table").height()>=350){
				    jQuery("#inventory_detail_content").css({"width":"98%","height":"350px","overflow":"auto"});
				  }else{
				    jQuery("#inventory_detail_content").css({"width":"98%","height":"auto","overflow":"auto"});
				  }	
			    },"text");		   

			  }else{
			     jQuery("#inventory_detail").hide();
			  }
		 }
		 
	}
	
	
	//获取value值 保存
	function getValueItem(){
		var jsonstr="[]";
		var item = eval('('+jsonstr+')');
		$('input[id^="inventory_details_"]').each(function () {
			var arr = {
				"id":this.id,
				"value":this.value
			};
            //console.log("id:"+arr.id+"value:"+arr.value);
            item.push(arr);
        });
		sessionStorage.setItem("item", JSON.stringify(item)); 
		//console.log(JSON.stringify(item));
	}
	
	//获取value值 设置
	function setValueItem(){
		var item = JSON.parse(sessionStorage.getItem("item")); 
		for(var i=0; i<item.length; i++){
			$("#"+item[i].id).val(item[i].value);
		}
	}

	
	
	//提示框
	var _alertTimeId=null;
	function _alert(str){
		if(!document.getElementById("js-notifications")){
			var ele_alert=document.createElement("div");
			ele_alert.className="js-notifications notifications";
			ele_alert.id="js-notifications";
			document.body.appendChild(ele_alert);
		}
		var alert_dom=document.getElementById("js-notifications");
		alert_dom.innerHTML="<div class=\"alert in fade alert-error\">"+str+"</div>";
		setTimeout(function(){
			alert_dom.style.top="35px";
		},1);
		if(_alertTimeId){
			clearTimeout(_alertTimeId);
		}
		_alertTimeId=setTimeout(function(){
			alert_dom.style.cssText="";
			_alertTimeId=null;
		},2000);
		
	}
	
	return {
		_alert
	};
	
	// 
})();
