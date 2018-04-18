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
    <div class="bodily" id="modelTouch" wid="#m-" style="background-image: url(assets/images/bodily/male.jpg)">
        <div id="m-head" class="item" positionId="5001"></div>
        <div id="m-thorax" class="item" positionId="5003"></div>
        <div id="m-abdomen" class="item" positionId="5004"></div>
        <div id="m-genital" class="item" positionId="5005"></div>
        <div id="m-leg" class="item" positionId="5006"></div>
        <div id="m-arm" class="item" positionId="5002"></div>
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
			//	java.requestFace(0);
			location.href='face.jsp';
				return;
			}
			java.requestCategory($("#modelTouch").find(".overItem").attr("positionId"));
		}else
		{ 
			if($("#modelTouch").find(".overItem").attr("positionId")=="5001"){
				requestFace(0);	
			//location.href='face.jsp';
				return;
			}
			requestCategory($("#modelTouch").find(".overItem").attr("positionId"));
		}
	}

    scaleStyle($("#modelTouch"), {
        head: $("#m-head"),
        thorax: $("#m-thorax"),
        abdomen: $("#m-abdomen"),
        genital: $("#m-genital"),
        leg: $("#m-leg"),
        arm: $("#m-arm")
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