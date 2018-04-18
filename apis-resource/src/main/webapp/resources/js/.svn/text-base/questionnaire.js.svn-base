$(document).ready(function(){
			var screenWidth=window.innerWidth||document.documentElement.clientWidth;
        	document.documentElement.style.fontSize = parseInt(screenWidth /7.5 ) + "px";       	
        	
        	
        	function showSmallTips(str){
        		if(document.getElementById("smallTips")) return;
        		$html=$("<div id=\"smallTips\">"+str+"</div>");
        		$("body").append($html);
        		var obj=document.getElementById("smallTips");
        		setTimeout(function(){
        			fn.setTransition(obj,0.2);
        			obj.style.opacity=1;
        			fn.translate(obj,"-50%","-50px"); 
        		},1);
        		setTimeout(function(){
        			document.body.removeChild(obj);
        		},2500);
        		
        	}
			
			var $question=$("#questionArea .question")
			var questionCount=$question.length;
			var answer=[];
			var fixedTopHeight=parseInt($(".fixedTop").css("height"));
			for(var i=0;i<questionCount;i++){
				answer.push(0);
			}
			
			$(".question ul").each(function(){
				var $that=$(this).find("span");
				$that.click(function(){
					$(this).addClass("curr").parent().siblings("li").find("span").removeClass("curr");
					var questionIndex=$question.index($(this).closest(".question"));
					var ansIndex=$that.index($(this))+1;
					answer[questionIndex]=ansIndex;
					var answered=0;
					for(var i=0;i<questionCount;i++){
						if(answer[i]!=0) answered++;
					}
					var process=parseInt(answered/questionCount*100);
					$(".processBar .wraper i").css("width",process+ "%");
					$("#number").html(process);
				});
			});
			
			$("#submitBtn").click(function(){
				if(document.getElementById("smallTips")) return;				
				for(var i=0;i<questionCount;i++){
					if(answer[i]==0){
						$("html,body").animate({scrollTop:$question.eq(i).find(".title").offset().top-fixedTopHeight},200);
						showSmallTips("请答完所有题目再提交");
						return;
					}
				}
				showSmallTips("提交成功！");
			});
			
			
		});