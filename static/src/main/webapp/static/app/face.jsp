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
    <div class="male-avatar" id="modelTouch" wid="#male-" style="background-image: url(assets/images/face/male.jpg)">
        <div id="male-head" class="item" style="display: block;" positionId="5"></div>
        <div id="male-eye" class="item" positionId="7"></div>
        <div id="male-face" class="item" positionId="9"></div>
        <div id="male-nose" class="item" positionId="10"></div>
        <div id="male-ear" class="item" positionId="8"></div>
        <div id="male-mouth" class="item" positionId="11"></div>
        <div id="male-chin" class="item" positionId="12"></div>
        <div id="male-brow" class="item" positionId="6"></div>
    </div>
</div>

<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/page/apparatus.js"></script>

<script>

	function callback() {
		if(isAndroid)
		{
			java.requestCategory($("#modelTouch").find(".overItem").attr("positionId"), 1);
		}
		if(isiOS)
		{
			requestCategory($("#modelTouch").find(".overItem").attr("positionId"), 1);
		}
		
	}

    scaleStyle($("#modelTouch"), {
        mouth: $("#male-mouth"),
        nose: $("#male-nose"),
        eye: $("#male-eye"),
        brow: $("#male-brow"),
        head: $("#male-head"),
        chin: $("#male-chin"),
        face: $("#male-face"),
        ear: $("#male-ear")
    }, callback);


    
    
</script>
</body>
</html>