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
    <div class="male-avatar" id="modelTouch" wid="#lady-" style="background-image: url(assets/images/face/woman.jpg)">
		
		<div id="lady-head" class="item" style="display: block;" positionId="5"></div>
        <div id="lady-eye" class="item" positionId="7"></div>
        <div id="lady-face" class="item" positionId="9"></div>
        <div id="lady-nose" class="item" positionId="10"></div>
        <div id="lady-ear" class="item" positionId="8"></div>
        <div id="lady-mouth" class="item" positionId="11"></div>
        <div id="lady-chin" class="item" positionId="12"></div>
        <div id="lady-brow" class="item" positionId="6"></div>
        
    </div>
</div>

<script src="assets/js/jquery-2.1.4.min.js"></script>
<script src="assets/js/page/apparatus.js"></script>

<script>

	function callback() {
		if(isAndroid)
		{			
			java.requestCategory($("#modelTouch").find(".overItem").attr("positionId"), 2);
		}
		if(isiOS)
		{
			requestCategory($("#modelTouch").find(".overItem").attr("positionId"), 2);
		}
	}

    scaleStyle($("#modelTouch"), {
        mouth: $("#lady-mouth"),
        nose: $("#lady-nose"),
        eye: $("#lady-eye"),
        brow: $("#lady-brow"),
        head: $("#lady-head"),
        chin: $("#lady-chin"),
        face: $("#lady-face"),
        ear: $("#lady-ear")
    }, callback);


</script>
</body>
</html>