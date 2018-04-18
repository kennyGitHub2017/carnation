$("#questionContent .questionList .timu").each(function(i){
				$(this).find(".option a").click(function(){					
					$(this).addClass("curr").siblings("a").removeClass("curr");
					if(!$(this).parent().attr("data-done")){
						$(this).parent().attr("data-done",true);
						showNextQuestionOption();
					}
				});
			});
			$("#submitBtn").click(function(){
				//var score=calcScore();
				var webPath = $("#webPath").val(); 
				window.location.href=webPath+"/v1/cm/result";
			});
			var timuIndex=0;
			var $timu=$(".timu");
			var questionCount=$(".timu").length;
			var screenHeight=window.innerHeight||document.documentElement.clientHeight;
			function showNextQuestionOption(){
				var $option=$(".fn-hide");
				var length=$option.length;
				timuIndex++;
				if(length>=2){
					$option.eq(0).removeClass("fn-hide");
					var top =parseInt($timu.eq(timuIndex).offset().top)-screenHeight/2+"px";		
					$("html,body").animate({scrollTop:top},500);
				}else if(length==1){
					$option.eq(0).removeClass("fn-hide");
					var top =parseInt($("#submitBtn").offset().top)-screenHeight/2+"px";
					$("html,body").animate({scrollTop:top},500);
				}
				$timu.eq(timuIndex).addClass("curr");
				var process=parseInt(timuIndex/questionCount*100);
				$(".progressBar .bar").css("width",process+ "%");
			}
			
			function calcScore(){
				var score=0;
				$("#questionContent .questionList .timu").each(function(){
					if($(this).find(".option").length>0){
						var thisScore= parseInt($(this).find(".option .curr").attr("data-score"));
						score+=thisScore;			
					}
				});
				$("#questionContent .questionList .timu .popSelectBtn").each(function(){
					score+=parseInt($(this).attr("data-get"));
				});
				return score;
			}
			
			(function($) {
				$.init();
				var popBtns=$('.popSelectBtn');
				popBtns.each(function(i, popBtn) {
					popBtn.addEventListener('tap', function() {
						var that=this;
						var popPicker = new $.PopPicker();
						var arrData=eval("("+this.getAttribute("data-arr")+")");
						popPicker.setData(arrData);
						popPicker.show(function(items) {
							that.innerHTML=items[0].text;
							jQuery(that).attr("data-get",items[0].value);
							if(!jQuery(that).attr("data-done")){
								jQuery(that).attr("data-done",true);
								showNextQuestionOption();
							}
							popPicker.dispose();
						});
					}, false);
				});	
					
			})(mui);