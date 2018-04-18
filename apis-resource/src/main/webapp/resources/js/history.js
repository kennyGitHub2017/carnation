		          
	var draw=(function(){
			var tScale  = window.devicePixelRatio,
            tWidth=	document.documentElement.clientWidth;	        

        	//画表格边框
    	 	function drawlinegrid(ctx) {
	            ctx.beginPath();
	            for (var i = 0; i <= 6; i++) {
	                var y = i * tWidth * 0.7 / 6 + 0.3 * tWidth / 2;
	                ctx.moveTo(y * tScale, 0);
	                ctx.lineTo(y * tScale, -150 * tScale);
	            }
	            ctx.moveTo(0, 0);
	            ctx.lineTo(tWidth * tScale, 0);
	            ctx.lineWidth = 1 * tScale;
	            ctx.strokeStyle = "#d4d3d3";
	            ctx.stroke();
	        }

	        //画刻度
	        function drawNum(ctx,arr){
	                ctx.beginPath();
	                ctx.fillStyle="#999";
	                ctx.font=12*tScale + "px Arial";
	                ctx.textAlign="center";
	                ctx.textBaseline="bottom";
	                ctx.fillText(arr[0],0.3 * tWidth / 4*tScale,0);
	                ctx.fillText(arr[1],0.3 * tWidth / 4*tScale,-60*tScale);
	                ctx.fillText(arr[2],0.3 * tWidth /4*tScale,-120*tScale);
            }

            //画折线
            function drawHline(ctx,data,kedu,color){
	                var pointsH = [];
	                for( var i=0; i < data.length; i++){
	                    var v= data[i];
	                    var px = i * tWidth * 0.7 / 6 + 0.3 * tWidth / 2;
	                    var py = v/kedu*150;
	                    pointsH.push({"x":px*tScale,"y":-py*tScale});
	                }
	                ctx.beginPath();
	                ctx.moveTo(pointsH[0].x, pointsH[0].y);
	                for(var i= 1; i< pointsH.length; i++){
	                    ctx.lineTo(pointsH[i].x,pointsH[i].y);
	                }
	                ctx.lineWidth = 2*tScale;
	                ctx.strokeStyle = color;
	                ctx.stroke();
	
	                ctx.font=11*tScale + "px Arial";
	                ctx.textAlign="center";
	                ctx.textBaseline="bottom";
	                for(var i=0;i<pointsH.length;i++){
	                    ctx.beginPath();
	                    ctx.fillStyle=color;
	                    ctx.fillText(data[i],pointsH[i].x, pointsH[i].y-10*tScale);
	                    ctx.arc(pointsH[i].x,pointsH[i].y,3*tScale,0,2*Math.PI,false);
	                    ctx.fill();
	                }
            }

            return function(id,arrKedu,data,kedu,color,data2,color2){
		            	var obj=document.getElementById(id),
			                ctx=obj.getContext("2d");
				        obj.style.width = tWidth + "px";
				        obj.style.height =  "150px";
				        obj.width = tWidth * tScale;
				        obj.height = 150 * tScale;
				        ctx.translate(0,150*tScale);
            	    	drawlinegrid(ctx);
				    	drawNum(ctx,arrKedu);
				    	if(arguments.length>5){
				    		drawHline(ctx,data,kedu,color);
				    		drawHline(ctx,data2,kedu,color2);
				    	}else{
				    		drawHline(ctx,data,kedu,color);
				    	}
				    	
            }

		})();            	

		