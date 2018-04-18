<!DOCTYPE html>
<html>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" id="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1" />

    <title>我的问答</title>

    <%@ include file="include/inc_css.jsp"%>
</head>
<body class="gray-bg">
<div class="model-wrap">
    <div class="bodily" id="modelTouch" wid="#w-" style="background-image: url(assets/images/bodily/woman.jpg)">
        <div id="w-head" class="item" positionId="5001"></div>
        <div id="w-thorax" class="item" positionId="5003"></div>
        <div id="w-abdomen" class="item" positionId="5004"></div>
        <div id="w-genital" class="item" positionId="5005"></div>
        <div id="w-leg" class="item" positionId="5006"></div>
        <div id="w-arm" class="item" positionId="5002"></div>
  </div>
</div>
<a href="javascript:void(0);" class="bodily-btn" id="figureCalculaterBtn" style="display:none"><img src="assets/images/bodily-btn.png" /></a>
<a href="javascript:void(0);" class="skin-btn" id="skinCalculaterBtn" style="display:none"><img src="assets/images/skin-btn.png" /></a>

<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/page/apparatus.js"></script>

<script>
	function callback() {
		if(isAndroid)
		{
			if($("#modelTouch").find(".overItem").attr("positionId")=="5001"){				
				//java.requestFace(1);	
				location.href='faceLady.jsp';
				return;
			}
			java.requestCategory($("#modelTouch").find(".overItem").attr("positionId"));
		}else
		{
			if($("#modelTouch").find(".overItem").attr("positionId")=="5001"){
				requestFace(1);
				//location.href='faceLady.jsp';
				return;
			}
			requestCategory($("#modelTouch").find(".overItem").attr("positionId"));
		}
	}

    scaleStyle($("#modelTouch"), {
        head: $("#w-head"),
        thorax: $("#w-thorax"),
        abdomen: $("#w-abdomen"),
        genital: $("#w-genital"),
        leg: $("#w-leg"),
        arm: $("#w-arm")
    }, callback);
    
    function calculation() {
    	if(isAndroid)
		{
			java.figureCalculater();
		} else {
			figureCalculater();
		}
    }
    
    document.getElementById('figureCalculaterBtn').addEventListener('touchstart', function(e) {
    	calculation();
    });
    
    function skinCalculaterBtn() {
    	if(isAndroid)
		{
			java.requestSkin();
		} else {
			requestSkin();
		}
    }
    document.getElementById('skinCalculaterBtn').addEventListener('touchstart', function(e) {
    	skinCalculaterBtn();
    });

</script>
</body>
</html>